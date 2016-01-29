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

/**
 * 
 * @author Matthias Browarski
 *
 */
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSaveBid {
	public void send(String recipient, String subject, String text) throws AddressException, MessagingException {

		MailAuthenticator auth = new MailAuthenticator("kauft-mein-erbe@gmx.de", "auctionplatform1");

		Properties properties = new Properties();

		// Den Properties wird die ServerAdresse hinzugefügt
		properties.put("mail.smtp.host", "smtp.gmx.net");

		// !!Wichtig!! Falls der SMTP-Server eine Authentifizierung
		// verlangt
		// muss an dieser Stelle die Property auf "true" gesetzt
		// werden
		properties.put("mail.smtp.auth", "true");
		 properties.put("mail.smtp.port", "587");
		 properties.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

		// Hier wird mit den Properties und dem implements Contructor
		// erzeugten
		// MailAuthenticator eine Session erzeugt
		Session session = Session.getDefaultInstance(properties, auth);

		try {
			// Eine neue Message erzeugen
			Message msg = new MimeMessage(session);

			// Hier werden die Absender- und Empfängeradressen gesetzt
			msg.setFrom(new InternetAddress("kauft-mein-erbe@gmx.de"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kauft-mein-erbe@gmx.de", false));

			// Der Betreff und Body der Message werden gesetzt
			msg.setSubject(subject);
			msg.setText(text);

			// Hier lassen sich HEADER-Informationen hinzufügen
			msg.setHeader("Test", "Test");
			msg.setSentDate(new Date());

			// Zum Schluss wird die Mail natürlich noch verschickt
			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
