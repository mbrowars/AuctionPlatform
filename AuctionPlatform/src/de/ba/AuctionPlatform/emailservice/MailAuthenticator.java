package de.ba.AuctionPlatform.emailservice;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.ba.AuctionPlatform.controller.CreateAuctionServlet;

/**
 * @author mbrowars
 *
 */
public class MailAuthenticator extends Authenticator {

	private final String user;
	private static final Logger logger = Logger.getLogger(MailAuthenticator.class);

	private final String password;

	/**
	 * @param user
	 *            mailuser
	 * @param password
	 *            mailpasswort
	 */
	public MailAuthenticator(String user, String password) {
		this.user = user;
		this.password = password;

	}

	protected PasswordAuthentication getPasswordAuthentication() {
		logger.log(Level.INFO, user + " wird an Emailserver angemeldet.");
		return new PasswordAuthentication(this.user, this.password);
	}

}
