package com.gdufe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
public class UeController {

	@RequestMapping("/static/ueditor1_4_3_3/jsp/UeController.do")
	public void execute(HttpServletRequest request,HttpServletResponse response , HttpSession session) throws Exception {
	    request.setCharacterEncoding( "utf-8" );
		response.setHeader("Content-Type" , "text/html");
		
		String rootPath = session.getServletContext().getRealPath( "/" );
		PrintWriter out = response.getWriter();
		out.write( new ActionEnter( request, rootPath ).exec() );
		
	}
}
