package com.gdufe.dao;

import com.gdufe.entity.Blogtype;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogtypeDao {

    public Blogtype findById(Integer id);

    //全部记录
    public List<Blogtype> listAll(Integer user_id);

    // 查询一共有多少条记录
    public Integer getTotalCount(Map<String,Object> params);
    // 分页查询
    public List<Blogtype> listByPage(Map<String,Object> params);

    // 添加
    public int add(Blogtype blogtype);
    // 更新
    public int updateById(Blogtype blogtype);

    // 删除
    public int deleteById(Integer id);

    List getBlogtypeList(Integer user_id);
}