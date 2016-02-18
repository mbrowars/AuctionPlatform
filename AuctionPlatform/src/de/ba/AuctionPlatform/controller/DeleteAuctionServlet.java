package de.ba.AuctionPlatform.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.AuctionDAO;

public class DeleteAuctionServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		if (requ.getParameter("id") != null) {
			Auction auc = new Auction();
			AuctionDAO aucd = new AuctionDAO();
			aucd.removeAuction(Integer.parseInt(requ.getParameter("id")));
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
