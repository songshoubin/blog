package com.gdufe.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gdufe.entity.Blogger;
import com.gdufe.beans.PageBean;
import com.gdufe.beans.ResultBean;
import com.gdufe.service.BloggerService;

@Controller
@RequestMapping("/admin/blogger/")
@ResponseBody
public class BloggerController {
	@Autowired
	private BloggerService service;

	@RequestMapping("list.do")
	/**
	 * 分页查询{TABLE_CNAME}
	 */
	// 接收easyui datagrid的分页数据请求,page为第几页，rows为每页多少行
	public PageBean list(Integer page, Integer rows) {
		return service.listByPage(page, rows,new HashMap());
	}

	/**
	 * 删除博主
	 */
	@RequestMapping("delete.do")
	public ResultBean delete(Integer id) {
		boolean success = service.deleteById(id);
		return new ResultBean(success, "删除状态：" + success);
	}

	/**
	 * 添加提交博主
	 */
	@RequestMapping("add_submit.do")
	public ResultBean add_submit(Blogger blogger, @RequestParam(required=false) CommonsMultipartFile imagefile,HttpServletRequest request) {
		boolean success = false;
		System.out.println(blogger.getUsername());
		System.out.println(imagefile);
		String rootPath = request.getSession().getServletContext().getRealPath("/"); // 获取服务器根路径
		
		if (imagefile!=null && !imagefile.isEmpty()) { // 如果用户有传过照片，就更新
			String origFileName = imagefile.getOriginalFilename();
			rootPath+="static/userImages/";
			
			blogger.setImagename(origFileName);  
			try {
				success=service.add(blogger,rootPath,imagefile);
				System.out.println("blogger id=" + blogger.getId());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			success=service.add(blogger);
		}

		return new ResultBean(success, "添加状态：" + success);
	}

	/**
	 * 修改博主
	 */
	@RequestMapping("modify.do")
	public Blogger modify(Integer id) {
		return service.findById(id);
	}

	/**
	 * 修改提交博主
	 */
	@RequestMapping("modify_submit.do")
	public ResultBean modify_submit(Blogger blogger, @RequestParam(required=false) CommonsMultipartFile imagefile,
			HttpServletRequest request) {
		boolean success = false;
		System.out.println(blogger.getUsername());
		System.out.println(imagefile);
		
		if (imagefile!=null && !imagefile.isEmpty()) { // 如果用户有传过照片，就更新
			String origFileName = imagefile.getOriginalFilename();
			String postfix = origFileName.substring(origFileName.lastIndexOf("."));
			String rootPath = request.getSession().getServletContext().getRealPath("/"); // 获取服务器根路径
			rootPath+="static/userImages/";
			System.out.println("web context path=" + rootPath);
			System.out.println("blogger id=" + blogger.getId());
			System.out.println("orig file name=" + origFileName + "  postfix=" + postfix);
			
			blogger.setImagename("u"+blogger.getId()+postfix);  //将uid作为文件名唯一
			try {
				success=service.updateById(blogger,rootPath,imagefile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			success=service.updateById(blogger);
		}


		return new ResultBean(success, "修改状态：" + success);
	}

}
