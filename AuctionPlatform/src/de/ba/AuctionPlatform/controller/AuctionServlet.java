package de.ba.AuctionPlatform.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.AuctionDAO;

public class AuctionServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		if (requ.getParameter("id") != null) {
			Auction auc = new Auction();
			AuctionDAO aucd = new AuctionDAO();
			auc = aucd.getAuction(Integer.parseInt(requ.getParameter("id")));
			requ.setAttribute("auction", auc);
			requ.setAttribute("date", new Date().getTime());
			requ.getRequestDispatcher("/auction.jsp").forward(requ, resp);
		}
	}
}