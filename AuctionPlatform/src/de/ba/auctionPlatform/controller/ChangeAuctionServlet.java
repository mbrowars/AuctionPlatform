/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.controller;

import java.io.File;
import java.io.IOException;
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
 * Servlet zum veraendern von Auktionen
 * path:"/auction/edit"
 * @author Matthias Browaski
 *
 */
@MultipartConfig(location = "/pictures", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ChangeAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = -1865643688426963594L;
	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);

	private static final String SAVE_DIR = "pictures/";
	private Auction auc = new Auction();
	
	String fileName;

	public void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = requ.getSession(true);

		if (session.getAttribute("admin") != null) {
			if (requ.getPart("picture") != null) {

				String appPath = requ.getServletContext().getRealPath("");
				String savePath = appPath + File.separator + SAVE_DIR;

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
			auc.setAuctionid(Integer.parseInt(requ.getParameter("id")));
			// hï¿½chstbietenderid standard auf null um auktionen fï¿½r die
			// nicht
			// geboten wurde lï¿½schen zu kï¿½nnen
			AuctionDAO.updateAuction(auc);

			resp.sendRedirect("/AuctionPlatform/");
		}

		else

		{
			resp.sendRedirect("/");
		}

	}

	public void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {

		doGet(requ, resp);
	}

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
