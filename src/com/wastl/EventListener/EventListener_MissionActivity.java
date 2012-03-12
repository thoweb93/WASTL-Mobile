package com.wastl.EventListener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.ithtl.essapp.R;
import com.wastl.Activity.MissionActivity;

/**
 * Contains and handles every event of the mission activity.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 12/03/2012
 * @since 1.2.2
 */
public class EventListener_MissionActivity implements OnItemClickListener
{
	private MissionActivity mMission = null;
	
	public EventListener_MissionActivity(MissionActivity _mission)
	{
		this.mMission = _mission;				
	}
	
	public void setEvents()
	{
		((ListView)this.mMission.findViewById(R.id.listView_Content)).setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> _adapter, View _view, int _position, long _id) 
	{
		
	}

}
