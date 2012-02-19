/*
 * Filename: BrowseFireDepartmentsActivity.java
 * Author: Lukas Bernreiter
 * Last change: 06.12.2011
 * Description: 
 */

package com.wastl.Activity;

// com.ithtl.essap
import com.wastl.R;
import com.wastl.Database.DBAdapter;
import com.wastl.EventListener.EventListener;

// Android
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class BrowseFireDepartmentsActivity extends ListActivity implements Runnable {

	private String selectedItemText;
	private EventListener eventListener;
	private ProgressDialog progressDialog;
	private Context context;
	private String[] fireDepartments;
	private DBAdapter dba;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      
        
        // initialize all objects
        this.initializeObjects();
        
        // load the data for the listView
        this.loadData();
        
	}
	
	// initializes every object
	private void initializeObjects()
	{
		// initialize objects 
        this.eventListener = new EventListener(this);
        this.context = this.getApplicationContext();
        this.dba = new DBAdapter(this.getApplicationContext());
        
        //get the selectedItemText from the intent
        this.selectedItemText = this.getIntent().getExtras().getString("selectedItemText");
	}
	
	// shows the progress dialog and starts a thread to load the data
	private void loadData()
	{
		this.progressDialog = ProgressDialog.show(this, "", "Daten werden gelesen", true);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	// Thread
	// loads the data
	public void run()
	{		
		Integer id = dba.getDistrictIDbyName(this.selectedItemText);			
		
		this.fireDepartments = dba.readFireDepartmentsbyID(id);
		
        this.handler.sendEmptyMessage(0);
	}
	
	// Needed to update the UI objects, 
	// because the most UI objects cannot be updated from a dispatcher
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	progressDialog.dismiss();
            
        	//set data
            setListAdapter(new ArrayAdapter<String>(context,R.layout.list_item, fireDepartments));
            
            ListView browseFireDepartments = getListView();
            
            browseFireDepartments.setTextFilterEnabled(true);
            
            // listView styles
           this.setListViewStyle(browseFireDepartments);
            
            browseFireDepartments.setOnItemClickListener(eventListener);
        }
        
        private void setListViewStyle(ListView _listView)
    	{
    		_listView.setBackgroundColor(Color.GRAY);
    		_listView.setPadding(10, 10, 10, 10);
    		_listView.setDivider(new ColorDrawable(Color.GRAY));
    		_listView.setDividerHeight(15);
    		_listView.setCacheColorHint(0);
    	}
        
        
	};
}
