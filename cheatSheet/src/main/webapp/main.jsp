<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인!</title>
</head>
<body>
	<table>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="v" items="${boardDatas}">
			<tr>
				<td>${v.id }</td>
				<td>${v.title }</td>
				<td>${v.writer }</td>
				<td>${v.wdate }</td>				
			</tr>
		</c:forEach>

	</table>
</body>
</html>