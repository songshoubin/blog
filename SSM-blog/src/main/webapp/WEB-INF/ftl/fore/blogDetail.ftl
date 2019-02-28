<script type="text/javascript"
	src="/static/ueditor1_4_3_3/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet"
	href="/static/ueditor1_4_3_3/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript">
	SyntaxHighlighter.all(); //ueditor代码高亮

	function showOtherComment() {
		console.log($(".otherComment").css("display"));
		if( $(".otherComment").css("display")=="none"){
		   $(".otherComment").show();
		   $("#showAll").text("隐藏部分用户评论");
		}else{
		   $(".otherComment").hide();
		   $("#showAll").text("显示所有用户评论");
		}
	}

	function loadimage() {
		document.getElementById("randImage").src = "/util/genCheckCode.do?"
				+ Math.random();
	}

	function submitData() {
		var content = $("#content").val();
		var imageCode = $("#imageCode").val();
		if (content == null || content == "") {
			alert("请输入评论内容");
		//} else if (imageCode == null || imageCode == "") {
		//	alert("请填写验证码");
		} else {
			$.post("/fore/comment/save.do", {
				"content" : content,
				"imageCode" : imageCode,
				"blog_id" : "${blog.id}"
			}, function(result) {
				if (result.success) {
					alert("评论已提交成功，博主审核后添加");
					window.location.reload();
				} else {
					alert("评论提交失败!");
				}
			}, "json");
		}
	}
</script>

<!-- 1 博客 -->
<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/blog_show_icon.png" />&nbsp;博客信息
	</div>
	<div>
	<!-- 1.1 标题 -->
		<div class="blog_title">
			<h3>
				<strong>${blog.title }</strong>
			</h3>
		</div>
		<div class="blog_info">
			<div style="float: left">
				<strong>标签</strong>：${blog.keyWord}
			</div>
				
			<div style="float: right;">
				发布于：『博客类别：<a href="/index.html?typeId=${blog.blogtype.id}">${blog.blogtype.typeName}</a>
				&nbsp;&nbsp; 阅读(${blog.clickHit })&nbsp;&nbsp; 评论(${blog.replyHit})
			</div>
		</div>
		<br> <br>
		<div class="xian" style="clear: both; margin: 0 auto; border-top: 1px solid #ddd"></div>
		<div style="line-height: 3; background-color: #F8F8FF">
			<font style="color: #8B2323">作者：xxx &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尊重博主原创文章，转载请注明文章出于此处。</font>
		</div>
		<div class="xian" style="margin: 0px auto; border-top: 1px solid #ddd"></div>
	<!-- 1.3 内容 -->
		<div class="blog_content">${blog.content }</div>
		<div class="xian" style="margin: 0 auto; border-top: 1px solid #ddd"></div>
		
		<div style="margin-top: 25px;">
		<#include "/fore/common/next.ftl">
		</div>
	</div>
</div>

<!-- 2 评论内容 -->
<div class="data_list">
	<div class="data_list_title">
		<img
			src="/static/images/comment_icon.png" />&nbsp;用户评论
		<#if commentList?size gt 5 >
			<a id="showAll"  href="javascript:showOtherComment()"
				style="float:right; padding-right:40px;">显示所有用户评论</a>
		</#if>
	</div>
	<div class="commentDatas">
		<ul>
			<#if commentList?size == 0 >
						暂无评论
			<#else>
					<#list commentList as comment >
							<#if comment?index lt 5 >
								<div class="comment">
									<span><font>
											${comment?index+1}楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userIp }</font>
										&nbsp;&nbsp;&nbsp;&nbsp;${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;
										[${comment.commentDate }] </span>
								</div>
							<#else>
								<div class="otherComment">
									<span><font>
											${comment?index+1}楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userIp }</font>
										&nbsp;&nbsp;&nbsp;&nbsp;${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;
										[${comment.commentDate}] </span>
								</div>
							</#if>
					</#list>
			</#if>
		</ul>
	</div>
</div>

<!-- 3 发表评论 -->
<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/publish_comment_icon.png" />&nbsp;发表评论
	</div>
	<div class="publish_comment">
		<div>
			<textarea style="width: 100%" rows="3" id="content" name="content"
				placeholder="来说两句吧..."></textarea>
		</div>
		<div class="verCode">
			验证码：<input type="text" value="" name="imageCode" id="imageCode"
				size="10" onkeydown="if(event.keyCode==13)form1.submit()" />&nbsp;
				<img onclick="javascript:loadimage();" title="换一张试试"   id="randImage" src="/util/genCheckCode.do" width="60" height="20" border="1"
				align="absmiddle">
		</div>
		<div class="publishButton">
			<button class="btn btn-primary" type="button" onclick="submitData()">发表评论</button>
		</div>
		</form>
	</div>

</div>
