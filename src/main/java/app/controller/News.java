package app.controller;

import app.service.NewsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/news")
public class News extends HttpServlet {
	
	@Inject
	private NewsService newsService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("news", newsService.getNewsById(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("WEB-INF/jsp/news.jsp").forward(request, response);
	}
}