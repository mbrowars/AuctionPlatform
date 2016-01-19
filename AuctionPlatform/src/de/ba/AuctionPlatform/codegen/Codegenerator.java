/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.codegen;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * 
 * @author Matthias Browarski
 *
 */
public class Codegenerator {

	public final class SessionIdentifierGenerator {
		private SecureRandom random = new SecureRandom();

		public String nextSessionId() {
			String sec = new BigInteger(130, random).toString();
			// TODO sec in DB speichern mit zugehÃ¶riger emailadresse
			return sec;
		}
	}
}
