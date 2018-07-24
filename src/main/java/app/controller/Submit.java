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

@WebServlet("/submit")
public class Submit extends HttpServlet {
	
	@Inject
	private NewsService newsService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		News news;
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("id").equals(""));
		if (request.getParameter("id").equals("")) {
			System.out.println("IF");
			news = new News();
		} else {
			System.out.println("ELSE");
			news = newsService.getNewsById(Integer.parseInt(request.getParameter("id")));
		}
		
		news.setTitle(request.getParameter("title"));
		news.setBrief(request.getParameter("brief"));
		news.setContent(request.getParameter("content"));
		
		newsService.saveNews(news, "MOCK");
		response.sendRedirect("/news?id=" + news.getId());
	}
}