/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.controller;

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

import de.ba.auctionPlatform.dao.Auction;
import de.ba.auctionPlatform.dao.AuctionDAO;
import de.ba.auctionPlatform.dao.HibernateUtil;
import de.ba.auctionPlatform.servletHandler.AuctionHelper;

/**
 * Servlet fuer die Indexseite
 * path:"/", "/index"
 * @author Matthias Browarski
 *
 */

public class AuctionPlatformServlet extends HttpServlet {
	static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AuctionPlatformServlet.class);



	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = requ.getSession(true);
		try {

			HibernateUtil hibernate = HibernateUtil.getInstance();
			logger.log(Level.INFO, "Initializing Hibernate");
			List<Auction> auction = AuctionDAO.getAllAuctions();
			session.setAttribute("auctions", auction);
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
