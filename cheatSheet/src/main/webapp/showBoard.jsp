<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${data.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${data.content}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${data.wdate}</td>
		</tr>
	</table>
</body>
</html>