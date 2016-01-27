package de.ba.AuctionPlatform.controller;

import de.ba.AuctionPlatform.dao.Admin;

/**
 * @author mbrowars
 *
 */
public class AdminHandler {

	Admin ad = new Admin();

	/**
	 * @param user Adminname
	 * @param pass Adminpasswort
	 * @return true= Erfolgreich angemeldet false= Fehler
	 */
	public boolean validUser(String user, String pass) {
		if (ad.getUsername().equals(user) && ad.getPassword().equals(pass)) {
			return true;
		} else {
			return false;
		}

	}

}
