package de.ba.AuctionPlatform.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		Double bid = Double.parseDouble(requ.getParameter("bid"));
		String mail = requ.getParameter("mail");
		EmailSaveBid em = new EmailSaveBid();
		BidHandler bi = new BidHandler();
		Codegenerator gen = new Codegenerator();
		int code = gen.auctionSecurity();
		Codevalidator valid = new Codevalidator();

		// Angebot mit der Datenbank vergleichen / Email senden /
		// Sicherkeitscode testen
		if (bi.checkBid(new Long(1234), bid, mail) == true) {

			try {

				em.send(mail, "Auktionsbest�tigung f�r Artikel (plus id)",
						"Bitte geben Sie diesen Code auf der Website ein: " + code);
				requ.setAttribute("error", "NULL");

			} catch (MessagingException e) {

				// TODO Auto-generated catch block
				requ.setAttribute("error", "Fehler bei Email�bertragung");
				e.printStackTrace();
			}
			String usercode = requ.getParameter("code");
			/*while (usercode == null) {
				usercode = requ.getParameter("code");
			}
			boolean rightcode = valid.validate(usercode, code);*/ //auskommentiert weil KOT

		}
		// Angebot speichern und status und code an view �bergeben
		if (bi.saveBid(new Long(1234), bid, mail) == true) {

			requ.setAttribute("bidSaved", true);
			requ.setAttribute("code", code);
			requ.getRequestDispatcher("/auction.jsp").forward(requ, resp);

			// Fehler beim speichern status zur�ckliefern und auf seite der
			// auktion zur�ckleiten
		} else {

			requ.setAttribute("bidSaved", false);
			requ.getRequestDispatcher("/auction.jsp").forward(requ, resp);
		}

		//

	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}
}
