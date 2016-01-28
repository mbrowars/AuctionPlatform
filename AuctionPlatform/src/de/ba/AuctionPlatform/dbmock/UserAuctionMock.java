package de.ba.AuctionPlatform.dbmock;

public class UserAuctionMock {

	private long auctionuserid;
	private long userid;
	private long auctionid;

	public long getAuctionUserId() {
		return 420;
	}
	
	public void setAuctionUserId(long auctionuserid) {
		this.auctionuserid = auctionuserid;
	}
	
	public long getUserId() {
		return 23;
	}
	
	public void setUserId(long userid) {
		this.userid = userid;
	}
	
	public long getAuctionId() {
		return 69;
	}
	
	public void setAuctionId(long auctionid) {
		this.auctionid = auctionid;
	}
}
