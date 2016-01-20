/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.AuctionPlatform.dao;

import java.sql.Date;

public class AuctionDao {
	Long id;
	String titel;
	Double gebot;
	Date enddatum;
	String beschreibung;
	Long hoechstbietenderid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getEnddatum() {
		return enddatum;
	}

	public void setEnddatum(Date enddatum) {
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
}
