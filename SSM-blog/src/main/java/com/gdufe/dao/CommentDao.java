package com.gdufe.dao;

import com.gdufe.entity.Comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao {

    public Comment findById(Integer id);

    //全部记录
    public List<Comment> listAll();

    // 查询一共有多少条记录
    public Integer getTotalCount(Map<String,Object> params);
    // 分页查询
    public List<Comment> listByPage(Map<String,Object> params);

    // 添加
    public int add(Comment comment);
    // 更新
    public int updateById(Comment comment);

    // 删除
    public int deleteById(Integer id);

    List<Comment> getListByBlogId(Integer id);

    int review(@Param("blog_id") Integer blog_id, @Param("state")Integer state);
}