package com.wastl.EventListener;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.ithtl.essapp.R;
import com.wastl.AppFacade;
import com.wastl.Activity.MissionActivity;
import com.wastl.Activity.MissionDetailsActivity;

/**
 * Contains and handles every event of the mission activity.
 * 
 * @author Lukas Bernreiter
 * @version 1.3, 19/06/2012
 * @since 1.2.3
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
		Object obj = _adapter.getItemAtPosition(_position);		
		
		Intent intent = new Intent(this.mMission, MissionDetailsActivity.class);
		intent.putExtra(AppFacade.GetExDetails(), obj.toString());
		this.mMission.startActivity(intent);		
	}

}
