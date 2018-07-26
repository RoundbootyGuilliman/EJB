package app.controller;

import app.service.NewsService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	
	@Inject
	private NewsService newsService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String[] deleteNewsCheckboxes = request.getParameterValues("deleteNewsCheckbox");
		
		if (deleteNewsCheckboxes != null) {
			newsService.deleteNews(deleteNewsCheckboxes);
		}
		
		response.sendRedirect("/main");
	}
}