package com.wastl.EventListener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.ithtl.essapp.R;
import com.wastl.Activity.BrowseDistrictsActivity;

/**
 * Contains and handles every event of the browseDistricts activity.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 12/03/2012
 * @since 1.2.2
 */
public class EventListener_BrowseDistrictsActivity implements OnItemClickListener
{
	private BrowseDistrictsActivity mBrowseDistricts;
	
	public EventListener_BrowseDistrictsActivity(BrowseDistrictsActivity _browseDistrictsActivity)
	{
		this.mBrowseDistricts = _browseDistrictsActivity;
	}
	
	public void setEvents()
	{
		((ListView)this.mBrowseDistricts.findViewById(R.id.listView_Content)).setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> _adapter, View _view, int _position, long _id) 
	{
		
	}
}
