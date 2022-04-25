package com.instagram.app.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instagram.app.domain.user.User;

public class AuthFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
	
		HttpSession session = httpServletRequest.getSession();
		User user = (User)session.getAttribute("principal");

		String path = httpServletRequest.getRequestURI();
		
		if(path.contains("/app/auth")){ //해당 주소 포함시
			if(user != null) {//로그인 되어진 상태
				httpServletResponse.sendRedirect("/app/"); //index.jsp
				return;
			}
		}else if(path.contains("/app/static")){
			//아무 요청 없음. 그냥 넘어감
		}else {
			if(user == null) { //로그인이 안되어 있는 상태
				httpServletResponse.sendRedirect("/app/auth/signin");
				return;
			}
		}
		chain.doFilter(httpServletRequest, httpServletResponse);
		
	}


}




















