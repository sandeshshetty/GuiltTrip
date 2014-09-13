package com.swachhand.android.guilttrip;

import java.util.Date;
import java.util.UUID;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

public class TrackFragment extends Fragment {
	
	private Chronometer mWatch;
	private Button mStart_button;
	private Button mStop_button;
	private long elapsedMillis;
	private double elapsedSecs;
	private Track mTrack;
	
	private static final String TAG = "TrackFragment";
	public static final String EXTRA_TRACK_ID = "com.swachhand.android.guilttrip.track_id";
	
	public static TrackFragment newInstance(UUID crimeId) {
		Bundle bundle = new Bundle();
		bundle.putSerializable(EXTRA_TRACK_ID, crimeId);
		TrackFragment fragment = new TrackFragment();
		fragment.setArguments(bundle);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_TRACK_ID);
		elapsedMillis = 0;
		elapsedSecs = 0;
		mTrack = new Track();
		
		// TODO: Need to retrieve extra from savedInstanceState
		
	}
	
	

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putSerializable(EXTRA_TRACK_ID, mTrack.getId());
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment_track, container, false);
		
		mWatch = (Chronometer) v.findViewById(R.id.chronometer);
		
		mStart_button = (Button) v.findViewById(R.id.start_button);
		mStart_button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				start_stop_watch(v);
			}
			
		});
		
		mStop_button = (Button) v.findViewById(R.id.stop_button);
		mStop_button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				start_stop_watch(v);
			}
			
		});
		
		return v;
		
	}
	
	private void start_stop_watch(View v) {
		switch(v.getId()) {
		case R.id.start_button:
			mWatch.setBase(SystemClock.elapsedRealtime());
			mTrack.setStartTime(new Date());
			mWatch.start();
			break;
		case R.id.stop_button:
			elapsedMillis = SystemClock.elapsedRealtime() - mWatch.getBase();
			elapsedSecs = elapsedMillis / 1000.0;
			Log.d(TAG, "" + elapsedMillis);
			Log.d(TAG, "" + elapsedSecs);
			mTrack.setStopTime(new Date());
			mTrack.setElapsedTime(elapsedSecs);
			mWatch.stop();
			break;			
		}
	}
}
