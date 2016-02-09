/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.codegen;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 
 * @author Matthias Browarski
 *
 */
public class Codegenerator {
	private int sec;

	private SecureRandom random = new SecureRandom();

	/**
	 * @return
	 */
	public int auctionSecurity() {

		SecureRandom number;
		try {
			number = SecureRandom.getInstance("SHA1PRNG");

			sec = number.nextInt(89999999 + 10000000);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO sec in DB speichern mit zugehöriger emailadresse
		return sec;
	}
}
