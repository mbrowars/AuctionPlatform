/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dbmock;


/**
 * 
 * @author Matthias Browarski
 *
 */
public class UserMock {

	public Long getUserId() {
		return (long) 23;
	}

	public void setUserId(Long userid) {
	}

	public String getEmail() {
		return "1337haxx0r@gmail.com";
	}

	public void setEmail(String email) {
	}

	public String getCode() {
		return "1024";
	}

	public void setCode(String code) {
	}

	public String getIp() {
		return "192.168.0.7";
	}

	public void setIp(String ip) {
	}
}
