package com.gdufe.service;

import com.gdufe.beans.PageBean;
import com.gdufe.entity.Blogtype;
import com.gdufe.dao.BlogtypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional//给整个类加事务管理
public class BlogtypeService {

    @Autowired
    private BlogtypeDao mapper;

	@Transactional(readOnly=true)
    public Blogtype findById(Integer id){
        return mapper.findById(id);
    }

    //全部记录
	@Transactional(readOnly=true)
    public List<Blogtype> listAll(Integer user_id){
        return mapper.listAll(user_id);
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

    public boolean add(Blogtype blogtype){
        return mapper.add(blogtype)>0;
    }

    public boolean updateById(Blogtype blogtype){
        return mapper.updateById(blogtype)>0;
    }

    public boolean deleteById(Integer id){
        return mapper.deleteById(id)>0;
    }

    public List getBlogtypeList(Integer user_id) {
	    return mapper.getBlogtypeList(user_id);
    }
}
