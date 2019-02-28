<div class="data_list">
  		<div class="data_list_title">
			<img src="/static/images/list_icon.png"/>&nbsp;最新博客
		</div>	
		<div class="datas"> ###${page.rows?size} 
			<ul>	
				<#list page.rows as blog>
					<li style="margin-bottom: 30px">
					  	<span class="title">
					  		<img alt="文章类型" src="/static/userImages/dog.png">
					  		<a href="./${blog.id}.do">${blog.title }</a>
					  	</span>
					  	<span class="summary">摘要: ${blog.summary }....</span>
					  	<span class="img">
					  		<#list blog.imageList as image>
					  			<a href="./${blog.id}.do">${image }</a>
					  			&nbsp;&nbsp;
					  		</#list>
	
					  	</span>
					  	<span class="info">
					  		<font color="#999">${blog.releaseDate }</font> &nbsp;&nbsp;
					  		<font color="#33a5ba"><a href="/blog/${blog.id}.do">阅读</a><font color="#999">(${blog.clickHit })</font>&nbsp;&nbsp;</font>
					  		<font color="#33a5ba"><a href="/blog/${blog.id}.do">评论</a><font color="#999">(${blog.replyHit })</font>&nbsp;&nbsp;</font>  	
					  	</span>
					</li>
					<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />	
				</#list>																											
			</ul>			
		</div>  
		
		<div style="text-align: center;">
			<nav>
			    <#include "/fore/common/pagination.ftl">
			</nav>
		</div>			
</div>
