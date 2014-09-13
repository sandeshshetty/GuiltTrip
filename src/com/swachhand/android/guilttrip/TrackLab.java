package com.swachhand.android.guilttrip;

import java.util.ArrayList;

public class TrackLab {

	private static ArrayList<Track> mTracks;
	
	public static void addTrack(Track track) {
		mTracks.add(track);
	}
}