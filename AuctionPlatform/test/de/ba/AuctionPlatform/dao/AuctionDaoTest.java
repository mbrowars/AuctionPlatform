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
	Auction auction1 = new Auction(1, "titel", 24.50, Date.valueOf("2222-08-04"), "beschreibung", 12, null);
	Auction auction2 = new Auction(5, "SNES", 123.45, java.sql.Date.valueOf("2015-02-17"), "Old Stuff", 4, null);
	
	
	@Test
	public void addAuction() {
		AuctionDAO.addAuction(auction1);
		AuctionDAO.addAuction(auction2);
	}
}
