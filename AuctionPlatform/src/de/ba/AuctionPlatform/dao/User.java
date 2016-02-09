/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dao;

public class User {
	private int userid;
	private String email;
	private int code;
	private String ip;

	/**
	 * @param ip2
	 * @param code2
	 * @param email2
	 * @param userid2
	 * 
	 */

	/**
	 * @param code
	 * @param ip
	 */
	public User(int userid, String email, int code, String ip) {
		this.userid = userid;
		this.email = email;
		this.code = code;
		this.ip = ip;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return userid;
	}

	public void setId(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
