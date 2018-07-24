package app.service;

import app.entity.News;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NewsService {
	
	List<News> getAllNews();
	News getNewsById(int id);
	void saveNews(News news, String username);
	void deleteNews(String[] newsToDelete);
}
