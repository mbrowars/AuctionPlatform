package de.ba.AuctionPlatform.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import de.ba.AuctionPlatform.dao.User;

public class TestUser {
	
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(User.class);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		factory = configuration.buildSessionFactory(serviceRegistry);
		TestUser testPerson = new TestUser();
		testPerson.addUser(3, "testmensch@test.com", "1337", "192.168.0.4" );
		
		List allUsers = testPerson.getallUsers();
		for(User emp : allUsers){
			System.out.print(emp.getId() + " ");
			System.out.print(emp.getEmail() + " ");
			System.out.print(emp.getCode() + " ");
			System.out.print(emp.getIp() + " ");
		}
	
	}
	
	private Long addUser(Long userid, String email, String code, String ip) {
		Session session = factory.openSession();
		Transaction tx = null;
		Long useridSaved = null;
		try {
			tx = session.beginTransaction();
			User user = new User(userid, email, code, ip);
			useridSaved = (Long) session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return useridSaved;
	}
	
	@SuppressWarnings("unchecked")
	private List getAllUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List users = new ArrayList();
		try {
			tx = session.beginTransaction();
			users = (List)session.createQuery("FROM User").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}
}