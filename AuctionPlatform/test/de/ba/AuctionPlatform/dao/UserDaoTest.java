/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dao;

import java.util.List;

import org.junit.Test;

import de.ba.AuctionPlatform.dao.User;
import de.ba.AuctionPlatform.dao.UserMethods;

public class UserDaoTest {
	// TODO Testfall erstellen

	@Test
	public void addUser() {

		UserMethods.addUser(1, "max.mustermann@muster.de", new Long(59129301), "192.168.0.4");

	}

	@Test
	public void getAllUsers() {
		UserMethods.getAllUsers();
	}
}
