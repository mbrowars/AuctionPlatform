package de.ba.AuctionPlatform.dbInterface;

public interface IUserAuctionDao {
	
	public long getAuctionUserId();
	
	public void setAuctionUserId(long auctionuserid);
	
	public long getUserId();
	
	public void setUserId(long userid);
	
	public long getAuctionId();
	
	public void setAuctionId(long auctionid);
}
