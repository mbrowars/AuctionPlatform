package de.ba.AuctionPlatform.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5533231596801685365L;
	private static final Logger logger = Logger.getLogger(LogoutServlet.class);

	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = requ.getSession(true);
		session.invalidate();
		logger.log(Level.INFO, "Adminsession wurde beendet.");
		resp.sendRedirect("/AuctionPlatform/");
	}
}
