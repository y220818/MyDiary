<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css" />
</head>
<body>
<h1>일기 쓰기</h1>
<jsp:include page="menu.jsp"/>
<form action="${pageContext.request.contextPath }/diary/write" method="post" >
<table>
	<tr>
		<th>날씨</th>
		<td>
			<select name="weather_id" id="">
			<c:forEach var="w" items="${list }">
				<option value="${w.weather_id }">${w.weather }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<!-- <tr><th>사진</th><td><input type="file" name="file"/></td></tr> -->
	<tr><th>제목</th><td><input type="text" name="title" size="30"/></td></tr>
	<tr><th>내용</th><td><textarea name="content" cols="50" rows="5"></textarea></td></tr>
	<tr><td colspan="2"><input type="submit" value="저장" /></td></tr>
</table>


</form>
</body>
</html>