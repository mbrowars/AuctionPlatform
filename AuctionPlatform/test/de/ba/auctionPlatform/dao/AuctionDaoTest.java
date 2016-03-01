/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.dao;

import org.junit.Test;
import java.sql.*;
import de.ba.auctionPlatform.dao.Auction;
import junit.framework.Assert;

public class AuctionDaoTest {
	// TODO Testfall erstellen
	Auction auction1 = new Auction("titel", 24.50, (long) 1234235, "beschreibung", 12, null);
	Auction auction2 = new Auction("SNES", 123.45, (long) 32546, "Old Stuff with style (new Update)", 4, null);
	HibernateUtil hibernate = HibernateUtil.getInstance();

	@Test
	public void addAuction() {
		int id1 = AuctionDAO.addAuction(auction1);
		int id2 = AuctionDAO.addAuction(auction2);
		Assert.assertEquals(AuctionDAO.getAuction(id1).getTitel(), auction1.getTitel());
		Assert.assertEquals(AuctionDAO.getAuction(id2).getTitel(), auction2.getTitel());
	}

	@Test
	public void getAuction() {
		int id1 = AuctionDAO.addAuction(auction1);
		Assert.assertEquals(AuctionDAO.getAuction(id1).getTitel(), auction1.getTitel());

	}

	@Test
	public void removeAuction() {
		int id1 = AuctionDAO.addAuction(auction1);
		AuctionDAO.removeAuction(id1);
		Assert.assertEquals(AuctionDAO.getAuction(id1), null);

	}

//	@Test
//	public void updateAuction() {
//
//		int id = AuctionDAO.addAuction(auction1);
//		Auction auc= new Auction();
//		auc.setBeschreibung("neue beschreibung");
//		AuctionDAO.updateAuction(auc);
//		Assert.assertEquals(AuctionDAO.getAuction(id).getBeschreibung(), auction1.getBeschreibung());
//	}
}
