package com.wastl.EventListener;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.ithtl.essapp.R;
import com.wastl.Activity.BrowseDistrictsActivity;
import com.wastl.Activity.MainActivity;
import com.wastl.Activity.MapActivity;
import com.wastl.Activity.MissionActivity;

/**
 * Contains and handles every event of the main activity.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 08/03/2012
 * @since 1.2.2
 */
public class EventListener_MainActivity implements OnClickListener
{
	private MainActivity mMain = null;

	/**
	 * Constructor, saves the instance of the main activity.
	 * @param _main the instance.
	 */
	public EventListener_MainActivity(MainActivity _main)
	{
		this.mMain = _main;		
	}
	
	/**
	 * Declares the events for the main activity.
	 */
	public void setEvents()
	{
		/*this.mMain.getButtonBrowse().setOnClickListener(this);
		this.mMain.getButtonMap().setOnClickListener(this);
		this.mMain.getButtonMission().setOnClickListener(this);*/
	}

	/** Called when a registered view gets clicked */
	public void onClick(View _v) 
	{
		Intent intent = null;
		/*
		switch (_v.getId()) 
		{
			case R.id.button_Browse:
				intent = new Intent(_v.getContext(), BrowseDistrictsActivity.class);				
				break;
				
			case R.id.button_Map:
				intent = new Intent(_v.getContext(), MapActivity.class);
				break;
				
			case R.id.button_Mission:
				intent = new Intent(_v.getContext(), MissionActivity.class);
				break;
				
			default:
				return;
		}*/
		
		this.mMain.startActivity(intent);
	}
}
