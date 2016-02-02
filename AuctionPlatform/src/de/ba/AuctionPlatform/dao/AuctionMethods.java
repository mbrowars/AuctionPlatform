package de.ba.AuctionPlatform.dao;

import java.sql.Blob;
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

import de.ba.AuctionPlatform.dao.Auction;

public class AuctionMethods {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	/*Auktion anlegen*/
	public Long addAuction(Long auctionid, String titel, Double gebot, String enddatum, String beschreibung, Long hoechstbietenderid, Blob picture) {
		Session session = factory.openSession();
		Transaction tx = null;
		Long auctionidSaved = null;
		try {
			tx = session.beginTransaction();
			Auction auction = new Auction(auctionid, titel, gebot, enddatum, beschreibung, hoechstbietenderid, picture);
			auctionidSaved = (Long) session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return useridSaved;
	}
	
	/* Auktion löschen */
	public void removeAuction(Auction auction) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(auction);
			tx.commit();
												
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	
	/*Auktion ändern*/
	public void updateAuction(Auction auction) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(auction);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public List getAllAuctions() {
		Session session = factory.openSession();
		Transaction tx = null;
		List auctions = new ArrayList();
		try {
			tx = session.beginTransaction();
			auctions = (List)session.createQuery("FROM Auction").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return auctions;
	}
}
