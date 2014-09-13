package com.swachhand.android.guilttrip;

import java.util.Date;
import java.util.UUID;

public class Track {

	private Date mStartTime;
	private UUID mId;
	private Date mStopTime;
	private double mElapsedTime;
	//private String mTitle;
	//private ArrayList<Gps> mGpsArray;
	//private TransportMode mModeOfTransport;
	//private double mDistanceTravelled;

	public Track() {
		mId = UUID.randomUUID();
	}

	public UUID getId() {
		return mId;
	}

	public void setElapsedTime(double elapsedTime) {
		mElapsedTime = elapsedTime;
	}

	public void setStartTime(Date startTime) {
		mStartTime = startTime;
	}

	public Date getStartTime() {
		return mStartTime;
	}

	public Date getStopTime() {
		return mStopTime;
	}

	public void setStopTime(Date stopTime) {
		mStopTime = stopTime;
		mElapsedTime = (mStartTime.getTime() - mStopTime.getTime()) / 1000;
	}

	/*
	 * public TransportMode getModeOfTransport() { return mModeOfTransport; }
	 * 
	 * public void setModeOfTransport(TransportMode modeOfTransport) {
	 * mModeOfTransport = modeOfTransport; }
	 */

	public double getElapsedTime() {
		return mElapsedTime;
	}

	/*
	 * public ArrayList<Gps> getGpsArray() { return mGpsArray; }
	 */

}
