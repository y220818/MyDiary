<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css" />
</head>
<body>
<h1>로그인 폼</h1>

<form action="${pageContext.request.contextPath }/member/login" method="post">
	id: <input type="text" name="memberID"  />
	pw: <input type="password" name="password"  />
	<input type="submit" value="로그인"/>

</form>
</body>
</html>