package app.controller;

import app.entity.News;
import app.service.NewsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	
	@Inject
	private NewsService newsService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		News news = newsService.getNewsById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("id", news.getId());
		request.setAttribute("title", news.getTitle());
		request.setAttribute("brief", news.getBrief());
		request.setAttribute("content", news.getContent());
		request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
	}
}