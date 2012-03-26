package com.wastl.EventListener;

// android
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
// com.wastl
import com.wastl.Activity.BrowseDistrictsActivity;
import com.wastl.Activity.MainActivity;
import com.wastl.Activity.MapActivity;
import com.wastl.Activity.MissionActivity;

/**
 * Contains and handles every event of the main activity.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.3, 08/03/2012
 * @since 1.2.2
 */
public class EventListener_MainActivity implements OnItemClickListener
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
		this.mMain.getGridViewNavigation().setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> _parent, View _view, int _position, long _id) 
	{
		Intent intent = null;
		
		switch(_position)
		{
		
		// Stats
		case 0:
			break;
			
		// Missions
		case 1:
			intent = new Intent(_view.getContext(), MissionActivity.class);
			break;
			
		// Map
		case 2:
			intent = new Intent(_view.getContext(), MapActivity.class);
			break;
			
		// Database
		case 3:
			intent = new Intent(_view.getContext(), BrowseDistrictsActivity.class);	
			break;
			
			
		// Search
		case 4:
			this.mMain.onSearchRequested();
			break;
			
		// WASTL homepage
		case 5:
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.feuerwehr-krems.at/Warnung/Teaser.asp"));
			this.mMain.startActivity(browserIntent);
			break;
			
			
		default:
			return;
		}
		
		if(null != intent)
			this.mMain.startActivity(intent);
	}
}
