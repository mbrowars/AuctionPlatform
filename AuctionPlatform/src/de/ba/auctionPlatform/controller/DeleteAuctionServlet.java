/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ba.auctionPlatform.dao.AuctionDAO;

/**
 * Servlet um Auktionen zu loeschen
 * path: "/auction/delete"
 * @author Matthias Browarski
 *
 */
public class DeleteAuctionServlet extends HttpServlet {

	private static final long serialVersionUID = 5653752108107841912L;

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		if (requ.getParameter("id") != null) {

			AuctionDAO.removeAuction(Integer.parseInt(requ.getParameter("id")));
			resp.getWriter().write("Auktion " + requ.getParameter("id") + " wurde gelöscht.");
		} else {
			resp.getWriter().write("Fehler bein Löschen der Auktion.");
		}
		requ.getRequestDispatcher("/index.jsp").forward(requ, resp);
	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}
}
