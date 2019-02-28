package com.gdufe.service;

import com.gdufe.beans.PageBean;
import com.gdufe.entity.Link;
import com.gdufe.dao.LinkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LinkService {

    @Autowired
    private LinkDao mapper;

	@Transactional(readOnly=true)
    public Link findById(Integer id){
        return mapper.findById(id);
    }

    //全部记录
	@Transactional(readOnly=true)
    public List<Link> listAll(){
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

    public boolean add(Link link){
        return mapper.add(link)>0;
    }

    public boolean updateById(Link link){
        return mapper.updateById(link)>0;
    }

    public boolean deleteById(Integer id){
        return mapper.deleteById(id)>0;
    }

}