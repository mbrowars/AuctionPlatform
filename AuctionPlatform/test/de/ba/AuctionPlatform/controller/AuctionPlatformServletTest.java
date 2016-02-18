/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.controller;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.websocket.Session;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.AuctionPlatform.dao.Auction;

/**
 * 
 * @author Matthias Browarski
 *
 */

public class AuctionPlatformServletTest extends HttpServlet {

	static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AuctionPlatformServletTest.class);

	public void listTest(List<Auction> auction) {

		for (Auction auc : auction) {
			System.out.println(auc.getId() + " , " + auc.getTitel() + "," + auc.getGebot());
		}
	}
}
