package app.controller;

import app.entity.News;
import app.service.NewsService;

import javax.inject.Inject;
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
		if (request.getParameter("id").equals("")) {
			news = new News();
		} else {
			news = newsService.getNewsById(Integer.parseInt(request.getParameter("id")));
		}
		
		news.setTitle(request.getParameter("title"));
		news.setBrief(request.getParameter("brief"));
		news.setContent(request.getParameter("content"));
		
		newsService.saveNews(news, "MOCK");
		response.sendRedirect("/news?id=" + news.getId());
	}
}