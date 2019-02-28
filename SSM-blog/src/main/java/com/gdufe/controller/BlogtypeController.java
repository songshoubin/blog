package com.gdufe.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdufe.entity.Blogger;
import com.gdufe.entity.Blogtype;
import com.gdufe.beans.PageBean;
import com.gdufe.beans.ResultBean;
import com.gdufe.service.BlogtypeService;


@Controller
@RequestMapping("/admin/blogtype/")
@ResponseBody
public class BlogtypeController {
	@Autowired
	private BlogtypeService service;
	
	/**
	 * 分页查询{TABLE_CNAME}
	 */
	//接收easyui datagrid的分页数据请求,page为第几页，rows为每页多少行
	@RequestMapping("list.do")
	public PageBean list(Integer page,Integer rows, HttpSession session) {
		Blogger user = (Blogger) session.getAttribute("user");
		HashMap cond = new HashMap();
		cond.put("user_id", user.getId());
		return  service.listByPage(page,rows,cond);
	}
	
	/**
	 * 删除博客类型
	 */
	@RequestMapping("delete.do")
	public ResultBean delete(Integer id){
		boolean success=service.deleteById(id);
		return new ResultBean(success,"删除状态："+success);
	}

	/**
	 * 添加提交博客类型
	 */
	@RequestMapping("add_submit.do")
	public ResultBean add_submit(Blogtype blogtype, HttpSession session)  {
		Blogger user = (Blogger) session.getAttribute("user");
		blogtype.setUser_id(user.getId());
		boolean success=service.add(blogtype);
		return new ResultBean(success,"添加状态："+success);
	}

	/**
	 * 修改博客类型
	 */
	@RequestMapping("modify.do")
	public Blogtype modify(Integer id)  {
		return service.findById(id);
	}

	/**
	 * 修改提交博客类型
	 */
	@RequestMapping("modify_submit.do")
	public ResultBean modify_submit(Blogtype blogtype) {
		boolean success=service.updateById(blogtype);
		return new ResultBean(success,"修改状态："+success);
	}
	
	
}


