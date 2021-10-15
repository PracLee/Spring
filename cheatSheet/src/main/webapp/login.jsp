<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginAction.do" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>