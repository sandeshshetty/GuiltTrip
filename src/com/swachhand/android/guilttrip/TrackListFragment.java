package com.swachhand.android.guilttrip;

import java.util.ArrayList;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TrackListFragment extends ListFragment {
	private ArrayList<Track> mTracks;
	
	private class TrackAdapter extends ArrayAdapter<Track> {
		
		public TrackAdapter(ArrayList<Track> tracks) {
			super(getActivity(), 0, tracks);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_list_track, null);
			}
			
			//Track track = getItem(position);
			TextView mMode = (TextView) convertView.findViewById(R.id.mode_label);
			mMode.setText("Hello");
			//mMode.setText(track.getMode().toString());
			
			TextView mFrom = (TextView) convertView.findViewById(R.id.time_start_stop_label);
			mFrom.setText("From");
			
			/*TextView mStop = (TextView) convertView.findViewById(R.id.stop_label);
			mStop.setText("Stop");*/
			return convertView;
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTracks = new ArrayList<Track>();
		for(int i = 0; i < 5; i++) {
			Track track = new Track();
			track.setStartTime(new Date());
			track.setStopTime(new Date());
			mTracks.add(track);
		}
		//mTracks = TrackLab.get(getActivity()).getCrimes();
		TrackAdapter adapter = new TrackAdapter(mTracks);
		setListAdapter(adapter);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		((TrackAdapter) getListAdapter()).notifyDataSetChanged();
	}

}
