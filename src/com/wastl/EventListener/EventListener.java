/*
 * Filename: EventListener.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: EventListener class, provides the events used by the app
 */
package com.wastl.EventListener;

// com.wastl
import com.wastl.Activity.BrowseDistrictsActivity;
import com.wastl.Activity.BrowseFireDepartmentsActivity;
import com.wastl.Activity.MainActivity;
import com.wastl.Activity.FireDepartmentInfoActivity;
import com.wastl.Activity.FireDepartmentsActivity;
import com.wastl.Activity.MapActivity;
import com.wastl.Activity.MissionActivity;

// Android
import android.app.AlertDialog;
import android.content.Intent;
import android.view.*;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class EventListener implements OnClickListener, OnItemClickListener, OnMenuItemClickListener{

	private MainActivity essApp;
	private MissionActivity mission;
	private BrowseDistrictsActivity browse;
	private BrowseFireDepartmentsActivity browseFireDepartments;
	
	// Constructor
	public EventListener(MainActivity _essApp)
	{
		// get instance
		this.essApp = _essApp;
	}
	// Constructor
	public EventListener(MissionActivity _mission)
	{
		// get instance
		this.mission = _mission;
	}
	// Constructor
	public EventListener(BrowseFireDepartmentsActivity _browseFire)
	{
		this.browseFireDepartments = _browseFire;
	}
	// Constructor
	public EventListener(MapActivity _map)
	{
		
	}
	// Constructor
	public EventListener(BrowseDistrictsActivity _browse)
	{
		this.browse = _browse;
	}
	
	// OnClick Event for Buttons
	public void onClick(View _v) {		
		
		// Button MissionMap
		if(_v == this.essApp.getButtonMap())
		{
			if(MainActivity.getConnection())
			{
				Intent intentMap = new Intent(_v.getContext(), MapActivity.class);
	            this.essApp.startActivity(intentMap);
			}
			else 
				new AlertDialog.Builder(this.essApp).setTitle("WASTL").setMessage("Keine Internet Verbindung verfügbar!").setNeutralButton("Ok", null).show();
		}
		// Button actual missions
		if(_v == this.essApp.getButtonMission())
		{			
			if(MainActivity.getConnection())
			{
				Intent intentMission = new Intent(_v.getContext(), MissionActivity.class);
            	this.essApp.startActivity(intentMission);
			}
			else
				new AlertDialog.Builder(this.essApp).setTitle("WASTL").setMessage("Keine Internet Verbindung verfügbar!").setNeutralButton("Ok", null).show();			
		}
		// Button browse fire departments
		if(_v == this.essApp.getButtonBrowse())
		{
			Intent intentBrowse = new Intent(_v.getContext(), BrowseDistrictsActivity.class);
			this.essApp.startActivity(intentBrowse);
		}
	}

	public void onDestroy(){
		System.exit(0);
		
	}
	
	public void onItemClick(AdapterView<?> _parent, View _view, int _position, long _id) {				
		
		if(this.mission != null){
			//get the selectedItem from the view
			String selectedItem = ((TextView)_view).getText().toString();
			
			//There is no fire department in the LWZ, it's not even a district
			if(selectedItem.equals("LWZ"))
				return;			
			
			//Create new Intent
			Intent intentFireDepartments = new Intent(_view.getContext(),FireDepartmentsActivity.class);
			
			//Send the selectedItem to the intent
			intentFireDepartments.putExtra("selectedItemText", selectedItem);
			
			//Start the activity
			this.mission.startActivity(intentFireDepartments);
		}
		else if(this.browse != null)
		{			
			//get the selectedItem from the view
			String selectedItem = ((TextView)_view).getText().toString();
			
			//There is no fire department in the LWZ, it's not even a district
			if(selectedItem.equals("LWZ"))
				return;
			
			//Create new Intent
			Intent intentFireDepartments = new Intent(_view.getContext(),BrowseFireDepartmentsActivity.class);
			
			//Send the selectedItem to the intent
			intentFireDepartments.putExtra("selectedItemText", selectedItem);
			
			//Start the activity
			this.browse.startActivity(intentFireDepartments);
		}
		else if(this.browseFireDepartments != null)
		{
			String selectedItem = ((TextView)_view).getText().toString();
			
			//There is no fire department in the LWZ, it's not even a district
			if(selectedItem.equals("LWZ"))
				return;
			
			//Create new Intent
			Intent intentFireDepartments = new Intent(_view.getContext(),FireDepartmentInfoActivity.class);
			
			//Send the selectedItem to the intent
			intentFireDepartments.putExtra("selectedItemText", selectedItem);
			
			//Start the activity
			this.browseFireDepartments.startActivity(intentFireDepartments);
			
		}
	}

	public boolean onMenuItemClick(MenuItem _item) {
		// Update DB menu item click
		if(_item == browse.getMI_Refresh()){
				
		}
		return false;
	}
	
}
