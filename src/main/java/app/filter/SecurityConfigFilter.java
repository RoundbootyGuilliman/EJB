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

@WebFilter("/*")
public class SecurityConfigFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) {
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		Authentication authentication = (Authentication) request.getSession().getAttribute("auth");
		
		if (authentication == null) {
			request.getSession().setAttribute("auth", new Authentication());
			
			SecurityConfig securityConfig = new SecurityConfig();
			
			securityConfig.configureAdminRights("/delete", "/edit");
			securityConfig.configureUserRights("/add");
			securityConfig.configureGuestRights("/", "/main", "/news");
			
			request.getServletContext().setAttribute("securityConfig", securityConfig);
		}
		filterChain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
	}
}
