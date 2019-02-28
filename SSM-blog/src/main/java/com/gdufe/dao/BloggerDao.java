package com.gdufe.dao;

import com.gdufe.entity.Blogger;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerDao {

    public Blogger findById(Integer id);

    //全部记录
    public List<Blogger> listAll();

    // 查询一共有多少条记录
    public Integer getTotalCount(Map<String,Object> params);
    // 分页查询
    public List<Blogger> listByPage(Map<String,Object> params);

    // 添加
    public int add(Blogger blogger);
    // 更新
    public int updateById(Blogger blogger);

    // 删除
    public int deleteById(Integer id);

    Blogger verify(@Param("username")String username, @Param("password")String password);

    Blogger findByName(String blogger_name);
}