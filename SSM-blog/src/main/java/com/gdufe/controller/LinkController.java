package com.gdufe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdufe.entity.Link;
import com.gdufe.beans.PageBean;
import com.gdufe.beans.ResultBean;
import com.gdufe.service.LinkService;


@Controller
@RequestMapping("/admin/link/")
@ResponseBody
public class LinkController {
	@Autowired
	private LinkService service;
	
	/**
	 * 分页查询{TABLE_CNAME}
	 */
	//接收easyui datagrid的分页数据请求,page为第几页，rows为每页多少行
	@RequestMapping("list.do")
	public PageBean list(Integer page,Integer rows) {
		return  service.listByPage(page,rows,null);
	}
	
	/**
	 * 删除友情链接
	 */
	@RequestMapping("delete.do")
	public ResultBean delete(Integer id){
		boolean success=service.deleteById(id);
		return new ResultBean(success,"删除状态："+success);
	}

	/**
	 * 添加提交友情链接
	 */
	@RequestMapping("add_submit.do")
	public ResultBean add_submit(Link link)  {
		boolean success=service.add(link);
		return new ResultBean(success,"添加状态："+success);
	}

	/**
	 * 修改友情链接
	 */
	@RequestMapping("modify.do")
	public Link modify(Integer id)  {
		return service.findById(id);
	}

	/**
	 * 修改提交友情链接
	 */
	@RequestMapping("modify_submit.do")
	public ResultBean modify_submit(Link link) {
		boolean success=service.updateById(link);
		return new ResultBean(success,"修改状态："+success);
	}
	
	
}


