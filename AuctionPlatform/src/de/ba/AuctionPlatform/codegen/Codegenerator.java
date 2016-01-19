/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
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
			// TODO sec in DB speichern mit zugehöriger emailadresse
			return sec;
		}
	}
}
