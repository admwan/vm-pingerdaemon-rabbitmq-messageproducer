package net.spikesync.pingerdaemonrabbitmqclient;

import java.util.Date;

import net.spikesync.pingerdaemonrabbitmqclient.PingEntry.PINGHEAT;

public class PingHeatData {

	private PINGHEAT pingHeat;
	private Date lastPingSuccess;
	private Date lastPingFailure;

	public PingHeatData(PINGHEAT heat) {
		this.pingHeat = heat;
		this.lastPingSuccess = null;
		this.lastPingFailure = null;
	}

	public PingHeatData(PINGHEAT heat, Date lastSuccess, Date lastFailure) {
		this.pingHeat = heat;
		this.lastPingSuccess = lastSuccess;
		this.lastPingFailure = lastFailure;
	}

	public PINGHEAT getPingHeat() {
		return this.pingHeat;
	}

	public Date getLastPingSuccess() {
		return this.lastPingSuccess;
	}

	public Date getLastPingFailure() {
		return this.lastPingFailure;
	}

	public void setLastPingSuccess(Date timeLastPingSuccess) {
		this.lastPingSuccess = timeLastPingSuccess;
	}

	public void setLastPingFailure(Date timeLastPingFailure) {
		this.lastPingFailure = timeLastPingFailure;
	}

	public void setPingHeat(PINGHEAT heat) {
		this.pingHeat = heat;
	}

	@Override
	public boolean equals(Object other) {
		super.equals(other);

		if (this == other)
			return true;

		if (!(other instanceof PingHeatData))
			return false;

		if (((PingHeatData) other).getPingHeat().equals(this.getPingHeat())
				&& ((PingHeatData) other).getLastPingSuccess().equals(this.getLastPingSuccess())
				&& ((PingHeatData) other).getLastPingFailure().equals(this.getLastPingFailure()))
			return true;

		else
			return false;
	}
}
