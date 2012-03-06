/*
 * Filename: MissionActivity.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: Activity class of the mission screen
 */
package com.wastl.Activity;

// com.wastl
import com.ithtl.essapp.R;
import com.wastl.Entity.DistrictMap;
import com.wastl.EventListener.EventListener;
// Android
import android.app.ListActivity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class MissionActivity extends ListActivity {

	private EventListener eventListener;	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // initialize objects
        this.initializeObjects();                                     
        
        //fill the string[] with districts
        DistrictMap.fillDistrictsForList();
                 
        //set Data
        this.setListAdapter(new ArrayAdapter<String>(this,R.layout.list_item, DistrictMap.getDistrictsForList()));
        
        //retrieve listView
        ListView districtListView = this.getListView();
        
        districtListView.setTextFilterEnabled(true);
                        
        this.setListViewStyle(districtListView);
        
        //set eventListener
        districtListView.setOnItemClickListener(this.eventListener);
    }

	private void initializeObjects()
	{
		this.eventListener 	= new EventListener(this);  	
	}
	
	private void setListViewStyle(ListView _listView)
	{
		_listView.setBackgroundColor(Color.GRAY);
		_listView.setPadding(10, 10, 10, 10);
		_listView.setDivider(new ColorDrawable(Color.GRAY));
		_listView.setDividerHeight(15);
		_listView.setCacheColorHint(0);
	}
}
