package app.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class LocaleChangeFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) {
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String lang = request.getParameter("lang");
		
		if (lang != null) {
			if (lang.equals("en")) {
				request.getSession().setAttribute("locale", new Locale("en", "US"));
			} else if (lang.equals("ru")) {
				request.getSession().setAttribute("locale", new Locale("ru", "KZ"));
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
	}
}