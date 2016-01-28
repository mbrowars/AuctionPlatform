/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dao;

public class User {
	Long userid;
	String email;
	String code;
	String ip;

	public User() {
		
	}
	
	public User(Long userid, String email, String code, String ip) {
		this.userid = userid;
		this.email = email;
		this.code = code;
		this.ip = ip;
	}
	
	public Long getId() {
		return userid;
	}

	public void setId(Long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
