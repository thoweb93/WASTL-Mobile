package com.wastl.Activity;

// com.wastl
import com.ithtl.essapp.R;
import com.wastl.Entity.DistrictMap;
import com.wastl.EventListener.EventListener_MissionActivity;
// Android
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Displays the districts.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 12/03/2012
 * @since 1.2.1
 */
public class MissionActivity extends Activity implements Runnable {

	private EventListener_MissionActivity mEventListener_MissionActivity = null;
	private String[] mContent = null;
	private ListView mListView = null;
	private Context mContext = null;
	private ProgressDialog mProgressDialog = null;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set layout and title
        this.setContentView(R.layout.list_view);        
        ((TextView)this.findViewById(R.id.textView_Title)).setText(R.string.mission_title);
        
        // Initialize objects
        this.initializeObjects();                                     
                 
        // Start working thread
        Thread thread = new Thread(this);
        thread.start();
    }

	private void initializeObjects()
	{
		this.mEventListener_MissionActivity = new EventListener_MissionActivity(this);
		this.mEventListener_MissionActivity.setEvents();
		
		this.mListView = (ListView)this.findViewById(R.id.listView_Content);
		
		this.mContext = this.getApplicationContext();
		
		this.mProgressDialog = ProgressDialog.show(this, "", "List wird bearbeitet.", true);
	}
		
	public void run() {
        DistrictMap.fillDistrictsForList();
		
		// Fetch result
        this.mContent = DistrictMap.getDistrictsForList();
		
		// Update listView
        handler.sendEmptyMessage(0);
	}
		
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	mProgressDialog.dismiss();
                 
        	mListView.setAdapter(new ArrayAdapter<String>(mContext, R.layout.list_item, mContent));    	
        }
	}; 
}
