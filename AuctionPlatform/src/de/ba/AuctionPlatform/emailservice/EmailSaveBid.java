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

/**
 * 
 * @author Matthias Browarski
 *
 */
public class EmailSaveBid {

	/**
	 * @param email
	 *            Empf�nger der Sicherheitsemail
	 * @param user
	 *            Angegebene Emailadresse
	 * @param item
	 *            Auktionsgegenstand auf den geboten wurde
	 */
	public static void send(String email, String user, String item, String code) {

		// Recipient's email ID needs to be mentioned.
		String to = email;

		// Sender's email ID needs to be mentioned
		String from = "blazeIt@420.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Sicherheitsmail f�r ihr Gebot f�r das Produkt :" + item);

			// Send the actual HTML message, as big as you like
			message.setContent(
					"<h1>Sehr geehrter BlazeIt-Nutzer, das von Ihnen abgeschickte Gebot wurde akzeptiert.<br>"
							+ "Um Ihr Gebot zu speichern nutzen Sie den folgenden Code :" + code + "<br>"
							+ "Falls Sie �berboten werden Sie automatisch von uns per Email informiert.<br><br><br>"
							+ "Ihr BlazeIt Team" + "</h1>",
					"text/html");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
