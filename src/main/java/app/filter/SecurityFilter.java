package app.filter;

import app.security.Authentication;
import app.security.SecurityConfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class SecurityFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) {
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		Authentication authentication = (Authentication) request.getSession().getAttribute("auth");
		SecurityConfig securityConfig = (SecurityConfig) request.getServletContext().getAttribute("securityConfig");
		
		List<String> allowedURLs = securityConfig.getAllowedURLs(authentication.getAuthority());
		
		for (String allowedURL : allowedURLs) {
			if (request.getServletPath().equals(allowedURL)) {
				filterChain.doFilter(request, response);
			}
		}
		throw new ServletException("Forbidden");
	}
	
	@Override
	public void destroy() {
	}
}
