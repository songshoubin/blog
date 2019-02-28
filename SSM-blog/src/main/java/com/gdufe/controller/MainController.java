package com.gdufe.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdufe.entity.Blogger;
import com.gdufe.service.BloggerService;

@Controller
@RequestMapping("/admin")
public class MainController {
	@Autowired
	BloggerService service;
	
	
	@RequestMapping({"/","index.html"})
	public String index() {
		return "/admin/login";
	}

	@RequestMapping("login.do")
	public String login(String username,String password,HttpSession session,Map model) {
		Blogger user =service.verify(username,password);
		if(user!=null) {
			session.setAttribute("user", user);
			return "redirect:/admin/main.do";
		}else {
			model.put("errorInfo", "用户名或密码错误！");
			return "/admin/login";
		}
	}
	
	@RequestMapping("logout.do")
	public String logout(String username,String password,HttpSession session) {
		session.invalidate();
		return "redirect:/admin/";
	}
	
	
	@RequestMapping("main.do")
	public String execute(HttpSession session) {
		
//		Blogger user =service.findByName("sa");
//		
//		session.setAttribute("user", user);
		
		return "/admin/main";
	}

	
}
