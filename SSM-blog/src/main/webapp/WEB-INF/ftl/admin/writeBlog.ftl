<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/easyui/themes/icon.css">
<script type="text/javascript" src="/static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/static/easyui/locale/easyui-lang-zh_CN.js"></script>
<title>写博客页面</title>
</head>
<body style="margin: 10px; font-family: microsoft yahei">

<script type="text/javascript" charset="utf-8" src="/static/ueditor1_4_3_3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/static/ueditor1_4_3_3/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/static/ueditor1_4_3_3/lang/zh-cn/zh-cn.js"></script>

		
		<table cellspacing="10px">
			<tr>
				<td width="80px">博客标题：</td>
				<td>
				  <input type="hidden" id="id" name="id" value="${blogid}" />
				  <input type="text" id="title" name="title" style="width:400px" />
				</td>
			</tr>
			<tr>
				<td>所属类别：</td>
				<td><select id="blogtypeId" class="easyui-combobox"
					name="blogtype.id" style="width:154px" editable="false"
					panelHeight="auto">
						<option value="">请选择博客类别...</option>
						<#list blogtypeList as blogtype>
							<option value="${blogtype.id }">${blogtype.typeName }</option>
						</#list>    
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td>关键字：</td>
				<td><input type="text" id="keyWord" name="keyWord"
					style="width:400px" />&nbsp;&nbsp;&nbsp;多个关键字的话请用空格隔开</td>
			</tr>
			<tr>
				<td valign="top">博客内容：</td>
				<td><script id="editor" name="content" type="text/plain"
						style="width:80%; height:500px;"></script></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:submitData()" class="easyui-linkbutton"
					data-options="iconCls:'icon-submit'">发布博客</a></td>
			</tr>
		</table>




	<!-- 实例化编辑器 -->
<script type="text/javascript">
$(function(){
var ue = UE.getEditor('editor');
ue.addListener("ready", function(){
	var id = $("#id").val();
	console.log("id="+id);
	
	if(id ==null ) return;
	
	$.post("/admin/blog/find.do","id="+id, function(result) {
		
		if(result.success==false || result.value==null) return;
		var obj=result.value;
		
		$("#id").val(obj.id);
		$("#title").val(obj.title);
		$("#keyWord").val(obj.keyWord);							
		$("#blogtypeId").combobox("setValue", obj.blogtype.id);	
		UE.getEditor('editor').setContent(obj.content);

	});
	
});


});

function submitData() {
	var id = $("#id").val();
	var title = $("#title").val();
	var blogtypeId = $("#blogtypeId").combobox("getValue");
	var content = UE.getEditor('editor').getContent();
	var summary = UE.getEditor('editor').getContentTxt().substr(0, 155);
	var keyWord = $("#keyWord").val();
	var contentNoTag = UE.getEditor('editor').getContentTxt();

	if (title == null || title == '') {
		$.messager.alert("系统提示", "请输入标题！");
	} else if (blogtypeId == null || blogtypeId == '') {
		$.messager.alert("系统提示", "请选择博客类型！");
	} else if (content == null || content == '') {
		$.messager.alert("系统提示", "请编辑博客内容！");
	} else {
		$.post("/admin/blog/save.do",
				{
					'id' : id,
					'title' : title,
					'blogtype.id' : blogtypeId,
					'content' : content,
					'summary' : summary,
					'keyWord' : keyWord,
					'contentNoTag' : contentNoTag
				}, function(result) {
					if (result.success) {
						$.messager.alert("系统提示", "博客发布成功！");
						clearValues();
					} else {
						$.messager.alert("系统提示", "博客发布失败！");
					}
				}, "json");
	}
}
function clearValues() {
	$("#id").val("");
	$("#title").val("");
	$("#blogtypeId").combobox("setValue", "");
	UE.getEditor("editor").setContent("");
	$("#keyWord").val("");
}

</script>
</body>
</html>
