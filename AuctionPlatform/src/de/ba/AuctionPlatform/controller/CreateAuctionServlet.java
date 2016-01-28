package de.ba.AuctionPlatform.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ba.AuctionPlatform.dao.Auction;

/**
 * @author mbrowars
 *
 */
public class CreateAuctionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1865643688426963594L;

	/**
	 * 
	 */

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {

		Auction auc = new Auction();
		auc.setTitel(requ.getParameter("title"));
		auc.setBeschreibung(requ.getParameter("desc"));
		auc.setEnddatum(requ.getParameter("end"));
		String gebot = requ.getParameter("bid");
		auc.setGebot(Double.parseDouble(gebot));
		// TODO save Auction in db
		requ.getRequestDispatcher("/index.jsp").forward(requ, resp);

	}
}