<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css" />
</head>
<body>
<c:if test="${result }">
	<script>
		alert("회원가입 성공, 로그인하고 우리의 멋진 서비스를 마음껏 즐겁게 이용하셈 ㅋㅋㅋ")
	</script>
</c:if>
<h1>
	Welcome to My Diary World!!! 
</h1>
<jsp:include page="./diary/menu.jsp"/>

</body>
</html>  
