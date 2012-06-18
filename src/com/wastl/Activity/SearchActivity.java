package com.wastl.Activity;

import com.ithtl.essapp.R;
import com.wastl.Database.DatabaseFacade;
import com.wastl.Database.FireDepartments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Receives the query from the search dialog.
 * Initiates the search process.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.4, 18/06/2012
 * @since 1.2.3
 */
public class SearchActivity extends Activity implements Runnable
{
	private String mSearchString = new String(); 
	private Context mContext = null;
	private ProgressDialog mProgressDialog = null;	
	private ListView mListView = null;
	private Cursor mCursor = null;
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.list_view);
        
        if(Intent.ACTION_SEARCH.equals(this.getIntent().getAction()))
        {
        	this.initializeObjects();
        	
        	// load the data for the listView
            Thread thread = new Thread(this);
    		thread.start();
        }
    }
    
    private void initializeObjects()
    {
    	this.mSearchString = this.getIntent().getStringExtra(SearchManager.QUERY);
    	this.mContext = this.getApplicationContext();
    	this.mListView = (ListView)this.findViewById(R.id.listView_Content);
    	this.mProgressDialog = ProgressDialog.show(this, "", this.getString(R.string.create_Database), true);
    }

	public void run() 
	{
		// Fetch data
		FireDepartments fireDepartments = new FireDepartments(this.getApplicationContext());
		mCursor = fireDepartments.fetchSimilarFireDepartments(mSearchString);
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
