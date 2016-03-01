package de.ba.auctionPlatform.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ba.auctionPlatform.dao.Auction;
import de.ba.auctionPlatform.dao.AuctionDAO;
import de.ba.auctionPlatform.dao.User;
import de.ba.auctionPlatform.dao.UserDAO;
import de.ba.auctionPlatform.emailservice.SendMail;
import de.ba.auctionPlatform.servletHandler.AuctionHelper;

/**
 * Handler für endende Auktionen (Zeit abgelaufen) path:"/auction/end"
 * 
 * @author mbrowars
 */
public class EndAuctionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2248786246301079770L;

	SendMail mail = new SendMail();
	User user = new User();
	Auction auc = new Auction();
	AuctionHelper ah = new AuctionHelper();

	public synchronized void doGet(HttpServletRequest requ, HttpServletResponse resp)
			throws ServletException, IOException {

		auc = AuctionDAO.getAuction(Integer.parseInt(requ.getParameter("id")));
		if (auc == null) {

		} else {
			if (auc.getHoechstbietenderid() == 0) {
				endWithoutWinner(auc);

			} else {
				user = UserDAO.getUser(auc.getHoechstbietenderid());
				end(auc, user);

			}
		}
		List<Auction> auction = AuctionDAO.getAllAuctions();
		String json = ah.json(auction);
		ah.saveJson(json, requ.getServletContext().getRealPath(""));
		requ.getRequestDispatcher("/").forward(requ, resp);
	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}

	/**
	 * Emailversand und loeschen einer Auktion
	 * 
	 * @param auc
	 *            zu loeschende Auktion
	 * @param user
	 *            hoechstbietender
	 */
	private void end(Auction auc, User user) {
		try {
			mail.send(user.getEmail(), "Auktion " + auc.getTitel() + " wurde beendet",
					"Sie haben die Auktion für den Artikel " + auc.getTitel() + " gewonnen");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AuctionDAO.removeAuction(auc.getAuctionid());
	}

	/**
	 * Methode zum loeschen einer Auktion ohne Hoechtbietenden
	 * 
	 * @param auc
	 *            zu loeschende Auktion
	 */
	private void endWithoutWinner(Auction auc) {

		AuctionDAO.removeAuction(auc.getAuctionid());

	}
}
