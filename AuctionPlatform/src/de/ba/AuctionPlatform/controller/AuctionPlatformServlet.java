/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.ba.AuctionPlatform.dao.HibernateUtil;

/**
 * 
 * @author Matthias Browarski
 *
 */

public class AuctionPlatformServlet extends HttpServlet {
	static final long serialVersionUID = 1L;
	private static SessionFactory factory;
	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HibernateUtil hibernate = new HibernateUtil();
			logger.log(Level.INFO, "Initializing Hibernate");

		} catch (HibernateException ex) {
			logger.log(Level.INFO, ex);
			System.exit(5);
		}
		requ.getRequestDispatcher("/index.jsp").forward(requ, resp);

	}
}
