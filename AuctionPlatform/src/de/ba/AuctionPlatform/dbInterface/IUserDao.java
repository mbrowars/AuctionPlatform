/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dbInterface;


/**
 * 
 * @author Max Göppert
 *
 */

public interface IUserDao {
	
	public Long getUserId();

	public void setUserId(Long userid);

	public String getEmail();

	public void setEmail(String email);

	public String getCode();

	public void setCode(String code);

	public String getIp();

	public void setIp(String ip);
}
