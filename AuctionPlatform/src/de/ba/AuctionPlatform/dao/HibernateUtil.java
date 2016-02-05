package de.ba.AuctionPlatform.dao;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.ba.AuctionPlatform.controller.CreateAuctionServlet;

/**
 * @author mbrowars
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory= buildSessionFactory();
	private static final Logger logger = Logger.getLogger(HibernateUtil.class);

private	static SessionFactory buildSessionFactory() {
		try {

			return new Configuration().configure().buildSessionFactory();
			
		} catch (Exception e) {

			logger.log(Level.INFO, "Initial SessionFactory creation failed." + e);
			e.getStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * @return 
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}