/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.codegen;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.AuctionPlatform.controller.CreateAuctionServlet;

/**
 * 
 * @author Matthias Browarski
 *
 */
public class Codevalidator {

	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);

	// Überprüfung des Übergeben Codes (mit Email oder zugeordnet)
	/**
	 * @param sec
	 *            Code
	 * @param code
	 * @return richtiger code = true
	 */
	public Boolean validate(String sec, int code) {

		// TODO Code aus DB auslesen mihilfe der übergebenen email
		String db = null;

		if (code == Integer.parseInt(sec)) {

			logger.log(Level.INFO, "code validated");

			return true;
		} else {
			logger.log(Level.WARN, "Wrong Code");
			return false;
		}
	}

}
