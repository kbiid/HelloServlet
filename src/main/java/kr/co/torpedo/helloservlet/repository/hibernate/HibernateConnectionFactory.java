package kr.co.torpedo.helloservlet.repository.hibernate;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import kr.co.torpedo.helloservlet.domain.Admin;
import kr.co.torpedo.helloservlet.domain.User;

public class HibernateConnectionFactory {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {
		String path = "D:/eclipse_workspace/HelloJSP/src/main/resources/hibernate.cfg.xml";
		Configuration configuration = new Configuration().configure(new File(path));
		configuration.addAnnotatedClass(Admin.class);
		configuration.addAnnotatedClass(User.class);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
