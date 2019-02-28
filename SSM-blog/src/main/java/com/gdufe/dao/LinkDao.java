package com.gdufe.dao;

import com.gdufe.entity.Link;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkDao {

    public Link findById(Integer id);

    //全部记录
    public List<Link> listAll();

    // 查询一共有多少条记录
    public Integer getTotalCount(Map<String,Object> params);
    // 分页查询
    public List<Link> listByPage(Map<String,Object> params);

    // 添加
    public int add(Link link);
    // 更新
    public int updateById(Link link);

    // 删除
    public int deleteById(Integer id);

    }