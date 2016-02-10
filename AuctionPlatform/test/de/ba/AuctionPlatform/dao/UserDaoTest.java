/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dao;

import java.util.List;

import org.junit.Test;

import de.ba.AuctionPlatform.dao.User;
import de.ba.AuctionPlatform.dao.UserDAO;
import de.ba.AuctionPlatform.dbmock.UserMock;

public class UserDaoTest {
	// TODO Testfall erstellen
	User user1 = new User(10, "max.mustermann@muster.de", 59129301, "192.168.0.4");
	
	public void addUser() {
		UserDAO.addUser(0, "test", 0, "test");
		UserDAO.addUser(1, "max.mustermann@muster.de", 59129301, "192.168.0.4");

	}

	
	public void removeUser() {
		UserDAO.removeUser(user1);
	}
	
	@Test
	public void getUser() {
		UserDAO.getUser(2);
	}
}
