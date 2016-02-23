package de.ba.AuctionPlatform.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.AuctionDAO;
import de.ba.AuctionPlatform.dao.User;
import de.ba.AuctionPlatform.dao.UserDAO;
import de.ba.AuctionPlatform.emailservice.SendMail;

/**
 * @author mbrowars Handler für endende Auktionen (Zeit abgelaufen)
 */
public class EndAuctionServlet extends HttpServlet {

	AuctionDAO da = new AuctionDAO();
	SendMail mail = new SendMail();
	User user = new User();
	UserDAO usd = new UserDAO();

	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		Auction auc = new Auction();
		auc = da.getAuction(Integer.parseInt(requ.getParameter("id")));
		if (auc.getHoechstbietenderid() == 0) {
			endWithoutWinner(auc);
		} else {
			user = usd.getUser(auc.getHoechstbietenderid());
			end(auc, user);
		}
		requ.getRequestDispatcher("/").forward(requ, resp);
	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}

	synchronized private void end(Auction auc, User user) {
		try {
			mail.send(user.getEmail(), "Auktion " + auc.getTitel() + " wurde beendet",
					"Sie haben die Auktion für den Artikel " + auc.getTitel() + " gewonnen");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		da.removeAuction(auc.getAuctionid());
	}

	private void endWithoutWinner(Auction auc) {

		da.removeAuction(auc.getAuctionid());

	}
}
