package de.ba.AuctionPlatform.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.AuctionDAO;

/**
 * @author mbrowars
 *
 */
public class CreateAuctionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1865643688426963594L;
	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);

	/**
	 * 
	 */

	@Override
	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = requ.getSession(true);

		if (session.getAttribute("admin") != null) {

			Auction auc = new Auction();
			AuctionDAO da = new AuctionDAO();

			// Bild in Datenbank speichern. *Fehlerhaft (und gerade kein bock
			// weiter zu machen :D)
			
			Blob blob = null;
			try {
				blob.getBinaryStream(new Long(requ.getParameter("picture")), 10);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//"ausgabe" bild  
			System.out.println(requ.getParameter("picture").getBytes());

			auc.setPicture(blob);
			logger.log(Level.INFO, auc.getPicture());
			auc.setTitel(requ.getParameter("title"));
			auc.setBeschreibung(requ.getParameter("desc"));
			//TODO Ablaufdatum setzen (String Date Konvertierung)
		//	auc.setEnddatum(requ.getParameter("end"));
			String gebot = requ.getParameter("bid");
			auc.setGebot(Double.parseDouble(gebot));
			da.addAuction(auc);
			logger.log(Level.INFO, "Auktion :" + auc.getId() + "," + auc.getTitel() + " Wurde angelegt.");
			// TODO save Auction in db
			requ.getRequestDispatcher("/index.jsp").forward(requ, resp);

		}

		else {
			requ.getRequestDispatcher("/error.jsp").forward(requ, resp);
		}
	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}
}