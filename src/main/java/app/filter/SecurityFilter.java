package app.filter;

import app.security.Authentication;
import app.security.SecurityConfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		HttpSession session = request.getSession();
		
		Authentication authentication = (Authentication) session.getAttribute("auth");
		if (authentication == null) {
			authentication = new Authentication();
			session.setAttribute("auth", authentication);
		}
		SecurityConfig securityConfig = (SecurityConfig) request.getServletContext().getAttribute("securityConfig");
		
		List<String> forbiddenURLs = securityConfig.getForbiddenURLs(authentication.getAuthority());
		
		for (String forbiddenURL : forbiddenURLs) {
			if (request.getServletPath().equals(forbiddenURL)) {
				String path = request.getServletPath() + "?" + request.getQueryString();
				session.setAttribute("requestedPath", path);
				response.sendRedirect("/openLogin");
			}
		}
		filterChain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
	}
}