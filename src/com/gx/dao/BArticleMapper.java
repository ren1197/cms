package com.gx.dao;

import com.gx.po.BArticle;
import com.gx.po.BArticleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BArticleMapper {
    int countByExample(BArticleExample example);

    int deleteByExample(BArticleExample example);

    int deleteByPrimaryKey(Integer id);

  

    int insertSelective(BArticle record);

    List<BArticle> selectByExampleWithBLOBs(BArticleExample example);

    List<BArticle> selectByExample(BArticleExample example);

    BArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BArticle record, @Param("example") BArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") BArticle record, @Param("example") BArticleExample example);

    int updateByExample(@Param("record") BArticle record, @Param("example") BArticleExample example);

    int updateByPrimaryKeySelective(BArticle record);

    int updateByPrimaryKeyWithBLOBs(BArticle record);

    int updateByPrimaryKey(BArticle record);
    //自定义方法
    int insert(BArticle record);
    
    //列表展示
    List<BArticle> selectAllInfo(BArticle example);
    int  updateById(BArticle record);
    int  updateByDingshiId(Integer id);
    int  updateByXiaxianDingshiId(Integer id);
    BArticle  selectById(Integer id);
    int  deleteById(Integer id);
    int deleteByIds(int[] ids);
    public void updateState(Map<String,Object> map);	//修改状态
    public void updateDingshiState(Map<String,Object> map);	//修改发布定时状态
  
    Integer selectMaxSort();// 查找当前最大的sort值
    BArticle  moveUp(Integer sort);//上移
    BArticle  moveDown(Integer sort);//下移
    public List< BArticle > query(Map<String, Object> map);//分页查询
     // 分页查询数据
 	public int getTotalSize(Map<String, Object> map);
 	 BArticle  next(Integer sort);//下一篇
 	 BArticle  pre(Integer sort);//上一篇
 	public List<BArticle> getEncryptDeviceForExcel(BArticle record);
 	 List<BArticle> selectAllDel(Map<String, Object> map);
 	public int getTotalDelSize(Map<String, Object> map);
 	//彻底删除
 	 int deleteAllByIds(int[] ids);
 	 public void updateDelState(Map<String,Object> map);	//批量恢复
 	public List<Map<String, Object>> getTrainTypeNuminfo(); //统计
 	public List<BArticle> findbycategoryid(Integer id); 
}