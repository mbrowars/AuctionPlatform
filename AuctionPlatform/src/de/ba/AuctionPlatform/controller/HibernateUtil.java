package de.ba.AuctionPlatform.controller;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author mbrowars
 *
 */
public class HibernateUtil {

	
	
	  static {
	    // Speichert 'SessionFactory'-Objekt einmalig im JNDI (weil 'session_factory_name' gesetzt ist):
	    SessionFactory sessionFactory = (new Configuration()).configure().buildSessionFactory();
	  }

	  public static SessionFactory getSessionFactory() throws NamingException
	  {
	    // Findet 'SessionFactory'-Objekt im JNDI:
	    Context context = new InitialContext();
	    SessionFactory sessionFactory = (SessionFactory) context.lookup( "hibernate/MeineSessionFactory" );
	    return sessionFactory;
	  }

	  public static Session getCurrentSession() throws HibernateException, NamingException
	  {
	    // Dies funktioniert so nur im Java EE Application Server mit 'CMTTransactionFactory':
	    Session session = getSessionFactory().openSession();
	    return session;
	  }
	}

