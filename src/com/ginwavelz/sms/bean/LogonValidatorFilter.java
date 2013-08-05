package com.ginwavelz.sms.bean;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.WebUtils;

import com.ginwavelz.sms.bean.user.User;

/**
 * 登陆过滤器
 * @author robin
 *
 */
public class LogonValidatorFilter implements Filter{
	


	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest= (HttpServletRequest) request;
		
		User user= (User) httpServletRequest.getSession().getAttribute("user");
		if(user==null){
			HttpServletResponse httpServletResponse=(HttpServletResponse) response;
			httpServletResponse.sendRedirect("/user/logon.do");
		}else{
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
