/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fr�hlich, Max G�ppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.emailservice;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.junit.Test;

/**
 * 
 * @author Matthias Browarski
 *
 */
public class EmailSaveBidTest {

	
	/**
	 * Testklasse: Versenden der 
	 */
	@Test
	public void sendTest() {
		EmailSaveBid.send("matthibrow@googlemail.com", "name des Benutzers", null, null);
	}
}