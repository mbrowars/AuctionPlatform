/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import de.ba.auctionPlatform.dao.User;

/**
 * @author
 *
 */
public class UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAO.class);

	/**
	 * @param userid
	 * @param email
	 * @param code
	 * @return
	 */
	/* User anlegen */
	public static int addUser(User user) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			
			session.save(user);
			tx.commit();
			logger.log(Level.INFO, "User: " + user.getId() + "," + user.getEmail() + " wurde angelegt.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.log(Level.ERROR, "User: " + user.getId() + "," + user.getEmail() + " konnte nicht angelegt werden." + e);
		} finally {
			session.close();
		}
		return user.getId();
	}

	/* User l�schen */
	/**
	 * @param user
	 */
	public static void removeUser(int userid) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Query remove = session.createQuery("Delete User where USERID= " + userid);
			remove.executeUpdate();
			tx.commit();
			logger.log(Level.INFO, "User: " + userid + " wurde gel�scht.");

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.log(Level.ERROR, "User: " + userid + " konnte nicht gel�scht werden." + e);
		} finally {
			session.close();
		}
	}

	/* User �ndern */
	/**
	 * @param user
	 */
	public void updateUser(User user) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
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

	/* alle User aufz�hlen */ // @G�ppi brauchen wir nicht wirklich :D

	/**
	 * @return List<User>
	 */
	public static List getAllUsers() {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
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
	
	public static User getUser(int userid) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		Transaction tx = null;
		User user = new User();
		
		try {
			tx = session.beginTransaction();
			Query wanteduser = session.createQuery("FROM User WHERE userid= :userid");
			wanteduser.setInteger("userid", userid);
			Object queryResult = wanteduser.uniqueResult();
			user = (User) queryResult;										
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			logger.log(Level.ERROR, "User konnte nicht ausgelesen werden." + e);
			session.close();
		}
		
		return user;
	}


}
