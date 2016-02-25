package de.ba.AuctionPlatform.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import de.ba.AuctionPlatform.dao.Auction;
import de.ba.AuctionPlatform.dao.AuctionDAO;

/**
 * @author mbrowars
 *
 */
@MultipartConfig(location = "/pictures", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CreateAuctionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1865643688426963594L;
	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);
	private static Session hsession;
	/**
	 * Name of the directory where uploaded files will be saved, relative to the
	 * web application directory.
	 */
	private static final String SAVE_DIR = "pictures/";
	private Auction auc = new Auction();
	private AuctionDAO aucd = new AuctionDAO();
	String fileName;

	/**
	 * 
	 */

	@Override

	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = requ.getSession(true);

		if (session.getAttribute("admin") != null) {
			if (requ.getPart("picture") != null) {
				// gets absolute path of the web application
				String appPath = requ.getServletContext().getRealPath("");
				// constructs path of the directory to save uploaded file
				String savePath = appPath + File.separator + SAVE_DIR;

				// creates the save directory if it does not exists
				File fileSaveDir = new File(savePath);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}

				Part part = requ.getPart("picture");
				String fileName = extractFileName(part);
				// Variabler Filepart f�r Webanwendung kommt am 25.02
				// part.write(savePath + File.separator + fileName);
				part.write(savePath + fileName);
				auc.setPicture(fileName);
				logger.log(Level.INFO, "img saved :" + savePath + fileName);
			}

			auc.setTitel(requ.getParameter("title"));
			auc.setBeschreibung(requ.getParameter("desc"));

			// TODO Ablaufdatum setzen (String Date Konvertierung)
			Date date = new Date();
			long sec = date.getTime();
			long time = Integer.parseInt(requ.getParameter("end"));
			auc.setLaufzeit(sec + time * 1000);

			String gebot = requ.getParameter("bid");
			auc.setGebot(Double.parseDouble(gebot));

			// h�chstbietenderid standard auf null um auktionen f�r die nicht
			// geboten wurde l�schen zu k�nnen
			auc.setHoechstbietenderid(0);
			int save = aucd.addAuction(auc);

			// Auktion in DB Speichern und Fehlerbehandlung
			if (save != 0) {
				resp.getWriter().write(0);

				requ.getRequestDispatcher("/").forward(requ, resp);
			} else {
				resp.getWriter().write("Auktion " + auc.getTitel() + " konnte nicht angelegt werden.");
			}

		}

		else

		{
			requ.getRequestDispatcher("/error.jsp").forward(requ, resp);
		}

	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		doGet(requ, resp);
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}