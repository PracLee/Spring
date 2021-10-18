<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 하세요</title>
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
				<td><input type="submit" value="Login"></td>
				<td><a href="insertMember.jsp">회원가입</a></td>
			</tr>
		</table>
	</form>
</body>
</html>