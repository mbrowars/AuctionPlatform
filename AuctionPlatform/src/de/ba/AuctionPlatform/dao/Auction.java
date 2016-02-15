/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dao;

import java.sql.Blob;

public class Auction {
	private int auctionid;
	private String titel;
	private Double gebot;
	private Long laufzeit;
	private String beschreibung;
	private int hoechstbietenderid;
	private Blob picture;

	public Auction() {

	}

	public Auction(String titel, Double gebot, Long laufzeit, String beschreibung,
			int hoechstbietenderid, Blob picture) {
		
		this.titel = titel;
		this.gebot = gebot;
		this.laufzeit = laufzeit;
		this.beschreibung = beschreibung;
		this.hoechstbietenderid = hoechstbietenderid;
		this.picture = picture;
	}

	public int getId() {
		return auctionid;
	}

	public void setId(int auctionid) {
		this.auctionid = auctionid;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Double getGebot() {
		return gebot;
	}

	public void setGebot(Double gebot) {
		this.gebot = gebot;
	}

	public Long getLaufzeit() {
		return laufzeit;
	}

	public void setLaufzeit(Long laufzeit) {
		this.laufzeit = laufzeit;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public int getHoechstbietenderid() {
		return hoechstbietenderid;
	}

	public void setHoechstbietenderid(int hoechstbietenderid) {
		this.hoechstbietenderid = hoechstbietenderid;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

}
