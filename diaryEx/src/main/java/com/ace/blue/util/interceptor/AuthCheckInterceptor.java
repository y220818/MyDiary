package com.ace.blue.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//request에서 session 빼라 - 없으면 말고
		HttpSession session = request.getSession(false);
		if (session != null) {
			//세션에서 authInfo 추출 - 있으면 AuthInfo 객체, 없으면 null
			Object authInfo = session.getAttribute("authInfo");
			System.out.println("authInfo >>>>> " + authInfo);
			//로그인 했다면
			if (authInfo != null) {
				//갈 길 가라 -> /edit/changePassword
				return true;
			}
		}
		//로그인 안 했음 -> 브라우저에게 /login이라고 요청하도록 시킴 -> 로그인 컨트롤러 -> 로그인 폼이 날아감
		response.sendRedirect(request.getContextPath() + "/member/loginForm");
		return false;
	}
	
	
}
