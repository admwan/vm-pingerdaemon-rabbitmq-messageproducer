package net.spikesync.pingerdaemonrabbitmqclient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class PingEntry implements Cloneable {

	private SilverCloudNode pingOrig;
	private SilverCloudNode pingDest;
	private Date lastPingDate;
	private int lastPingResult; // -1 means unkown, 0 means failed, 1 means succeeded
	private int pingHeat; // -1 means unknown. scale pingheated: 0 means long time ago, 10 means recently heated (ping successful)

	public static enum PINGRESULT { // Use this enum instead of integer codes.
		PINGSUCCESS,
		PINGFAILURE,
		PINGUNKOWN
	}
	
	public static enum PINGHEAT {
		GLACIAL,
		FRIGID,
		CRISPY, 
		TEPID,
		SNUG,
		TROPIC,
		SCORCHING
	}
	

	public int getPingHeat() {
		return pingHeat;
	}
	public void setPingHeat(int pingHeat) {
		this.pingHeat = pingHeat;
	}
	public SilverCloudNode getPingOrig() {
		return pingOrig;
	}
	public void setPingOrig(SilverCloudNode pingOrig) {
		this.pingOrig = pingOrig;
	}
	public SilverCloudNode getPingDest() {
		return pingDest;
	}
	public void setPingDest(SilverCloudNode pingDest) {
		this.pingDest = pingDest;
	}
	public Date getLastPingDate() {
		return lastPingDate;
	}
	public void setLastPingDate(Date lastPing) {
		this.lastPingDate = lastPing;
	}
	public int getLastPingResult() {
		return lastPingResult;
	}
	public void setLastPingResult(int lastPingResult) {
		this.lastPingResult = lastPingResult;
	}
	
	@Override
	public String toString() {
		
		DateFormat format = new SimpleDateFormat(
                "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		return format.format(this.lastPingDate) + ";" + this.pingOrig +  ";" + this.pingDest + ";" +  this.lastPingResult + ";" +  this.pingHeat;
	}	
}

// For DateFormat see:  https://stackoverflow.com/questions/5937017/how-to-convert-a-date-in-this-format-tue-jul-13-000000-cest-2010-to-a-java-d