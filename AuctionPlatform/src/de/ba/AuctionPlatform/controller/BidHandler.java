package de.ba.AuctionPlatform.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.User;
import de.ba.AuctionPlatform.dbmock.AuctionMock;
import de.ba.AuctionPlatform.dbmock.UserMock;

/**
 * @author Matthias Browarski
 *
 */
public class BidHandler {

	private Auction auc = new Auction();
	private User us = new User();
	private UserMock usm = new UserMock();
	private AuctionMock aucm = new AuctionMock();
	private static final Logger logger = Logger.getLogger(BidHandler.class);

	/**
	 * @param id
	 *            Auction-ID
	 * @param bid
	 *            Bid/Auction
	 * @param mail
	 *            Mail/User
	 * @return true = bid is valid
	 */
	public boolean checkBid(Long id, Double bid, String mail) {

		// TODO get gebot by Auction-ID
		Double userBid = aucm.getGebot();
		if (userBid < bid) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param id
	 * @param bid
	 * @param mail
	 * @return true = bid is saved
	 */
	public boolean saveBid(Long id, Double bid, String mail) {
		if (checkBid(id, bid, mail) == true) {
			aucm.setGebot(bid);
			// TODO: Get Id by email!
			usm.getUserId();
			aucm.setHoechstbietenderid(id);
			return true;
		} else {
			logger.log(Level.WARN, "Gebot für " + id + " konnte nicht gespeichert werden.");
			return false;
		}

	}
}
