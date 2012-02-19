/*
 * Filename: ESSAppActivity.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: Activity class of the main window
 */
package com.wastl.Activity;

// com.ithtl.essap
import com.wastl.R;
import com.wastl.XML;
import com.wastl.EventListener.EventListener;

// Android
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class MainActivity extends Activity {
	
	//Objects
	//Navigation Buttons
	private Button buttonMap;
	private Button buttonMission;
	private Button buttonBrowse;
	//EventListener
	private EventListener eventListener;
	//XML-Data
	private XML xml;
	//Connection available
	private static Boolean connection = true;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set content
        setContentView(R.layout.main);
        
        //check if a network connection is available
        if(!this.getNetworkState()){
        	Log.d("WASTL", "No Connection");
        	connection = false;        	
        }
        
        // initialize objects
        this.eventListener 	= new EventListener(this);
        // get Buttons
        this.buttonMap 		= (Button)this.findViewById(R.id.buttonMap);
        this.buttonMission 	= (Button)this.findViewById(R.id.buttonMission);
    	this.buttonBrowse 	= (Button)this.findViewById(R.id.buttonBrowse);

    	//get XML and set the data 
        this.xml = new XML(this);
        this.xml.setStartup();
                
        
        if(!connection)        
        	new AlertDialog.Builder(this).setTitle("WASTL").setMessage("Keine Internet Verbindung verfügbar! Daten sind nicht aktuell!").setNeutralButton("Ok", null).show();        
        
        // Set EventListeners
        this.buttonMap.setOnClickListener(this.eventListener);
        this.buttonMission.setOnClickListener(this.eventListener);
        this.buttonBrowse.setOnClickListener(this.eventListener);               
        
    }
    
    /*
     * Checks the network state.
     * Returns true if a connection exists, fales otherwise.
     */
    private Boolean getNetworkState()
    {
    	  ConnectivityManager connectivityManager 
          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    	  NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    	  return activeNetworkInfo != null;
    }
    
    public Button getButtonMap()			{return this.buttonMap; }
    public Button getButtonMission()		{return this.buttonMission; }
    public static Boolean getConnection()	{return connection; }
    public Button getButtonBrowse()			{return this.buttonBrowse;}
    
    public void onDestroy()
    {
    	super.onDestroy();
    	System.exit(0);   
    }
}