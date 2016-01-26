/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dbInterface;

import java.sql.Date;

public interface IAuctionDao {
	
	public Long getAuctionId();

	public void setAuctionId(Long auctionid);

	public String getTitel();

	public void setTitel(String titel);

	public Double getGebot();

	public void setGebot(Double gebot);

	public Date getEnddatum();

	public void setEnddatum(Date enddatum);

	public String getBeschreibung();

	public void setBeschreibung(String beschreibung);

	public Long getHoechstbietenderid();

	public void setHoechstbietenderid(Long hoechstbietenderid);
}
