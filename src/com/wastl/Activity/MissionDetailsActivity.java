package com.wastl.Activity;

import java.util.ArrayList;

import com.ithtl.essapp.R;
import com.wastl.AppFacade;
import com.wastl.WastlStatus;
import com.wastl.XMLParser;
import com.wastl.Entity.DistrictEntity;
import com.wastl.Entity.Hierarchy;

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
 * Downloads and displays details about a given district.
 * 
 * @author Lukas Bernreiter
 * @version 1.3, 19/06/2012
 * @since 1.2.1
 */
public class MissionDetailsActivity extends Activity implements Runnable {

	private ProgressDialog mProgressDialog = null;
	private Context mContext = null;
	private DistrictEntity mEntity = null;
	private ListView mListView = null;
	private ArrayList<String> mContent = null;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* Set content and title */
        this.setContentView(R.layout.list_view);
        ((TextView)this.findViewById(R.id.textView_Title)).setText("Aktuelle Einsätze im Bezirk");
        
        /* Initialize objects and retrieve extra */
        this.initializeObjects();
        
        /* Download details */
        this.loadData();
	}
	
	private void initializeObjects()
	{
        this.mContext = this.getApplicationContext();
        
        this.mListView = (ListView) this.findViewById(R.id.listView_Content);
        
        Hierarchy districtHierarchy = new Hierarchy();
		this.mEntity = districtHierarchy.getDistrict(this.getIntent().getExtras().getString(AppFacade.GetExDetails()));
	}
	
	private void loadData()
	{
		this.mProgressDialog = ProgressDialog.show(this, "", "Daten werden geladen", true);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		/* Download details about the selected district */
		WastlStatus status = new WastlStatus();
		status.getDetails(this.mEntity);
		
		XMLParser parser = new XMLParser();
		parser.getDetailsOfDistrict(AppFacade.GetTmpFullPath(), this.mEntity);

		this.mContent = this.mEntity.getActiveFireDepartments();
        
		if(this.mContent.size() == 0)
			this.mContent.add("Keine Details vorhanden!");
		
        handler.sendEmptyMessage(0);
	}
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	mProgressDialog.dismiss();                        
        	
            mListView.setAdapter(new ArrayAdapter<String>(mContext,R.layout.list_item, mContent));
        }       
	};	
}
