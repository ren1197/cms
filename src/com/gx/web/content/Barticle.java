package com.gx.web.content;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.gx.web.content.QuartzManager;
import com.gx.dao.BArticleCategoryMapper;
import com.gx.dao.BArticleMapper;
import com.gx.po.BArticle;
import com.gx.po.BArticleCategory;
import com.gx.po.BArticleExample;
import com.gx.po.BDingshirenwu;
import com.gx.po.XxFactoryExample;
import com.gx.utils.Page;

import com.gx.utils.ToolsUtils;

@Controller
@RequestMapping("/Article")
public class Barticle {
	@Autowired
	private BArticleMapper ba;
	@Autowired
	private BArticleCategoryMapper ac;

	@RequestMapping("/content/tolist.action")
	public String tolist(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer size, Model model, Integer state, String title, Integer cid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("搜索");
		System.out.println(state);
		System.out.println(title);
		map.put("state", state);
		map.put("title", title);
		map.put("start", (page - 1) * size);
		map.put("size", size);
		List<BArticle> articleList = ba.query(map);
		int total = ba.getTotalSize(map);
		BArticleCategory example2 = new BArticleCategory();
		List<BArticleCategory> type = ac.selectAllCategory(example2);
		// 设置分页参数
		Page<BArticle> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setSize(size);
		pageBean.setRows(articleList);
		pageBean.setTotal(total);
		model.addAttribute("page", pageBean);
		model.addAttribute("type", type);
		return "/content/Article/articlelist";
	}

	// 根据分类ID查找文章
	@RequestMapping("/content/fingbyid.action")
	public String findbyid(Model model, Integer id) {
		List<BArticle> list = ba.findbycategoryid(id);
		BArticleCategory example2 = new BArticleCategory();
		List<BArticleCategory> type = ac.selectAllCategory(example2);
		model.addAttribute("type", type);
		model.addAttribute("list", list);
		return "/content/Article/jFactoryList";
	}

	@RequestMapping("/content/toadd.action")
	public String toadd(Model model) {
		BArticleCategory example = new BArticleCategory();
		List<BArticleCategory> list = ac.selectAllCategory(example);
		model.addAttribute("list", list);
		System.out.println("article toadd");
		return "/content/Article/articleadd";
	}
	// 文章已发布
	@RequestMapping("/content/add.action")
	public String add(BArticle record, MultipartFile pictureFile, Model model, HttpServletRequest request)
			throws Exception {		
		System.out.println("article 已发布");
		//  获取图片完整名称
		String fileStr = pictureFile.getOriginalFilename();
		// 则字符串不为空或空格
		if (fileStr.isEmpty() == false) {
		
			// 将图片保存到硬盘
			// 项目路径
			
			String realPath =request.getSession().getServletContext().getRealPath("/image");
			System.out.println(realPath);
			// 保存文件的路径
			String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
			pictureFile.transferTo(new File(filePath));
			record.setFmimg(fileStr);
		}
		Integer sort = ba.selectMaxSort();
		System.out.println("sort" + sort);
		if (sort == 0 || sort == null || "".equals(sort)) {
			// 将sort值设为1
			record.setOrders(1);
		} else {
			// 否则在最大的sort值上加一
			record.setOrders(sort + 1);
		}
		record.setCreattime(new Date());
		record.setSendtime(new Date());
		record.setState(2);
		ba.insert(record);
		return "redirect:/Article/content/tolist.action";
	}

	// 文章未发布
	@RequestMapping("/content/add2.action")
	public String add2(BArticle record, MultipartFile pictureFile, Model model, HttpServletRequest request)
			throws Exception {
		System.out.println("article 未发布");
		// 获取图片完整名称
		String fileStr = pictureFile.getOriginalFilename();
		if (fileStr.isEmpty() == false) {
			
			//  将图片保存到硬盘
			// 项目路径
			String realPath =request.getSession().getServletContext().getRealPath("/image");
			System.out.println(realPath);
			// 保存文件的路径
			String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
			pictureFile.transferTo(new File(filePath));
			record.setFmimg(fileStr);
		}
		Integer sort = ba.selectMaxSort();
		System.out.println("sort" + sort);
		if (sort == 0 || sort == null || "".equals(sort)) {
			// 将sort值设为1
			System.out.println("oooooooooooooo");
			record.setOrders(1);
		} else {
			// 否则在最大的sort值上加一
			record.setOrders(sort + 1);
		}
		record.setCreattime(new Date());
		record.setSendtime(new Date());
		record.setState(1);
		ba.insert(record);
		return "redirect:/Article/content/tolist.action";
	}

	@RequestMapping("/content/toupdate.action")
	public String toupdate(Model model, Integer id) {
		System.out.println("article toupdate");
		BArticle b = ba.selectById(id);
		model.addAttribute("list", b);
		BArticleCategory example2 = new BArticleCategory();
		List<BArticleCategory> type = ac.selectAllCategory(example2);
		model.addAttribute("type", type);
		return "/content/Article/articleupdate";
	}

	// 修改
	@RequestMapping("/content/update.action")
	public String update(BArticle record, MultipartFile pictureFile, Model model, HttpServletRequest request)
			throws Exception {
		System.out.println("文章update");
		// 获取图片完整名称
		String fileStr = pictureFile.getOriginalFilename();
		if (fileStr.isEmpty() == false) {
			
			//  将图片保存到硬盘
			// 项目路径
			String realPath =request.getSession().getServletContext().getRealPath("/image");
			System.out.println(realPath);
			// 保存文件的路径
			String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
			pictureFile.transferTo(new File(filePath));

			record.setFmimg(fileStr);
		}
		record.setState(2);
		record.setSendtime(new Date());
		ba.updateById(record);
		return "redirect:/Article/content/tolist.action";
	}

	// 未发布
	@RequestMapping("/content/update2.action")
	public String update2(BArticle record, MultipartFile pictureFile, Model model, HttpServletRequest request)
			throws Exception {
		System.out.println("article update2");
		System.out.println("文章update");
		//获取图片完整名称
		String fileStr = pictureFile.getOriginalFilename();
		if (fileStr.isEmpty() == false) {
			
			//  将图片保存到硬盘
			// 项目路径
			String realPath =request.getSession().getServletContext().getRealPath("/image");
			System.out.println(realPath);
			// 保存文件的路径
			String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
			pictureFile.transferTo(new File(filePath));
			record.setFmimg(fileStr);
		}
		record.setState(1);
		record.setSendtime(new Date());
		ba.updateById(record);
		return "redirect:/Article/content/tolist.action";
	}

	// 启用一个或多个
	@RequestMapping("/content/start.action")
	public String start(@RequestParam("id") int[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 2); // 2启用
		map.put("ids", ids);
		ba.updateState(map);
		return "redirect:/Article/content/tolist.action";
	}

	// 停用一个或多个
	@RequestMapping("/content/stop.action")
	public String stop(@RequestParam("id") int[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1); // 1停用
		map.put("ids", ids);
		ba.updateState(map);
		return "redirect:/Article/content/tolist.action";
	}

	// 下线一个或多个
	@RequestMapping("/content/xiaxian.action")
	public String xiaxian(@RequestParam("id") int[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 3); // 3下线
		map.put("ids", ids);
		ba.updateState(map);
		return "redirect:/Article/content/tolist.action";
	}

	// 删除
	@RequestMapping("/content/delete.action")
	public String delete(Integer id) {
		System.out.println("delete");
		ba.deleteById(id);
		return "redirect:/Article/content/tolist.action";
	}

	// 批量删除
	@RequestMapping("/content/deletem.action")
	public String delete(@RequestParam("id") int[] ids) {
		ba.deleteByIds(ids);

		return "redirect:/Article/content/tolist.action";
	}

	// 查看
	@RequestMapping("/content/toview.action")
	public String toview(@RequestParam(value = "id", required = true) Integer id, Model model) {
		BArticle article = ba.selectById(id);
		model.addAttribute("list", article);

		return "/content/Article/view";
	}

	@RequestMapping("/content/movedown.action")
	public void movedown(Integer id, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("下移");
		PrintWriter out = resp.getWriter();

		// 获取要下移的那条数据的信息
		BArticle article = ba.selectById(id);

		// 查询下一条记录
		BArticle next = ba.moveDown(article.getOrders());

		// 最下面的记录不能下移
		if (next == null) {
			System.out.println("进来了");
			out.print("<script>alert('已经是最后一个了');location.href='tolist.action'</script>");
		}
		if (next != null) {
			System.out.println("不空");

			// 交换两条记录的sort值
			Integer temp = article.getOrders();
			article.setOrders(next.getOrders());
			next.setOrders(temp);
			// 更新到数据库
			ba.updateByPrimaryKeySelective(article);
			ba.updateByPrimaryKeySelective(next);
			out.print("<script>location.href='tolist.action'</script>");
		}
		out.close();

	}

	@RequestMapping("/content/moveup.action")
	public void moveup(Integer id, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("上移");
		PrintWriter out = resp.getWriter();
		BArticle article = ba.selectById(id);
		BArticle up = ba.moveUp(article.getOrders());
		if (up == null) {
			out.print("<script>alert('已经是第一个了');location.href='tolist.action'</script>");
		}
		if (up != null) {
			Integer temp = article.getOrders();
			article.setOrders(up.getOrders());
			up.setOrders(temp);
			ba.updateByPrimaryKeySelective(article);
			ba.updateByPrimaryKeySelective(up);
			out.print("<script>location.href='tolist.action'</script>");
		}
		out.close();
	}

	// 一键置顶
	@RequestMapping("/content/moveuptop.action")
	public String moveuptop(Integer id) {
		System.out.println("一键置顶");
		Integer sort = ba.selectMaxSort();
		BArticle article = ba.selectById(id);
		article.setOrders(sort + 1);
		ba.updateByPrimaryKeySelective(article);
		return "redirect:/Article/content/tolist.action";
	}

	// 显示
	@RequestMapping("/content/view.action")
	public String view(@RequestParam(value = "did", required = true) Integer id, Model model) {
		System.out.println("点击下一篇上一篇显示");
		BArticle article = ba.selectById(id);
		model.addAttribute("list", article);

		return "/content/Article/view";
	}

	// 下一篇
	@RequestMapping("/content/next.action")
	public String next(Integer id, Model model, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		System.out.println("下一篇");
		System.out.println(id);
		BArticle article = ba.selectById(id);
		BArticle list = ba.next(article.getOrders());
		model.addAttribute("list", list);
		return "/content/Article/view";

	}

	// 上一篇
	@RequestMapping("/content/pre.action")

	public String pre(Integer id, Model model, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		System.out.println("上一篇");
		System.out.println(id);
		BArticle article = ba.selectById(id);
		BArticle list = ba.pre(article.getOrders());
		model.addAttribute("list", list);
		return "/content/Article/view";

	}
	//启动定时
	 public static String JOB_NAME = "动态任务调度";  
	    public static String TRIGGER_NAME = "动态任务触发器";  
	    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";  
	    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP"; 
	
	    @RequestMapping("/content/startdingshi.action")
	    public String startdingshi(Integer id){
	    	System.out.println(id);
		QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, SendArticle.class, "0/15 * * * * ? *",id);    
		return "redirect:/Article/content/tolist.action";
	}
	

}
