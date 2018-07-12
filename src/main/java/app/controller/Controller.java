package app.controller;

import app.service.NewsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class Controller {
	
	@WebServlet("/main")
	static class Main extends HttpServlet {
		
		@Inject
		NewsService newsService;
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("newsList", newsService.getAllNews());
			request.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(request, response);
		}
	}
	
	@WebServlet("/news")
	static class News extends HttpServlet {
		
		@Inject
		NewsService newsService;
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("news", newsService.getNewsById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("WEB-INF/jsp/news.jsp").forward(request, response);
		}
	}
	
	@WebServlet("/add")
	static class Add extends HttpServlet {
		
		@Inject
		NewsService newsService;
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("news", newsService.getNewsById(Integer.parseInt(request.getParameter("newsId"))));
			request.getRequestDispatcher("WEB-INF/jsp/add.jsp").forward(request, response);
		}
	}
}
