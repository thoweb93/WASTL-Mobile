/*
 * Filename: BrowseDistrictsActivity.java
 * Author: Lukas Bernreiter, Patrik Kimmeswenger
 * Last change: 06.12.2011
 * Description: 
 */

package com.wastl.Activity;

// com.ithtl
// com.wastl
import com.ithtl.essapp.R;
import com.wastl.Database.DatabaseFacade;
import com.wastl.Database.Districts;
import com.wastl.EventListener.EventListener_BrowseDistrictsActivity;

// Android
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 10/03/2012
 * @since 1.2.1
 */
public class BrowseDistrictsActivity extends Activity implements Runnable {
		
	private EventListener_BrowseDistrictsActivity mEventListener_BrowseDistricts = null;
	private ProgressDialog mProgressDialog = null;
	private ListView mListView = null;
	private Cursor mCursor = null;
	private Context mContext = null;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.list_view);
        
        // initialize all objects
        this.initializeObjects();
      
        // load the data for the listView
        Thread thread = new Thread(this);
		thread.start();                   
	}	
	
	private void initializeObjects()
	{
		// Register events
		this.mEventListener_BrowseDistricts = new EventListener_BrowseDistrictsActivity(this);
		this.mEventListener_BrowseDistricts.setEvents();

		this.mContext = this.getApplicationContext();
		
		this.mListView = (ListView)this.findViewById(R.id.listView_Content);
		
		this.mProgressDialog = ProgressDialog.show(this, "", this.getString(R.string.create_Database), true);
	}
	
	public void run()
	{
		// Fetch all districts
		Districts districts = new Districts(this);
		this.mCursor = districts.fetchAllDistricts();
        this.startManagingCursor(this.mCursor);
		
        // Update listView
        handler.sendEmptyMessage(0);
	}
		
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	mProgressDialog.dismiss();
                 
        	// A list of column names representing the data to bind to the UI
        	String[] from = new String[]{DatabaseFacade.GetColumnDistrictName() };
        	
        	// The views that should display column in the "from" parameter.
        	int[] to = new int[]{R.id.textView_list };

        	SimpleCursorAdapter dataSource = new SimpleCursorAdapter(mContext, R.layout.list_item, mCursor,from, to);
        	
        	mListView.setAdapter(dataSource);        	
        }
        
        
	};
		
}
