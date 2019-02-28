package com.gdufe.service;

import com.gdufe.beans.PageBean;
import com.gdufe.entity.Blog;
import com.gdufe.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogDao mapper;

	@Transactional(readOnly=true)
    public Blog findById(Integer id){
        return mapper.findById(id);
    }

    @Transactional(readOnly=true)
    public Blog findByIdWithComments(Integer id){
        return mapper.findByIdWithComments(id);
    }


    //全部记录
	@Transactional(readOnly=true)
    public List<Blog> listAll(){
        return mapper.listAll();
    }

	@Transactional(readOnly=true)
    public Integer getTotalCount(Map<String,Object> parms){
        return mapper.getTotalCount(parms);
    }

    // 分页查询
	@Transactional(readOnly=true)
    public PageBean listByPage(Integer pgNo, Integer pgSize, Map<String,Object> params){
        PageBean page = new PageBean(pgNo,pgSize);
        //-----查询记录条数
        Integer total= mapper.getTotalCount(params);
        page.setTotal(total);
        page.addQueryParam(params);

        page.setRows(mapper.listByPage(params));
        return page;
    }

    public boolean add(Blog blog){
        return mapper.add(blog)>0;
    }

    public boolean updateById(Blog blog){
        return mapper.updateById(blog)>0;
    }

    public boolean deleteById(Integer id){
        return mapper.deleteById(id)>0;
    }

    public List getBlogTimeList(Integer user_id) {
	    return mapper.getBlogTimeList(user_id);
    }

    public Blog getNextBlog(Integer id) {
	    return mapper.getNextBlog(id);
    }

    public Blog getPrevBlog(Integer id) {
        return mapper.getPrevBlog(id);
    }

    public boolean update2(Blog blog) {
	    return mapper.update2(blog)>0;
    }
}