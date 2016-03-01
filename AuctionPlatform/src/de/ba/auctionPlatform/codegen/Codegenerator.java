/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.codegen;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Matthias Browarski
 *
 */
public class Codegenerator {
	private int sec;
	private static final Logger logger = Logger.getLogger(Codegenerator.class);

	/**
	 * Methode zum generieren eines 8-stelligen Sicherheitscodes
	 * 
	 * @return int Sicherheitscode
	 */
	public int securityCode() {

		SecureRandom number;
		try {
			number = SecureRandom.getInstance("SHA1PRNG");

			sec = number.nextInt(89999999 + 10000000);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		return sec;
	}

	/**
	 * Methode zum validieren des Sicherheitscodes
	 * 
	 * @param sec
	 *            Code aus DB
	 * @param code
	 *            Code aus der View
	 * @return richtiger code = true
	 */
	public Boolean validate(String sec, int code) {

		if (code == Integer.parseInt(sec)) {

			logger.log(Level.INFO, "code validated");

			return true;
		} else {
			logger.log(Level.WARN, "Wrong Code");
			return false;
		}
	}

	/**
	 * Methode zum validieren des Sicherheitscodes
	 * 
	 * @param sec
	 *            Code aus DB
	 * @param code
	 *            Code aus der View
	 * @return richtiger code = true
	 */
	public Boolean validate(int sec, int code) {
		if (code == sec) {

			logger.log(Level.INFO, "code validated");

			return true;
		} else {
			logger.log(Level.WARN, "Wrong Code");
			return false;
		}
	}

}
