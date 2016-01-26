/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dbmock;

import java.sql.Date;

/**
 * 
 * @author Matthias Browarski
 *
 */
public class AuctionMock {

	public Long getAuctionId() {
		return (long) 69;
	}

	public void setAuctionId(Long auctionid) {
	}

	public String getTitel() {
		return "Stein aus Woodstock";
	}

	public void setTitel(String titel) {
	}

	public Double getGebot() {
		return 2.5;
	}

	public void setGebot(Double gebot) {
	}

	public Date getEnddatum() {
		return (1997,02,12);
	}

	public void setEnddatum(Date enddatum) {
	}

	public String getBeschreibung() {
		return "n Stein aus Woodstock halt";
	}

	public void setBeschreibung(String beschreibung) {
	}

	public Long getHoechstbietenderid() {
		return (long) 23;
	}

	public void setHoechstbietenderid(Long hoechstbietenderid) {
	}
}
