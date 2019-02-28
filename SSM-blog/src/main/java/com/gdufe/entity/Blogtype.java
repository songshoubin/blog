package com.gdufe.entity;

public class Blogtype {
	private Integer id;   //id
    private String typeName;   //博客类别
    private Integer orderNum;   //博客排序
    private Integer user_id;  //关联的博客用户
    
	private Integer blogCount; //统计不同类型的博客数量

	@Override
	public String toString() {
		return "Blogtype{" +
				"id=" + id +
				", typeName='" + typeName + '\'' +
				", orderNum=" + orderNum +
				", user_id=" + user_id +
				", blogCount=" + blogCount +
				'}';
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	


}
