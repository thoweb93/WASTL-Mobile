/*
 * Filename: BrowseDistrictsActivity.java
 * Author: Lukas Bernreiter, Patrik Kimmeswenger
 * Last change: 06.12.2011
 * Description: 
 */

package com.wastl.Activity;

// com.ithtl.essap
import com.wastl.R;
import com.wastl.Database.DBAdapter;
import com.wastl.EventListener.EventListener;
import com.wastl.R.id;

// Android
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class BrowseDistrictsActivity extends ListActivity implements Runnable {
		
	private MenuItem MenuItemRefresh;
	private EventListener eventListener;
	private ListView districtListView;
	private Context context;
	private ProgressDialog progressDialog;
	private DBAdapter dba;
	
	private String[] districts;
		
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize all objects
        this.initializeObjects();
      
        // load the data for the listView
        this.loadData();                      
	}	
	
	// initialize objects
	private void initializeObjects()
	{
        this.eventListener 	= new EventListener(this);           
        this.context = this.getApplicationContext();	
        
	}
	
	// shows the progress dialog and starts a thread to load the data
	private void loadData()
	{
		this.progressDialog = ProgressDialog.show(this, "", "Datenbank wird erstellt", true);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	// Thread
	// loads the data
	public void run()
	{	
		this.dba = new DBAdapter(this.getApplicationContext());
        this.districts = dba.readAllDistricts();        
        
        // used to update the listView
        handler.sendEmptyMessage(0);
	}
	
	// Needed to update the UI objects, 
	// because the most UI objects cannot be updated from a dispatcher
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	progressDialog.dismiss();
            
        	// set Data           
        	setListAdapter(new ArrayAdapter<String>(context,R.layout.list_item, districts));
            // retrieve listView
            districtListView = getListView();
            
            districtListView.setTextFilterEnabled(true);
            
            // set listView style
            this.setListViewStyle(districtListView);
            
            // set eventListener
            districtListView.setOnItemClickListener(eventListener); 
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu _menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.browse_districts_menu, _menu);
		
        this.MenuItemRefresh = (MenuItem) _menu.findItem(id.MI_Refresh);
        this.MenuItemRefresh.setOnMenuItemClickListener(this.eventListener);
		return true;
	}
	
	// Get the menu button	
	public MenuItem getMI_Refresh()	{return this.MenuItemRefresh; }
}
