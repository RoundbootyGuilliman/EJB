package app.dao.impl;

import app.dao.UserDAO;
import app.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SessionFactory sessionFactory;

	@PreDestroy
	private void destroy() {
		if (sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(user);

		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public User getByEmail(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		User user = (User) session.createQuery("from User where email=:email").setParameter("email", email).uniqueResult();

		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	@Override
	public void deleteUser(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(getByEmail(email));

		session.getTransaction().commit();
		session.close();
	}
}