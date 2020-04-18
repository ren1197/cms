package com.gx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gx.po.UserPo;
import com.gx.service.UserService;

@Controller
@RequestMapping("/Login")
public class Login {

	@Autowired
	private UserService userService;

	@RequestMapping("/tologin")
	public String tologin() {
		return "/login/login";
	}

	@RequestMapping("/tomain")
	public String tomain(UserPo user, Model model) {
		UserPo u = userService.selectLogin(user);
		if (u != null) {
			return "login/main";
		} else {
			return "login/login";
		}
	}

}
