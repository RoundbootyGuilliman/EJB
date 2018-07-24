package app.dao.impl;

import app.dao.NewsDAO;
import app.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class NewsDAOImpl implements NewsDAO {

	@Inject @Default
	private SessionFactory sessionFactory;

	@PreDestroy
	private void destroy() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	@Override
	public List<News> getAllNews() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<News> newsList = session.createQuery("from News order by id").list();

		session.getTransaction().commit();
		session.close();
		return newsList;
	}

	@Override
	public News getNewsById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		News news = (News) session.createQuery("from News where id=:id").setParameter("id", id).uniqueResult();

		session.getTransaction().commit();
		session.close();
		return news;
	}

	@Override
	public int saveNews(News news) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(news);

		session.getTransaction().commit();
		session.close();
		return news.getId();
	}

	@Override
	public void deleteNews(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(getNewsById(id));

		session.getTransaction().commit();
		session.close();
	}
}