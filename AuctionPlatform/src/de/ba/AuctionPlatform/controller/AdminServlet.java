package de.ba.AuctionPlatform.controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.AuctionPlatform.dao.Admin;

/**
 * @author mbrowars
 *
 */
public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1069535271249328988L;
	private static final Logger logger = Logger.getLogger(AdminServlet.class);

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		AdminHandler ad = new AdminHandler();
		Admin admin = new Admin();

		admin.setUsername(requ.getParameter("username"));
		admin.setPassword(requ.getParameter("password"));

		HttpSession session = requ.getSession(true);
		if (ad.validUser(admin.getUsername(), admin.getPassword()) == true) {
			session.setAttribute("admin", admin);
			requ.setAttribute("admin", admin);
			logger.log(Level.INFO, "Anmeldung durch User: " + admin.getUsername());
			requ.getRequestDispatcher("/index.jsp").forward(requ, resp);
		} else {
			resp.sendRedirect("goadmin.jsp");
			logger.log(Level.WARN, "Fehlversuch bei Anmeldung, User: " + admin.getUsername());

		}
	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}
}
