package kr.co.torpedo.helloservlet.repository.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import kr.co.torpedo.helloservlet.domain.Admin;
import kr.co.torpedo.helloservlet.domain.User;

public class HibernateRepository {
	private SessionFactory sessionFactory;
	private Session session;

	public HibernateRepository() {
		sessionFactory = HibernateConnectionFactory.getSessionFactory();
	}

	public Admin selectManager(String id) {
		session = sessionFactory.openSession();
		Admin manager = (Admin) session.get(Admin.class, id);
		session.close();

		return manager;
	}

	public List<User> selectUserList() {
		session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		criteriaQuery.from(User.class);
		List<User> list = session.createQuery(criteriaQuery).getResultList();
		session.close();

		return list;
	}

	public void insert(Admin manager) {
		if (selectManager(manager.getId()) != null) {
			return;
		}
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(manager);
		tx.commit();
		session.close();
	}
}
