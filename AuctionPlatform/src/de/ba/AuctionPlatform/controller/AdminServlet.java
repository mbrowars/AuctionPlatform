package de.ba.AuctionPlatform.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		AdminHandler ad = new AdminHandler();
		Admin admin = new Admin();
		admin.setUsername(requ.getParameter("username"));
		admin.setPassword(requ.getParameter("password"));
		HttpSession session = requ.getSession(true);
		if (ad.validUser(admin.getUsername(), admin.getPassword()) == true) {
			session.setAttribute("admin",admin);
			requ.setAttribute("admin", admin);
			requ.getRequestDispatcher("/index.jsp").forward(requ, resp);
		} else {
			resp.sendRedirect("goadmin.jsp");
		}
	}
	
	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}
}
