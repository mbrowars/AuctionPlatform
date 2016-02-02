/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dao;

import java.sql.Blob;
import java.sql.Date;

public class Auction {
	Long auctionid;
	String titel;
	Double gebot;
	String enddatum;
	String beschreibung;
	Long hoechstbietenderid;
	Blob picture;

	public Auction() {

	}

	public Auction(Long auctionid, String titel, Double gebot, String enddatum, String beschreibung,
			Long hoechstbietenderid, Blob picture) {
		this.auctionid = auctionid;
		this.titel = titel;
		this.gebot = gebot;
		this.enddatum = enddatum;
		this.beschreibung = beschreibung;
		this.hoechstbietenderid = hoechstbietenderid;
		this.picture = picture;
	}

	public Long getId() {
		return auctionid;
	}

	public void setId(Long auctionid) {
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

	public String getEnddatum() {
		return enddatum;
	}

	public void setEnddatum(String enddatum) {
		this.enddatum = enddatum;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Long getHoechstbietenderid() {
		return hoechstbietenderid;
	}

	public void setHoechstbietenderid(Long hoechstbietenderid) {
		this.hoechstbietenderid = hoechstbietenderid;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

}
