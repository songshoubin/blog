package com.gdufe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdufe.entity.Blogger;
import com.gdufe.entity.Comment;
import com.gdufe.beans.PageBean;
import com.gdufe.beans.ResultBean;
import com.gdufe.service.CommentService;


@Controller
@RequestMapping("/admin/comment/")
@ResponseBody
public class CommentController {
	@Autowired
	private CommentService service;
	
	
	// 评论审核
	@RequestMapping("/review.do")
	public ResultBean review(Integer id,Integer state) {
		boolean success=false;
		if(id!=null && state!=null)
			success=service.review(id,state);
	
		return new ResultBean(true,"审核完成");
	}
	
	
	/**
	 * 分页查询{TABLE_CNAME}
	 */
	//接收easyui datagrid的分页数据请求,page为第几页，rows为每页多少行
	@RequestMapping("list.do")
	public PageBean list(Integer page,Integer rows, HttpSession session) {
		Blogger user = (Blogger) session.getAttribute("user");
		Map cond=new HashMap();
		cond.put("user_id", user.getId());
		return  service.listByPage(page,rows,cond);
	}
	
	/**
	 * 删除评论
	 */
	@RequestMapping("delete.do")
	public ResultBean delete(Integer id){
		boolean success=service.deleteById(id);
		return new ResultBean(success,"删除状态："+success);
	}

	/**
	 * 添加提交评论
	 */
	@RequestMapping("add_submit.do")
	public ResultBean add_submit(Comment comment)  {
		boolean success=service.add(comment);
		return new ResultBean(success,"添加状态："+success);
	}

	/**
	 * 修改评论
	 */
	@RequestMapping("modify.do")
	public Comment modify(Integer id)  {
		return service.findById(id);
	}

	/**
	 * 修改提交评论
	 */
	@RequestMapping("modify_submit.do")
	public ResultBean modify_submit(Comment comment) {
		boolean success=service.updateById(comment);
		return new ResultBean(success,"修改状态："+success);
	}
	
	
}


