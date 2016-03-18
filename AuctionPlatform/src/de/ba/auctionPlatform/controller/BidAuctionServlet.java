/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.auctionPlatform.dao.AuctionDAO;
import de.ba.auctionPlatform.dao.User;
import de.ba.auctionPlatform.dao.UserDAO;
import de.ba.auctionPlatform.emailservice.SendMail;
import de.ba.auctionPlatform.servletHandler.BidHandler;
import de.ba.auctionPlatform.codegen.Codegenerator;

/**
 * Servlet zum bieten path: "auction/bid"
 * 
 * @author Matthias Browarski
 *
 */
public class BidAuctionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8982518104080193013L;
	private static final Logger logger = Logger.getLogger(BidAuctionServlet.class);
	private int code = 0;
	private Double bid;
	private String mail;
	private int saved;

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = requ.getSession(true);
		SendMail em = new SendMail();
		BidHandler bi = new BidHandler();
		Codegenerator gen = new Codegenerator();
		User user = new User();

		int userid = 0;
		int aucid;
		// Angebot mit der Datenbank vergleichen / Email senden /
		// Sicherkeitscode testen
		if ((requ.getParameter("mail") != null) && (requ.getParameter("bid") != null)) {
			code = gen.securityCode();
			bid = Double.parseDouble(requ.getParameter("bid"));
			if (bid < 0) {
				resp.getWriter().write("Bitte geben Sie ein positives Gebot ein.");
				logger.log(Level.WARN, "Negatives Gebot wurde eingetragen.");
			}

			// mail versenden
			mail = requ.getParameter("mail");
			int id = Integer.parseInt(requ.getParameter("id"));
			if (bi.checkBid(id, bid) == true) {

				try {

					Boolean message = em.send(mail,
							"Auktionsbestaetigung fuer Artikel " + AuctionDAO.getAuction(id).getTitel(),
							". Bitte geben Sie diesen Code auf der Website ein: " + code);
					user.setEmail(mail);
					user.setCode(code);
					userid = UserDAO.addUser(user);
					session.setAttribute("userid", user.getId());
					session.setAttribute("aucid", id);
					session.setAttribute("bid", bid);

					saved = user.getId();
					if (message == true) {
						resp.getWriter().write("null");
					} else {
						resp.getWriter().write("Email konnte nicht erfolgreich zugestellt werden.");
					}
				} catch (MessagingException e) {

					UserDAO.removeUser(userid);
				}
			} else {
				resp.getWriter().write("Biete mehr als den aktuellen Preis");
			}
		}

		// übergebener emailcode
		if (requ.getParameter("code") != null) {
			String usercode = requ.getParameter("code");

			boolean rightcode = gen.validate(usercode, code);

			if (rightcode) {
				// Angebot speichern und status und code an view uebergeben
				userid = (int) session.getAttribute("userid");
				aucid = (int) session.getAttribute("aucid");
				bid = (double) session.getAttribute("bid");

				if (bi.saveBid(aucid, bid, userid) == true) {

					resp.getWriter().write("null");
				} else {
					// userd.removeUser(userid);
					resp.getWriter().write("Gebot konnte nicht gespeichert werden!");
				}
			} else {
				resp.getWriter().write("Falscher Code wurde eingegeben!");
			}

		}

	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}
}
