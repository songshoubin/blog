package com.gdufe.controller.fore;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdufe.beans.ResultBean;
import com.gdufe.entity.Comment;
import com.gdufe.service.CommentService;


@Controller
@RequestMapping("/fore/comment")
public class CommentForeController {

	@Autowired
	private CommentService service;

	// 请求博客详细信息
	@RequestMapping("/save.do")
	@ResponseBody
	public ResultBean details(Comment comment,String imageCode,HttpServletRequest request,HttpSession session) {
		boolean success=false;
		System.out.println(comment.getContent());
		System.out.println(comment.getBlog_id());
		
		String sRand = (String) session.getAttribute("sRand");//获取session中正确的验证码，验证码产生后会存到session中的
		System.out.println(imageCode+ " <==> "+ sRand);
		
		String userIp = request.getRemoteAddr(); //获取评论用户的ip
		comment.setUserIp(userIp);  //将userIp设置进去
		comment.setCommentDate(new Date());
		comment.setState(0);
		
		if(comment.getBlog_id()!=null) {
			success=service.add(comment);  //保存评论，更新评论次数
		}
				
		return new ResultBean(success);


	}

}
