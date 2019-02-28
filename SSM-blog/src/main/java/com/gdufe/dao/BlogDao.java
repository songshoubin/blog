package com.gdufe.dao;

import com.gdufe.entity.Blog;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogDao {

    public Blog findById(Integer id);

    public Blog findByIdWithComments(Integer id);

    //全部记录
    public List<Blog> listAll();

    // 查询一共有多少条记录
    public Integer getTotalCount(Map<String,Object> params);
    // 分页查询
    public List<Blog> listByPage(Map<String,Object> params);

    // 添加
    public int add(Blog blog);
    // 更新
    public int updateById(Blog blog);

    // 删除
    public int deleteById(Integer id);

    List getBlogTimeList(Integer user_id);

    Blog getNextBlog(Integer id);

    Blog getPrevBlog(Integer id);

    int update2(Blog blog);
}