/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.dbmock;

import java.sql.Blob;
import java.sql.Date;

/**
 * 
 * @author Max Göppert
 *
 */
public class AuctionMock {

	private Long auctionid;
	private String titel;
	private Double gebot;
	private Object date;
	private String beschreibung;
	private Long hoechstbietenderid;
	private Blob picture;

	public Long getAuctionId() {
		return (long) 69;
	}

	public void setAuctionId(Long auctionid) {
		this.auctionid = auctionid;
	}

	public String getTitel() {
		return "Stein aus Woodstock";
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Double getGebot() {
		return 2.5;
	}

	public void setGebot(Double gebot) {
		this.gebot = gebot;
	}

	public Date getEnddatum() {
		Date date = new Date(1997,02, 12);
		return date;
	}

	public void setEnddatum(Date enddatum) {
		this.date = date;
	}

	public String getBeschreibung() {
		return "n Stein aus Woodstock halt";
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Long getHoechstbietenderid() {
		return (long) 23;
	}

	public void setHoechstbietenderid(Long hoechstbietenderid) {
		this.hoechstbietenderid = hoechstbietenderid;
	}
	
	public Blob getPicture() {
		return null;
	}
	
	public void setPicture(Blob picture) {
		this.picture = picture;
	}

}
