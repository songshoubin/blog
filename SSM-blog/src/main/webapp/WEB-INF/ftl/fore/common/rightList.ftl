<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/user_icon.png" /> 博主信息
	</div>
	<div class="user_image">
		<img src="/static/userImages/${blogger.imagename}" />
	</div>
	<div class="nickName">
		<strong><font style="color: #EE6A50">昵称：${blogger.nickname}</font></strong>
	</div>
<!-- 	<div class="visitNum">访问量：6666</div> -->
	<div class="userSign">
		『<strong><font style="color: #EE6A50">${blogger.sign }</font></strong>』
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/byType_icon.png" /> 文章分类
	</div>
	<div class="datas">
		<ul>
			<#list blogtypeList as blogtype >
				<li><span> <a href="./index.html?typeId=${blogtype.id }">${blogtype.typeName}（${blogtype.blogCount }） </a></span></li>
			</#list>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/byDate_icon.png" /> 文章存档
	</div>
	<div class="datas">
		<ul>
			<#list blogTimeList as blog>
				<li><span> <a href="./index.html?releaseDateStr=${blog.releaseDateStr }">${blog.releaseDateStr}（${blog.blogCount }） </a></span></li>
			</#list>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/link_icon.png" /> 友情链接
	</div>
	<div class="datas">
		<ul>
			<#list linkList as link>
				<li><span><a href="${link.linkurl }" target="_blank">${link.linkname}</a></span></li>
			</#list>
		</ul>
	</div>
</div>
