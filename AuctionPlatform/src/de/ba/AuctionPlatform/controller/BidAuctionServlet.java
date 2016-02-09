package de.ba.AuctionPlatform.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.AuctionPlatform.codegen.Codegenerator;
import de.ba.AuctionPlatform.codegen.Codevalidator;
import de.ba.AuctionPlatform.dao.Admin;
import de.ba.AuctionPlatform.emailservice.SendMail;

/**
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

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {

		SendMail em = new SendMail();
		BidHandler bi = new BidHandler();
		Codegenerator gen = new Codegenerator();

		Codevalidator valid = new Codevalidator();

		// Angebot mit der Datenbank vergleichen / Email senden /
		// Sicherkeitscode testen

		if ((requ.getParameter("mail") != null) && (requ.getParameter("bid") != null)) {
			code = gen.auctionSecurity();
			System.out.println(code);
			bid = Double.parseDouble(requ.getParameter("bid"));
			if (bid < 0) {
				resp.getWriter().write("Bitte geben Sie ein positives Gebot ein.");
				logger.log(Level.WARN, "Negatives Gebot wurde eingetragen.");
			}
			mail = requ.getParameter("mail");

			if (bi.checkBid(new Long(1234), bid, mail) == true) {

				try {

					em.send(mail, "Auktionsbestaetigung fuer Artikel (plus id)",
							"Bitte geben Sie diesen Code auf der Website ein: " + code);
					resp.getWriter().write("null");

				} catch (MessagingException e) {

					// TODO Auto-generated catch block
					resp.getWriter().write("Fehler bei Emailuebertragung");
					e.printStackTrace();
				}
			} else {
				resp.getWriter().write("Biete mehr als den aktuellen Preis");
			}
		}
		if (requ.getParameter("code") != null) {
			String usercode = requ.getParameter("code");

			boolean rightcode = valid.validate(usercode, code);

			if (rightcode) {
				// Angebot speichern und status und code an view uebergeben
				if (bi.saveBid(new Long(1234), bid, mail) == true) {
					resp.getWriter().write("null");
				} else {
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
