<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
</head>
<body>

	<h1 align="center">欢迎使用图书管理系统</h1>
	<hr>
	<br>
	<#if msg!="" >
		<p align="center"><font color="red">${msg }</font></p>
	</#if>
	<form method="post" action="/v7/users/login_submit">
		<table width="400" border="0" align="center">

			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value="sa"/></td>
			</tr>

			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value="sa"/></td>
			</tr>

		</table>
		
		<p align="center">用户名：sa  密码：sa</p>
		
		<p align="center">
			<input type="submit" value="确定" name="btOk">
		</p>

</body>
</html>