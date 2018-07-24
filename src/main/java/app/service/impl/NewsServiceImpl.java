package app.service.impl;

import app.dao.NewsDAO;
import app.entity.News;
import app.service.NewsService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class NewsServiceImpl implements NewsService {
	
	@Inject
	private NewsDAO newsDAO;
	
	@Override
	public List<News> getAllNews() {
		return newsDAO.getAllNews();
	}
	
	@Override
	public News getNewsById(int id) {
		return newsDAO.getNewsById(id);
	}
	
	@Override
	public void saveNews(News news, String username) {
		if (news.getId() == 0) {
			news.setAuthor(username);
			news.setDate(new Date());
		} else {
			News oldNews = newsDAO.getNewsById(news.getId());
			news.setAuthor(oldNews.getAuthor());
			news.setDate(oldNews.getDate());
		}
		newsDAO.saveNews(news);
	}
	
	@Override
	public void deleteNews(String[] newsToDelete) {
		
		for (String checkbox : newsToDelete) {
			newsDAO.deleteNews(Integer.parseInt(checkbox));
		}
	}
}
