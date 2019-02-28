package com.gdufe.controller.fore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdufe.beans.PageBean;
import com.gdufe.entity.Blog;
import com.gdufe.entity.Blogger;
import com.gdufe.entity.Comment;
import com.gdufe.entity.Link;
import com.gdufe.service.BlogService;
import com.gdufe.service.BloggerService;
import com.gdufe.service.BlogtypeService;
import com.gdufe.service.CommentService;
import com.gdufe.service.LinkService;


@Controller
public class BlogForeController {

	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;
	
	@Resource
	private BloggerService bloggerService;

	@Resource
	private BlogtypeService blogtypeService;
	
	@Resource
	private LinkService linkService;
	
	// 请求博客详细信息
	@RequestMapping({"/{blogger_name}/index","/{blogger_name}/"})
	public String index(@PathVariable(required=true) String blogger_name,
			@RequestParam(required = false)Integer page,
			@RequestParam(required = false) String typeId,
			@RequestParam(required = false) String releaseDateStr,
			HttpServletRequest request, Map model) {
		model.put("contentPage", "bloglist.ftl");
		
//		Map params=request.getParameterMap();
//		for(Object key: params.keySet()) {
//			System.out.println("key="+key+ "  value="+params.get(key));
//		}
		
		
		
		Integer pgSize=3;
		if(page==null) page=1;  //当前页

		// 获取博主信息
		Blogger blogger=bloggerService.findByName(blogger_name);
		model.put("blogger", blogger);
		System.out.println("blogger="+blogger);
		
		Map cond=new HashMap();
		cond.put("user_id", blogger.getId());
		//支持更复杂的查询条件
		if(typeId!=null) cond.put("typeId", typeId);
		if(releaseDateStr!=null) cond.put("releaseDateStr", releaseDateStr);
		
		PageBean pagebean = blogService.listByPage(page, pgSize, cond);
		model.put("page", pagebean);
		
		
		List<Blog> blogList=pagebean.getRows();
		for(Blog blog : blogList) {
			List<String> imageList = new ArrayList<String>();
			String blogInfo = blog.getContent(); //获取博客内容
			Document doc = Jsoup.parse(blogInfo); //将博客内容(网页中也就是一些html)转为jsoup的Document
//			Elements jpgs = doc.select("img[src$=.jpg]");//获取<img>标签中所有后缀是.jpg的元素
			Elements jpgs = doc.select("img");//获取<img>标签中所有后缀是.jpg的元素
			for(int i = 0; i < jpgs.size() && i<3; i++) {
				Element jpg = jpgs.get(i); //获取到单个元素    //只存三张图片信息
				imageList.add(jpg.toString()); //把图片信息存到imageList中 
			}
			blog.setImageList(imageList);
		}
		
		// 获取博客类别信息
		List blogtypeList=blogtypeService.getBlogtypeList(blogger.getId());
		model.put("blogtypeList", blogtypeList);

		// 获取博客信息，按照时间分类的
		List blogTimeList = blogService.getBlogTimeList(blogger.getId());
		model.put("blogTimeList", blogTimeList);
		
		// 获取友情链接信息
		List<Link> linkList = linkService.listAll();
		model.put("linkList", linkList);
		
		return "/fore/mainTemp";
	}
	
	// 请求博客详细信息
	@RequestMapping("/{blogger_name}/{id}")
	public String details(@PathVariable(required=true) String blogger_name,@PathVariable Integer id, HttpServletRequest request, Map model) {

		Blogger blogger=bloggerService.findByName(blogger_name);
		model.put("blogger", blogger);

//		// 获取博主信息
//		Blog blog = blogService.findById(id); // 根据id获取博客
//		model.put("blog", blog);
//		model.put("contentPage", "blogDetail.ftl");
//
////		// 查询评论信息
//		Map tj=new HashMap();
//		tj.put("blogId", blog.getId());
//		tj.put("state", 1);
//		List<Comment> commentList = commentService.getListByBlogId(blog.getId());
//		model.put("commentList", commentList);

		Blog blog = blogService.findByIdWithComments(id);
		model.put("blog", blog);
		model.put("contentPage", "blogDetail.ftl");
		model.put("commentList", blog.getComments());

		//存入上一篇和下一篇的显示代码
		Blog prevBlog=blogService.getPrevBlog(id);
		Blog nextBlog=blogService.getNextBlog(id);
		model.put("prevBlog", prevBlog);
		model.put("nextBlog", nextBlog);

		// 获取博客类别信息
		List blogtypeList=blogtypeService.getBlogtypeList(blogger.getId());
		
		model.put("blogtypeList", blogtypeList);

		// 获取友情链接信息
		List<Link> linkList = linkService.listAll();
		model.put("linkList", linkList);
		
//		blog.setClickHit(blog.getClickHit() + 1); // 将博客访问量加1
//		blogService.update(blog); // 更新博客
		
		return "/fore/mainTemp";
	}

}
