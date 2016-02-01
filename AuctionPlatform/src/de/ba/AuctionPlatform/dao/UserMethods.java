package de.ba.AuctionPlatform.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import de.ba.AuctionPlatform.dao.User;

public class UserMethods {

	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	public Long addUser(Long userid, String email, String code, String ip) {
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
	
	public void removeUser(Long userid) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
												//hier �berall noch Methoden einf�gen, grad zu doof und zu m�de dazu
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public void alterEmail(Long userid) {
		
	}
	
	public void alterIp() {
		
	}
	
	public List getAllUsers() {
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