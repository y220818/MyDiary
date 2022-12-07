<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css" />
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 폼</h1>

<form action="${pageContext.request.contextPath }/member/regist" method="post">
	ID: <input type="text" name="memberID"  /><hr />
	PW: <input type="password" name="password"  /><hr />
	NAME: <input type="text" name="name"  /><hr />
	EMAIL: <input type="text" name="email"  /><hr />
	<input type="submit" value="회원가입"/>

</form>
</body>
</html>