package com.wastl.Activity;

import com.ithtl.essapp.R;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

/**
 * Receives the query from the search dialog.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.3, 26/03/2012
 * @since 1.2.3
 */
public class SearchActivity extends Activity 
{

	private String mSearchString = ""; 
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.list_view);
        
        if(Intent.ACTION_SEARCH.equals(this.getIntent().getAction()))
        	this.initializeObjects();
    }
    
    private void initializeObjects()
    {
    	this.mSearchString = this.getIntent().getStringExtra(SearchManager.QUERY);
    }
}
