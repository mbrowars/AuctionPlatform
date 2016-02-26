package de.ba.AuctionPlatform.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Level;

import de.ba.AuctionPlatform.dao.Auction;

/**
 * @author mbrowars
 *
 */
public class AuctionHelper {
	private static final String SAVE_DIR = "js/data.json";

	public String json(List<Auction> auction) {
		String json = "[";

		// Json String zur �bergabe an angular-js
		for (Auction auc : auction) {
			json += "{";
			json += "\"Id\": " + auc.getAuctionid() + ", " + "\"name\": \"" + auc.getTitel() + "\", " + "\"price\": "
					+ auc.getGebot() + ", " + "\"Laufzeit\": " + auc.getLaufzeit() + ", " + "\"Beschreibung\": \""
					+ auc.getBeschreibung() + "\", " + "\"HoechstbietenderId\": " + auc.getHoechstbietenderid() + ", "
					+ "\"Picture\": \"" + auc.getPicture() + "\"}";
			if (auction.listIterator().hasNext())
				json += ",";
		}
		json = json.substring(0, json.length() - 1);
		return json += "]";

	}

	public synchronized void saveJson(String json, String appPath) throws IOException {

		FileOutputStream writer = new FileOutputStream(appPath + File.separator + SAVE_DIR);
		for (int i = 0; i < json.length(); i++) {
			writer.write((byte) json.charAt(i));
		}

	}
}
