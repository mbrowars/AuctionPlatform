/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.dbmock;
/**
 * 
 * @author Matthias Browarski
 *
 */
public class UserMock {

	private Long userid;
	private String email;
	private String code;
	private String ip;
	
		 

	public Long getUserId() {
		return (long) 23;
	}

	public void setUserId(Long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return "1337haxx0r@gmail.com";
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCode() {
		return new Long(1024);
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIp() {
		return "192.168.0.7";
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
