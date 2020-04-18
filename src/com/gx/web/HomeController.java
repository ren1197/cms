package com.gx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//系统首页模块
	
	@RequestMapping(value={"/home.action"})	//配合web下<url-pattern>/</url-pattern>
	public String login(){
		
		return "index";			//首页，删除根目录下index.jsp，否则上面url将被拦截进不来
	}
	
	@RequestMapping(value="/fmain.action")
	public String fmain(){
		return "home/fmain";
	}
	
	@RequestMapping(value="/title.action")
	public String title(){
		return "home/title";
	}
	
	@RequestMapping(value="/left.action")
	public String left(){
		return "home/left";
	}
	
	@RequestMapping(value="/main.action")
	public String main(){
		return "home/olmsgList";			//首页转向留言板
	}
	
	//系统管理模块
	
	@RequestMapping("/sysadminMain.do")
	public String sysadminMain(){
		return "sysadmin/main";
	}
	
	@RequestMapping("/sysadminLeft.action")
	public String sysadminLeft(){
		return "sysadmin/left";
	}
	
	//基础信息模块
	
	@RequestMapping("/baseinfoMain.action")
	public String baseinfoMain(){
		return "/baseinfo/main";
	}
	
	@RequestMapping("/baseinfoLeft.action")
	public String baseinfoLeft(){
		return "baseinfo/left";
	}
	
	//商品管理模块
	
	@RequestMapping("cargoMain.action")
	public String cargoMain(){
		return "cargo/main";
	}
	
	@RequestMapping("cargoLeft.action")
	public String cargoLeft(){
		return "cargo/left";
	}
	
	//内容管理模块
	
		@RequestMapping("contentMain.action")
		public String contentMain(){
			return "content/main";
		}
		
		@RequestMapping("contentLeft.action")
		public String contentLeft(){
			return "content/left";
		}
		
		//退款管理模块
		
		@RequestMapping("refundMain.action")
		public String refundMain(){
			return "refund/main";
		}
		
		@RequestMapping("refundLeft.action")
		public String refundLeft(){
			return "refund/left";
		}
}
