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

	// Singleton
	private static final HibernateUtil INSTANCE = new HibernateUtil();
	
	private static SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(HibernateUtil.class);

	/**
	 * private constructor
	 */
	private HibernateUtil() {
	}

	/**
	 * @return HibernateUtil instanz
	 */
	public static synchronized HibernateUtil getInstance() {
		if (sessionFactory == null) {
			INSTANCE.buildSessionFactory();
		}
		return INSTANCE;
	}

	private SessionFactory buildSessionFactory() {
		try {

			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			logger.debug("Configuration: " + config);
			this.sessionFactory = config.buildSessionFactory();
			logger.debug("SessionFactory: " + sessionFactory);
			return sessionFactory;

		} catch (Exception e) {

			logger.log(Level.INFO, "Initial SessionFactory creation failed." + e);
			e.getStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * @return SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}