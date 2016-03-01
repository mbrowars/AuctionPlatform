/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ba.auctionPlatform.dao.Auction;
import de.ba.auctionPlatform.dao.AuctionDAO;
import de.ba.auctionPlatform.servletHandler.AuctionHelper;

/**
 * Servlet fuer den Aufruf einer Auktion 
 * path: "/auction?id" 
 * @author Matthias Browarski
 */
public class AuctionServlet extends HttpServlet {

	private static final long serialVersionUID = -1865643688426963594L;

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		if (requ.getParameter("id") != null) {
			Auction auc = new Auction();
			AuctionHelper ah = new AuctionHelper();
			// Auktionen aktualisieren
			List<Auction> auction = AuctionDAO.getAllAuctions();
			String json = ah.json(auction);
			ah.saveJson(json, requ.getServletContext().getRealPath(""));
			// Auktion darstellen
			auc = AuctionDAO.getAuction(Integer.parseInt(requ.getParameter("id")));
			requ.setAttribute("auction", auc);
			requ.setAttribute("date", new Date().getTime());
			requ.getRequestDispatcher("/auction.jsp").forward(requ, resp);
		}
	}
}