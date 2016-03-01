package de.ba.auctionPlatform.servletHandler;

import de.ba.auctionPlatform.dao.Admin;

/**
 * @author mbrowars
 *
 */
public class AdminHandler {

	Admin ad = new Admin();

	/**
	 * @param user Adminname
	 * @param pass Adminpasswort
	 * @return true= erfolgreich angemeldet false= fehler
	 */
	public boolean validUser(String user, String pass) {
		if (ad.getUsername().equals(user) && ad.getPassword().equals(pass)) {
			return true;
		} else {
			return false;
		}

	}

}
