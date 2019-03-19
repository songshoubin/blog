<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/static/css/blog.css">
<script src="/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="/static/bootstrap3/js/bootstrap.min.js"></script>
<title>${title }</title>
<script type="text/javascript">
	function changeClass(obj) {
		var li = obj.parentNode; //获取父节点
		li.className = "active";
	}
</script>
<style type="text/css">
	body{
		padding-top:60px;
		padding-bottom:40px;
		background-color: #F5F5F5;
		font-family: microsoft yahei;
	}

</style>
</head>

<body>
	<div class="container">
	
		<!-- 1 页头-->
		<div class="row">
			<div class="col-md-4">
				<div class="blog">
					<a href="./index.html" style="text-decoration:none">
						<h1><strong>个人博客网站</strong></h1>
					</a>
				</div>
			</div>
			
			<div class="col-md-8">
			</div>
		</div>
	
		<!-- 2 菜单栏-->
		<div class="row" style="padding-top: 20px">
			<#include "/fore/common/menu.ftl">
		</div>
				
		<!-- 3 菜单栏-->
		<div class="row">		  	  
			<!-- 3.1 主要内容-->
			  <div class="col-md-9">
				  <#include "/fore/"+contentPage>
			  </div>	
			<!-- 3。2  右边栏-->
			  <div class="col-md-3">		  	
				<#include "/fore/common/rightList.ftl">
			  </div>		  
		</div>
		
		<!--4 页脚 -->
		<div class="row">
			<div class="col-md-12" >
				<div class="footer" align="center" style="padding-top: 120px" >
					<font>Copyright © 2018song个人博客系统  版权所有</font>
					  
				</div>
			</div>			
		</div>
		
	</div>
</body>
</html>
