/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
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
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	@Test
	public void sendTest() throws AddressException, MessagingException {
		EmailSaveBid.send("browarski@gmx.de", "name des Benutzers", "testnachricht");
	}
}