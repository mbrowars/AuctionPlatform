package de.ba.AuctionPlatform.emailservice;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author mbrowars
 *
 */
public class MailAuthenticator 	extends Authenticator {
		 
        
        private final String user;
 
        
        private final String password;
 
       
        /**
         * @param user mailuser
         * @param password mailpasswort
         */
        public MailAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }
 
        
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.user, this.password);
        }
    
    
}
