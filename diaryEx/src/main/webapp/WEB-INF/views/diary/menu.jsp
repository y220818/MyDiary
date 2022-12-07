<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <ul>

  	<li><a href="${pageContext.request.contextPath }/diary/viewAll">일기 전체 보기</a></li>
  	<li>일자별 검색 <form action="${pageContext.request.contextPath }/searchByDate"><input type="date" name="date"> <input type="submit" value="검색"/></form></li>
  	<li>단어 검색 <form action="${pageContext.request.contextPath }/searchByWord"><input type="text" name="word"> <input type="submit" value="검색"/></form></li>
  	<li><a href="${pageContext.request.contextPath }/diary/write">일기 작성</a></li>
  	<c:if test="${empty authInfo }">
  	<li><a href="${pageContext.request.contextPath }/member/loginForm">로그인</a></li>
  	<li><a href="${pageContext.request.contextPath }/member/registForm">회원가입</a></li>
  	</c:if>
  	<c:if test="${!empty authInfo }">
  	<li><a href="${pageContext.request.contextPath }/member/logout">로그아웃</a></li>
  	</c:if>
  	
  	
  </ul>