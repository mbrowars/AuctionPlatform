/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dao;

import org.junit.Test;
import java.sql.*;

public class AuctionDaoTest {
	//TODO Testfall erstellen
	Auction auction1 = new Auction("titel", 24.50, (long) 1234235, "beschreibung", 12, null);
	Auction auction2 = new Auction("SNES", 123.45, (long) 32546, "Old Stuff", 4, null);
	
	
	
	public void addAuction() {
		AuctionDAO.addAuction(auction1);
		AuctionDAO.addAuction(auction2);
	}
	
	
	public void getAuction() {
		AuctionDAO.getAuction(3);
	}
	
	@Test
	public void removeAuction() {
		AuctionDAO.removeAuction(16);
		AuctionDAO.removeAuction(17);
	}
}
