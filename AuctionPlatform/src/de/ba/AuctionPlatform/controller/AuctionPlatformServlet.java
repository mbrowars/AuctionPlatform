/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.controller;

import java.io.*;
import java.util.List;
import java.util.Iterator;
import java.util.Date;
import java.lang.String;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.AuctionDAO;
import de.ba.AuctionPlatform.dao.HibernateUtil;

/**
 * 
 * @author Matthias Browarski
 *
 */

public class AuctionPlatformServlet extends HttpServlet {
	static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AuctionPlatformServlet.class);

	// public void init() {
	// try {
	//
	// HibernateUtil hibernate = HibernateUtil.getInstance();
	// logger.log(Level.INFO, "Initializing Hibernate");
	// } catch (HibernateException ex) {
	// logger.log(Level.INFO, ex);
	// System.exit(5);
	// }
	// }

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = requ.getSession(true);
		try {

			HibernateUtil hibernate = HibernateUtil.getInstance();
			logger.log(Level.INFO, "Initializing Hibernate");
			List<Auction> auction = AuctionDAO.getAllAuctions();
			session.setAttribute("auctions", auction);
			AuctionPlatformServletTest t = new AuctionPlatformServletTest();
			t.listTest(auction);
			AuctionHelper ah = new AuctionHelper();

			String json = ah.json(auction);
			ah.saveJson(json, requ.getServletContext().getRealPath(""));
			logger.log(Level.INFO, requ.getServletContext().getRealPath("") + ", json wurde gespeichert.");

			session.setAttribute("auc", json);
			logger.log(Level.INFO, json);
			
			requ.setAttribute("date", (new Date()).getTime());

		} catch (HibernateException ex) {
			logger.log(Level.INFO, ex);
			System.exit(5);
		}
		requ.getRequestDispatcher("/index.jsp").forward(requ, resp);

	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}
}
