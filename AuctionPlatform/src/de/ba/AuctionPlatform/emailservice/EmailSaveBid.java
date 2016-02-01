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
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import de.ba.AuctionPlatform.controller.CreateAuctionServlet;

public class EmailSaveBid {
	/**
	 * @param recipient
	 *            empfaenger
	 * @param subject
	 *            Titel
	 * @param text
	 *            Text
	 * @throws AddressException
	 * @throws MessagingException
	 */

	private static final Logger logger = Logger.getLogger(CreateAuctionServlet.class);

	public void send(String recipient, String subject, String text) throws AddressException, MessagingException {

		MailAuthenticator auth = new MailAuthenticator("kauft-mein-erbe@gmx.de", "auctionplatform1");

		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmx.net");

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		Session session = Session.getDefaultInstance(properties, auth);

		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("kauft-mein-erbe@gmx.de"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kauft-mein-erbe@gmx.de", false));
			msg.setSubject(subject);
			msg.setText(text);
			msg.setHeader("Test", "Test");
			msg.setSentDate(new Date());
			Transport.send(msg);
			logger.log(Level.INFO, "Email wurde an " + recipient + " versandt.");

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.ERROR, "Email konnte nicht an "+recipient+" versandt werden.");
		}
	}

}
