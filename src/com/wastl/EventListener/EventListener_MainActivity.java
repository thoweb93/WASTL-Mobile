package com.wastl.EventListener;

// android
import android.content.Intent;
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
 * @version 1.2.2, 08/03/2012
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
		case 0:
			break;
		case 1:
			intent = new Intent(_view.getContext(), MissionActivity.class);
			break;
		case 2:
			intent = new Intent(_view.getContext(), MapActivity.class);
			break;
		case 3:
			intent = new Intent(_view.getContext(), BrowseDistrictsActivity.class);	
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			return;
		}
		
		this.mMain.startActivity(intent);
	}
}
