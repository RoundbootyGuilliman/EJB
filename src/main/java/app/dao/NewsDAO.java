package app.dao;

import app.entity.News;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NewsDAO {

	List<News> getAllNews();
	News getNewsById(int id);
	int saveNews(News news);
	void deleteNews(int id);
}
