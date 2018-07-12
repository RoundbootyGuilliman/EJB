package app.filter;

import app.security.Authentication;
import app.security.SecurityConfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "securityFilter")
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
		
		List<String> forbiddenURLs = securityConfig.getForbiddenURLs(authentication.getAuthority());
		
		for (String forbiddenURL : forbiddenURLs) {
			if (request.getServletPath().equals(forbiddenURL)) {
				response.sendRedirect("/main");
			}
		}
		filterChain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
	}
}
