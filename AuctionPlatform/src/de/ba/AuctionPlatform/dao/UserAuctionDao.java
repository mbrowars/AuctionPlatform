package de.ba.AuctionPlatform.dao;

public class UserAuctionDao {
	Long auctionuserid;
	Long userid;
	Long auctionid;
	
	public UserAuctionDao() {
		
	}
	
	public UserAuctionDao(Long auctionuserid, Long userid, Long auctionid) {
		this.auctionuserid = auctionuserid;
		this.userid = userid;
		this.auctionid = auctionid;
	}
	public long getAuctionUserId() {
		return auctionuserid;
	}
	
	public void setAuctionUserId(long auctionuserid) {
		this.auctionuserid = auctionuserid;
	}
	
	public long getUserId() {
		return userid;
	}
	
	public void setUserId(long userid) {
		this.userid = userid;
	}
	
	public long getAuctionId() {
		return auctionid;
	}
	
	public void setAuctionId(long auctionid) {
		this.auctionid = auctionid;
	}
}
