/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.dao;

import org.junit.Test;

import de.ba.auctionPlatform.dao.User;
import de.ba.auctionPlatform.dao.UserDAO;
import junit.framework.Assert;

public class UserDaoTest {
	// TODO Testfall erstellen
	User user1 = new User("max.mustermann@muster.de", 59129301);
	User user2 = new User("test", 12345678);
	HibernateUtil hibernate = HibernateUtil.getInstance();

	@Test
	public void addUser() {
		int us1 = UserDAO.addUser(user1);
		int us2 = UserDAO.addUser(user2);
		Assert.assertEquals(UserDAO.getUser(us1).getEmail(), user1.getEmail());
		Assert.assertEquals(UserDAO.getUser(us2).getEmail(), user2.getEmail());

	}

	@Test
	public void removeUser() {
		int us1 = UserDAO.addUser(user1);
		UserDAO.removeUser(UserDAO.getUser(us1).getId());
		Assert.assertEquals(UserDAO.getUser(us1), null);
	}

	@Test
	public void getUser() {
		int us1 = UserDAO.addUser(user1);
		Assert.assertEquals(UserDAO.getUser(us1).getEmail(), user1.getEmail());
	}
}
