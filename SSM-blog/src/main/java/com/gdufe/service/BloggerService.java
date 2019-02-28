package com.gdufe.service;

import com.gdufe.beans.PageBean;
import com.gdufe.entity.Blogger;
import com.gdufe.dao.BloggerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BloggerService {

    @Autowired
    private BloggerDao mapper;

	@Transactional(readOnly=true)
    public Blogger findById(Integer id){
        return mapper.findById(id);
    }

    //全部记录
	@Transactional(readOnly=true)
    public List<Blogger> listAll(){
        return mapper.listAll();
    }

	@Transactional(readOnly=true)
    public Integer getTotalCount(Map<String,Object> params){
        return mapper.getTotalCount(params);
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

    public boolean add(Blogger blogger){
        return mapper.add(blogger)>0;
    }
    public boolean add(Blogger blogger, String rootPath, CommonsMultipartFile imagefile) throws IOException {
        boolean success=mapper.add(blogger)>0;
        //如果有上传文件，则保存文件
        if(imagefile!=null) {
            System.out.println("filename="+blogger.getImagename());
            File file =new File(rootPath+blogger.getImagename());
            imagefile.transferTo(file);  //保存文件到磁盘
        }
        return success;
    }

    public boolean updateById(Blogger blogger, String rootPath, CommonsMultipartFile imagefile) throws IOException {
        boolean result=false;
        result=mapper.updateById(blogger)>0;
        File file =new File(rootPath+blogger.getImagename());
        imagefile.transferTo(file);  //保存文件到磁盘
        return result;
    }
    public boolean updateById(Blogger blogger){
        return mapper.updateById(blogger)>0;
    }

    public boolean deleteById(Integer id){
        return mapper.deleteById(id)>0;
    }

    public Blogger verify(String username, String password) {
	    return mapper.verify(username,password);
    }

    public Blogger findByName(String blogger_name) {
	    return mapper.findByName(blogger_name);
    }
}