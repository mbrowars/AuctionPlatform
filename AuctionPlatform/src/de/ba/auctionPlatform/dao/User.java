/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.dao;

public class User {
	private int userid;
	private String email;
	private int code;

	/**
	 * @param code
	 * @param ip
	 */
	public User(String email, int code) {

		this.email = email;
		this.code = code;
	}

	public User() {

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

}
