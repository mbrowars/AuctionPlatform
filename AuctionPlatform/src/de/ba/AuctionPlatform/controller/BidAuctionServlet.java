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
		// Double.parseDouble(requ.getParameter("bid"))
		Double bid = 12.05;
		String mail = requ.getParameter("email");
		EmailSaveBid em = new EmailSaveBid();
		BidHandler bi = new BidHandler();
		Codegenerator gen = new Codegenerator();
		int code = gen.auctionSecurity();
		Codevalidator valid = new Codevalidator();

		if (bi.checkBid(new Long(1234), bid, mail) == true) {

			try {

				em.send(mail, "Auktionsbestätigung für Artikel (plus id)",
						"Bitte geben Sie diesen Code auf der Webside ein: " + code);

			} catch (MessagingException e) {

				// TODO Auto-generated catch block
				requ.setAttribute("error", "Fehler bei Emailübertragung");
				e.printStackTrace();
			}
			String usercode = requ.getParameter("code");
		boolean rightcode=	valid.validate(usercode, code);

		}

		if (bi.saveBid(new Long(1234), bid, mail) == true) {

			requ.setAttribute("bidSaved", true);
			requ.setAttribute("code", code);
			requ.getRequestDispatcher("/auction.jsp").forward(requ, resp);

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
