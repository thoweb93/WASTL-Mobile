package com.wastl.Activity;

// com.ithtl.essap
import com.ithtl.essapp.R;
import com.wastl.AppFacade;
import com.wastl.Database.DatabaseFacade;
import com.wastl.Database.FireDepartments;
import com.wastl.EventListener.EventListener_BrowseFireDepartmentsActivity;

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
import android.widget.TextView;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.3, 19/02/2012
 * @since 1.2.1
 */
public class BrowseFireDepartmentsActivity extends Activity implements Runnable {

	private ProgressDialog mProgressDialog = null;
	private Context mContext = null;
	private ListView mListView = null;
	private long mDistrictId = 0;
	private Cursor mCursor = null;
	private EventListener_BrowseFireDepartmentsActivity mEventListener_BrowseFireDepartments = null;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      
        
        /* Set content and title */
        this.setContentView(R.layout.list_view);
        ((TextView)this.findViewById(R.id.textView_Title)).setText("Feuerwehren im Bezirk");
        
        /* Initialize objects and retrieve extra */
        this.initializeObjects();
        
        Thread thread = new Thread(this);
		thread.start();
	}
	
	private void initializeObjects()
	{
        this.mContext = this.getApplicationContext();
        this.mListView = (ListView)this.findViewById(R.id.listView_Content);        
        this.mProgressDialog = ProgressDialog.show(this, "", "Daten werden gelesen", true);
        this.mDistrictId = this.getIntent().getExtras().getLong(AppFacade.GetExId());
        
        this.mEventListener_BrowseFireDepartments = new EventListener_BrowseFireDepartmentsActivity(this);
        this.mEventListener_BrowseFireDepartments.setEvents();
	}
	
	public void run()
	{		
		FireDepartments fireDepartments = new FireDepartments(this);
		this.mCursor = fireDepartments.fetchRelatedFireDepartments(this.mDistrictId);
		this.startManagingCursor(this.mCursor);
		
        this.handler.sendEmptyMessage(0);
	}
	
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	mProgressDialog.dismiss();
         
        	// A list of column names representing the data to bind to the UI
        	String[] from = new String[]{DatabaseFacade.GetColumnFdName() };
        	
        	// The views that should display column in the "from" parameter.
        	int[] to = new int[]{R.id.textView_list };

        	SimpleCursorAdapter dataSource = new SimpleCursorAdapter(mContext, R.layout.list_item, mCursor,from, to);
        	
        	mListView.setAdapter(dataSource);        	
        	
        }
	};
	
	public long getDistrictId()
	{
		return this.mDistrictId;
	}
}
