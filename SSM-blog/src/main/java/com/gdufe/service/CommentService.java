package com.gdufe.service;

import com.gdufe.beans.PageBean;
import com.gdufe.entity.Comment;
import com.gdufe.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentDao mapper;

	@Transactional(readOnly=true)
    public Comment findById(Integer id){
        return mapper.findById(id);
    }

    //全部记录
	@Transactional(readOnly=true)
    public List<Comment> listAll(){
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

    public boolean add(Comment comment){
        return mapper.add(comment)>0;
    }

    public boolean updateById(Comment comment){
        return mapper.updateById(comment)>0;
    }

    public boolean deleteById(Integer id){
        return mapper.deleteById(id)>0;
    }

    public boolean review(Integer blog_id, Integer state) {
	    return mapper.review(blog_id,state)>0;
    }

    public List<Comment> getListByBlogId(Integer id) {
	    return mapper.getListByBlogId(id);
    }
}