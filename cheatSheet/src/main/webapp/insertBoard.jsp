<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 입력하기!</title>
</head>
<body>
<form method="post" action="insertBoardDB.do">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td><input type="submit" value ="글쓰기!"></td>
			</tr>
		</table>
	</form>
</body>
</html>