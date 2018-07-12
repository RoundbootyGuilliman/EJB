package app.dao;

import app.entity.News;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface NewsDAORemote {
	
	List<News> getAllNews();
	News getNewsById(int id);
	List<News> getNewsByAuthor(String username);
	int saveNews(News news);
	void deleteNews(int id);
}
