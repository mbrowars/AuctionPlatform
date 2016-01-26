package de.ba.AuctionPlatform.controller;

import de.ba.AuctionPlatform.dao.Admin;

public class AdminHandler {

	Admin ad = new Admin();

	public boolean validUser(String user, String pass) {
		if (ad.getUsername().equals(user) && ad.getPassword().equals(pass)) {
			return true;
		} else {
			return false;
		}

	}

}
