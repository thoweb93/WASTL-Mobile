/*
 * Filename: ESSAppActivity.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: Activity class of the main window
 */
package com.wastl.Activity;

// com.ithtl.essap
// com.wastl
import com.ithtl.essapp.R;
import com.wastl.XMLWrapper;
import com.wastl.EventListener.EventListener_MainActivity;

// Android
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Main activity, displays the current status and provides buttons for further interaction.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 08/03/2012
 * @since 1.2.1
 */
public class MainActivity extends Activity {
	
	// Objects
	private EventListener_MainActivity mEventListener_MainActivity = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.main);
        
        this.initializeObjects();                          
    }
    
    private void initializeObjects()
    {
    	// declare events
    	this.mEventListener_MainActivity = new EventListener_MainActivity(this);
    	this.mEventListener_MainActivity.setEvents();    	        
    	
    	// set the results
//    	this.getTextViewMissionCount().setText(XMLWrapper.GetCountMissions());
//    	this.getTextViewFireDepartmentsCount().setText(XMLWrapper.GetCountFireDepartments());
    	
    }       
    
    /*
    /**
     * Retrieves the map button.
     * @return The button.
     *
    public Button getButtonMap(){
    	return (Button)this.findViewById(R.id.button_Map); 
    }
    
    /**
     * Retrieves the missions button.
     * @return The button.
     *
    public Button getButtonMission(){
    	return (Button)this.findViewById(R.id.button_Mission); 
    }
    
    /**
     * Retrieves the browse button.
     * @return The button.
     *
    public Button getButtonBrowse(){
    	return (Button)this.findViewById(R.id.button_Browse);
    }
      
    /**
     * Retrieves the textView for the mission count. 
     * @return The textView.
     *
    public TextView getTextViewMissionCount(){
    	return (TextView)this.findViewById(R.id.textView_missionCount1);
    }
    
    /**
     * Retrieves the textView for the fire department count.
     * @return The textView.
     *
    public TextView getTextViewFireDepartmentsCount(){
    	return (TextView)this.findViewById(R.id.textView_fireDepartmentCount);
    }*/
    
}