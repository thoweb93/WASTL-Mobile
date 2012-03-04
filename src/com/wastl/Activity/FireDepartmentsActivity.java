/*
 * Filename: FireDepartmentActivity
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: Activity class of the FireDepartment screen
 */
package com.wastl.Activity;

import com.ithtl.essapp.R;
import com.wastl.XML;
import com.wastl.Enums.EnumFireDepartments;
import com.wastl.Enums.EnumFireDepartments.ID_FireDistricts;
import com.wastl.FireDepartment.FireDepartmentFactory;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class FireDepartmentsActivity extends ListActivity implements Runnable {

	private XML xml;
	private EnumFireDepartments enumFireDepartments;	
	private String selectedItemText;
	private ProgressDialog progressDialog;
	private Context context;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // initialize objects
        this.enumFireDepartments = new EnumFireDepartments();
        this.xml = new XML();        
        
        // get the selectedItemText from the intent
        this.selectedItemText = this.getIntent().getExtras().getString("selectedItemText");
        
        // set the application context
        this.context = this.getApplicationContext();
        
        this.loadData();
	}
	
	private void loadData()
	{
		this.progressDialog = ProgressDialog.show(this, "", "Daten werden geladen", true);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		//retrieve the enum from the selected item
        ID_FireDistricts id_FireDistrict = this.enumFireDepartments.getEnumFromString(this.selectedItemText);        
        
        //fill instanceMap
        this.xml.setFireDepartments(id_FireDistrict);
        
        //fill string[]
        FireDepartmentFactory.fillFireDepartmentsForList(false);
        
        if(FireDepartmentFactory.getFireDepartmentList().length < 1)
    	{        		
    		xml = new XML();	
			xml.initaliazeObjects();			
			startActivity(new Intent(this,MissionActivity.class));
    	}
        
        handler.sendEmptyMessage(0);
	}
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	progressDialog.dismiss();                        
        	
        	//set data
            setListAdapter(new ArrayAdapter<String>(context,R.layout.list_item, FireDepartmentFactory.getFireDepartmentList()));
            
            // retrieve the listView
            ListView districtListView = getListView();
            
            // set the style
            this.setListViewStyle(districtListView);
            
            districtListView.setTextFilterEnabled(true);
            
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
}
