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
import de.ba.AuctionPlatform.emailservice.EmailSaveBid;

/**
 * @author Matthias Browarski
 *
 */
public class BidAuctionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8982518104080193013L;
	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);
	private int code = 0;
	private Double bid;
	private String mail;

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {

		EmailSaveBid em = new EmailSaveBid();
		BidHandler bi = new BidHandler();
		Codegenerator gen = new Codegenerator();

		Codevalidator valid = new Codevalidator();

		// Angebot mit der Datenbank vergleichen / Email senden /
		// Sicherkeitscode testen

		if ((requ.getParameter("mail") != null) && (requ.getParameter("bid") != null)) {
			code = gen.auctionSecurity();
			System.out.println(code);
			bid = Double.parseDouble(requ.getParameter("bid"));
			mail = requ.getParameter("mail");

			if (bi.checkBid(new Long(1234), bid, mail) == true) {

				try {

					em.send(mail, "Auktionsbestaetigung fuer Artikel (plus id)",
							"Bitte geben Sie diesen Code auf der Website ein: " + code);
					requ.setAttribute("error", "NULL");

				} catch (MessagingException e) {

					// TODO Auto-generated catch block
					requ.setAttribute("error", "Fehler bei Emailuebertragung");
					e.printStackTrace();
				}
			}

			/*
			 * while (usercode == null) { usercode = requ.getParameter("code");
			 * } boolean rightcode = valid.validate(usercode, code);
			 */ // auskommentiert weil KOT

		}
		if (requ.getParameter("code") != null) {
			String usercode = requ.getParameter("code");

			boolean rightcode = valid.validate(usercode, code);

			// Angebot speichern und status und code an view uebergeben
			if (bi.saveBid(new Long(1234), bid, mail) == true) {

				requ.setAttribute("bidSaved", true);
				requ.setAttribute("code", code);
				requ.getRequestDispatcher("/auction.jsp").forward(requ, resp);

				// Fehler beim speichern status zur�ckliefern und auf seite
				// der
				// auktion zur�ckleiten
			} else {

				requ.setAttribute("bidSaved", false);
				requ.getRequestDispatcher("/auction.jsp").forward(requ, resp);
			}

		}

	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}
}
