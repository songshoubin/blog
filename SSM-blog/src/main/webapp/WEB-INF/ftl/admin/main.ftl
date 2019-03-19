<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人博客系统后台管理页面</title>
<link rel="stylesheet" type="text/css" href="/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/static/css/blog.css">
<script type="text/javascript" src="/static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/static/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$(".menuA").click(function() {
			// 获得超链接中的文本内容
			var textContent = this.innerHTML;
			// 获得请求路径
			var url = this.href;
			// alert(url);
			// 创建选项卡
			createTabsA(textContent, url);
			// 让超链接不跳转:
			return false;
		});
		$(".menuB").click(function() {
			// 获得超链接中的文本内容
			var textContent = this.innerHTML;
			// 获得请求路径
			var url = this.href;
			// alert(url);
			// 创建选项卡
			createTabsB(textContent, url);
			// 让超链接不跳转:
			return false;
		});
	});

	// 创建选项卡的函数:
	function createTabsA(textContent, myurl) {
		// 判断选项卡是否存在
		var flag = $("#tt").tabs("exists", textContent);
		if (flag) {
			// 已经存在该选项卡
			$('#tt').tabs("select", textContent);
		} else {
			// 不存在该选项卡
			$('#tt').tabs('add', {
				title : textContent,
				//			    content:createUrl(myurl),    
				href : myurl,
				closable : true
			});
		}
	}

	// 创建选项卡的函数:
	function createTabsB(textContent, myurl) {
		// 判断选项卡是否存在
		var flag = $("#tt").tabs("exists", textContent);
		var flag=false;
		if (flag) {
			// 已经存在该选项卡
			$('#tt').tabs("select", textContent);
		} else {
			// 不存在该选项卡
			$('#tt').tabs('add', {
				title : textContent,
			    content:createUrl(myurl),    
				closable : true
			});
		}
	}
	
	function createUrl(url) {
		return "<iframe src='" + url
				+ "' style='border:0px;width:100%;height:95%;'></iframe>";
	}
</script>
<style>
.menuA {
	text-decoration: none;
}
</style>

</head>
<!--1. 在整个页面创建布局面板-->
<body class="easyui-layout">
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'" style="height: 85px; background-color: #E0ECFF">
			<table style="padding: 2px" width="100%">
				<tr>
					<td width="50%">
						<h2>博客后台系统</h2>
					</td>
					<td valign="bottom" align="right" width="50%">
					<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${user.username}
					</font>
					</td>
				</tr>
			</table>
		</div>
		<!--2. 菜单栏-->
		<div data-options="region:'west',split:true" style="width: 200px" title="导航菜单" split="true" >
			<div class="easyui-accordion" data-options="fit:true, selected:3 ">
				<div title="博客类别管理" data-options="iconCls:'icon-bklb'" style="padding:10px">
					<a href="/static/admin/blogtype.html" class="menuA easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">博客类别信息管理</a>
				</div>
				<div title="博客管理"  data-options="iconCls:'icon-bkgl'" style="padding:10px;">
					<a href="/admin/blog/writeBlog.do" class="menuB easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">写博客</a>
					<a href="/static/admin/blog.html" class="menuA easyui-linkbutton" data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">博客信息管理</a>
				</div>
				<div title="评论管理"  data-options="iconCls:'icon-plgl'" style="padding:10px">
					<a href="#" class="menuA easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
					<a href="/static/admin/comment.html" class="menuA easyui-linkbutton" data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">评论信息管理</a>
				</div>
				<div title="个人信息管理"  data-options="iconCls:'icon-grxx'" style="padding:10px">
					<a href="/static/admin/blogger.html" class="menuA easyui-linkbutton" data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">修改个人信息</a>
				</div>
				<div title="系统管理"  data-options="iconCls:'icon-system'" style="padding:10px">
				    <a href="/static/admin/link.html" class="menuA easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">友情链接管理</a>
					<a href="/static/admin/changePassword.html" class="menuA easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
					<a href="#" class="menuA easyui-linkbutton" data-options="plain:true,iconCls:'icon-refresh'" style="width: 150px;">刷新系统缓存</a>
					<a href="/admin/logout.do" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
				</div>
			</div>
		</div>
		<!--3. 底栏-->
		<div data-options="region:'south',split:false" style="height: 45px">
			<p align="center">Copyright © 2018song个人博客系统  版权所有</p>
		</div>
		<!--4. 主界面-->
		<div data-options="region:'center'">
			<div id="tt" class="easyui-tabs" data-options="fit:true">
				<div title="首页" data-options="closable:true"
					style="padding: 20px; display: none;">欢迎来到个人博客系统后台管理页面
					，当前用户：${user.username}</div>
			</div>
		</div>
	</div>
</body>
</html>