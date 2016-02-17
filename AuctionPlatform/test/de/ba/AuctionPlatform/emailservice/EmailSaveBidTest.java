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

	private String testnachricht = "";
	private String email = "";
	private String anliegen = "2";
	SendMail sm = new SendMail();

	/**
	 * Testklasse: Versenden der
	 * 
	 * @throws MessagingException
	 * @throws AddressException
	 */
	@Test
	public void sendTest() throws AddressException, MessagingException {
		sm.send(email, anliegen, testnachricht);
	}
}