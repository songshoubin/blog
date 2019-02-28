package com.gdufe.entity;
import java.util.Date;
import java.util.List;

public class Blog {
    private Integer id;   //id
    private String title;   //博客题目
    private String summary;   //博客摘要
    private Date releaseDate;   //发布日期
    private Integer clickHit;   //评论次数
    private Integer replyHit;   //回复次数
    private String content;   //博客内容
    private String keyWord;   //关键字
    private Integer type_id;   //外键关联博客类别
    private Integer user_id;   //外键关联博客用户
    
	private Blogtype blogtype; //博客类型  一对一映射
	private List<Comment> comments;  //评论  一对多映射

	private List<String> imageList;  //存放头三张图片链接

	@Override
	public String toString() {
		return "Blog{" +
				"id=" + id +
				", title='" + title + '\'' +
				", summary='" + summary + '\'' +
				", releaseDate=" + releaseDate +
				", clickHit=" + clickHit +
				", replyHit=" + replyHit +
				", content='" + content + '\'' +
				", keyWord='" + keyWord + '\'' +
				", type_id=" + type_id +
				", user_id=" + user_id +
				", blogtype=" + blogtype +
				", imageList=" + imageList +
				'}';
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public Integer getClickHit() {
		return clickHit;
	}
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}
	
	public Integer getReplyHit() {
		return replyHit;
	}
	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	
	public Blogtype getBlogtype() {
		return blogtype;
	}
	public void setBlogtype(Blogtype blogtype) {
		this.blogtype = blogtype;
	}
	
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public List<String> getImageList() {
		return imageList;
	}
	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
