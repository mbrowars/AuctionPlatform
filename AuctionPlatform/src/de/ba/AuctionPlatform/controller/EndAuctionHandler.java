package de.ba.AuctionPlatform.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.AuctionDAO;
import de.ba.AuctionPlatform.dao.User;
import de.ba.AuctionPlatform.dao.UserDAO;
import de.ba.AuctionPlatform.emailservice.SendMail;

/**
 * @author mbrowars Handler für endende Auktionen (Zeit abgelaufen)
 */
public class EndAuctionHandler {

	AuctionDAO da = new AuctionDAO();
	SendMail mail = new SendMail();
	User user = new User();
	UserDAO usd = new UserDAO();

	public void endAuction(Auction auction) throws AddressException, MessagingException {
		// TODO Neue Datenbanktabelle mit alten Auktionen
		// expiredAuction.addAuction(auction);
		user = usd.getUser(auction.getHoechstbietenderid());
		mail.send(user.getEmail(), "Aukion " + auction.getTitel() + " wurde beendet",
				"Sie haben die Auktion für den Artikel " + auction.getTitel() + " gewonnen");
		da.removeAuction(auction);
	}

}
