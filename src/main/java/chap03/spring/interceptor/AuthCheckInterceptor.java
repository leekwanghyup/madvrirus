package chap03.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		// 세션이 있는 경우 
		if(session!=null) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo !=null) return true; 
		}
		// 세션이 없는 경우 
		response.sendRedirect(request.getContextPath()+"/login");
		
		return false;
	}
}
