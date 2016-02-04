package de.ba.AuctionPlatform.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import de.ba.AuctionPlatform.controller.CreateAuctionServlet;
import de.ba.AuctionPlatform.dao.User;

/**
 * @author
 *
 */
public class UserDAO {

	private static SessionFactory factory;
	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);

	/**
	 * @param userid
	 * @param email
	 * @param code
	 * @param ip
	 * @return
	 */
	/* User anlegen */
	public static long addUser(int userid, String email, Long code, String ip) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = new User(userid, email, code, ip);
			session.save(user);
			tx.commit();
			logger.log(Level.INFO, "User: " + userid + "," + email + " wurde angelegt.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.log(Level.ERROR, "User: " + userid + "," + email + " konnte nicht angelegt werden." + e);
		} finally {
			session.close();
		}
		return userid;
	}

	/* User löschen */
	/**
	 * @param user
	 */
	public void removeUser(User user) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			logger.log(Level.INFO, "User: " + user + " wurde gelöscht.");

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.log(Level.ERROR, "User: " + user + " konnte nicht gelöscht werden." + e);
		} finally {
			session.close();
		}
	}

	/* User ändern */
	/**
	 * @param user
	 */
	public void updateUser(User user) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(user);
			logger.log(Level.INFO, "User: " + user + " wurde aktualisiert.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.log(Level.ERROR, "User: " + user + " konnte nicht aktualisiert werden." + e);
		} finally {
			session.close();
		}
	}

	/* alle User aufzählen */ // @Göppi brauchen wir nicht wirklich :D

	/**
	 * @return
	 */
	public static List getAllUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List users = new ArrayList();
		try {
			tx = session.beginTransaction();
			users = (List) session.createQuery("FROM User").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			logger.log(Level.ERROR, "User konnten nicht ausgelesen werden." + e);
			session.close();
		}
		return users;
	}

}
