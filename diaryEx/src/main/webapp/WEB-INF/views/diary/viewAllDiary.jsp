<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css" />
</head>
<body>
<h1>일기 목록</h1>
<jsp:include page="menu.jsp"/>
<div class="product">
<c:forEach var="diary" items="${list }">
<div class="inProduct">
<p>${diary.date }</p>
<ul>
	<li>${diary.id }</li>
	<li>${diary.title }</li>
	<li>${diary.content }</li>
	
	<li><img class="small" src='<c:url value="/${diary.photo_path }"/>' alt=""/></li>
</ul>
</div>
</c:forEach>
</div>

</body>
</html>