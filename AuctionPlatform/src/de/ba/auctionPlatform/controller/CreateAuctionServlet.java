/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import de.ba.auctionPlatform.dao.Auction;
import de.ba.auctionPlatform.dao.AuctionDAO;

/**
 * @author Matthias Browarski path:"/createAuction"
 *
 */
@MultipartConfig(location = "/pictures", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CreateAuctionServlet extends HttpServlet {

	private static final long serialVersionUID = -1865643688426963594L;
	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);
	private static final String SAVE_DIR = "pictures/";
	private Auction auc = new Auction();

	String fileName;

	/**
	 * 
	 */

	@Override

	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = requ.getSession(true);

		if (session.getAttribute("admin") != null) {
			if (requ.getPart("picture").getSize() != 0) {
				String appPath = requ.getServletContext().getRealPath("");
				String savePath = appPath + File.separator + SAVE_DIR;

				// Speicherort erstellen, falls er nicht existiert
				File fileSaveDir = new File(savePath);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}

				Part part = requ.getPart("picture");
				String fileName = extractFileName(part);
				part.write(savePath + fileName);
				auc.setPicture(fileName);
				logger.log(Level.INFO, "img saved :" + savePath + fileName);
			}

			auc.setTitel(requ.getParameter("title"));
			auc.setBeschreibung(requ.getParameter("desc"));

			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			Date date = new Date();
			String da = requ.getParameter("end");
			try {
				date = formatter.parse(da);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long sec = date.getTime();
			auc.setLaufzeit(sec);

			String gebot = requ.getParameter("bid");
			auc.setGebot(Double.parseDouble(gebot));

			// hoechstbietenderid standard auf null um auktionen fuer die
			// nicht
			// geboten wurde loeschen zu koennen
			auc.setHoechstbietenderid(0);
			int save = AuctionDAO.addAuction(auc);

			// Auktion in DB Speichern und Fehlerbehandlung
			if (save != 0) {
				resp.getWriter().write(0);

				resp.sendRedirect("/AuctionPlatform/");
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
	 * Methode um den Filenamen des Bildes auszulesen
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