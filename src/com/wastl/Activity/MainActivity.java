package com.wastl.Activity;

// com.ithtl.essap
// com.wastl
import com.ithtl.essapp.R;
import com.wastl.NavigationAdapter;
import com.wastl.EventListener.EventListener_MainActivity;

// Android
import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

/**
 * Main activity, displays the current status and provides buttons for further interaction.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.3, 26/03/2012
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
    	
    	// fill gridView
    	this.getGridViewNavigation().setAdapter(new NavigationAdapter(this));    	    	
    }       
        
    /**
     * Retrieves the gridView.
     * @return The gridView.
     */
    public GridView getGridViewNavigation(){
    	return (GridView)this.findViewById(R.id.gridview_Main_Navigation);
    }
    
}