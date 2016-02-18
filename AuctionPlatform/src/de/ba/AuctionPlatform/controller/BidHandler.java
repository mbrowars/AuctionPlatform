package de.ba.AuctionPlatform.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.AuctionDAO;
import de.ba.AuctionPlatform.dao.User;
import de.ba.AuctionPlatform.dao.UserDAO;
import de.ba.AuctionPlatform.dbmock.AuctionMock;
import de.ba.AuctionPlatform.dbmock.UserMock;

/**
 * @author Matthias Browarski
 *
 */
public class BidHandler {

	private Auction auc = new Auction();
	private AuctionDAO aucd = new AuctionDAO();
	private static final Logger logger = Logger.getLogger(BidHandler.class);

	/**
	 * @param id
	 *            Auction-ID
	 * @param bid
	 *            Bid/Auction
	 * @return true = bid is valid
	 */
	public synchronized boolean checkBid(int id, Double bid) {
		auc = aucd.getAuction(id);
		// TODO GEBOT von view übergeben
		Double userBid = auc.getGebot();

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
	public synchronized boolean saveBid(int id, Double bid) {

		auc.setGebot(bid);
		// TODO: Get Id by email!
		auc.setHoechstbietenderid(id);
		aucd.updateAuction(auc);

		return true;
	}

}
