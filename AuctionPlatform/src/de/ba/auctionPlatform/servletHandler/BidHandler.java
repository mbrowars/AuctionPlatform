package de.ba.auctionPlatform.servletHandler;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.auctionPlatform.dao.Auction;
import de.ba.auctionPlatform.dao.AuctionDAO;
import de.ba.auctionPlatform.dao.User;
import de.ba.auctionPlatform.dao.UserDAO;
import de.ba.auctionPlatform.dbmock.AuctionMock;
import de.ba.auctionPlatform.dbmock.UserMock;

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
	public synchronized boolean saveBid(int id, Double bid, int userid) {
		auc = aucd.getAuction(id);
		auc.setGebot(bid);
		auc.setHoechstbietenderid(userid);
		aucd.updateAuction(auc);

		return true;
	}

}
