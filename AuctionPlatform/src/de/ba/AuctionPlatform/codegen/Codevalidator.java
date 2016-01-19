/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.codegen;

/**
 * 
 * @author Matthias Browarski
 *
 */
public class Codevalidator {

	// Überprüfung des Übergeben Codes (mit Email oder zugeordnet)
	public Boolean validate(String sec, String email) {

		// TODO Code aus DB auslesen mihilfe der übergebenen email
		String db = null;

		if (db == sec) {
			// AuctionLogger.log.info( "Codevalidator "+email+" code validated"
			// );
			System.out.println("code validated");
			return true;
		} else {
			// AuctionLogger.log.warning( "Codevalidator "+email+" ERROR: WRONG
			// CODE" );
			System.out.println("Error: wrong code");
			// Systemausgabe in Datei loggen
			return false;
		}
	}

}
