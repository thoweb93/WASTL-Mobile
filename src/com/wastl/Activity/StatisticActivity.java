package com.wastl.Activity;

import com.ithtl.essapp.R;
import com.wastl.WastlStatus;
import com.wastl.Database.Districts;
import com.wastl.Database.FireDepartments;
import com.wastl.Entity.Hierarchy;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Displays the current statistic in Lower Austria.
 * 
 * @author Lukas Bernreiter
 * @version 1.3.0, 18/06/2012
 * @since 1.3.0
 */
public class StatisticActivity extends Activity
{
	LinearLayout mLinearLowerAustria = null;
	LinearLayout mLinearWastl = null;
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.statistic);
        
        this.initializeObjects();
        
        this.addLowerAustriaStatistics();
        this.addWastlStatistics();
    }
    
    private void initializeObjects()
    {
    	this.mLinearLowerAustria = (LinearLayout)this.findViewById(R.id.linear_LowerAustria);
    	this.mLinearWastl = (LinearLayout)this.findViewById(R.id.linear_Wastl);
    }
    
    private void addLowerAustriaStatistics()
    {
    	Hierarchy hierarchy = new Hierarchy();
    	
    	TextView lowerAustriaStatistics = new TextView(this.getApplicationContext());
    	lowerAustriaStatistics.setTextSize(22);
    	lowerAustriaStatistics.setTextColor(Color.BLACK);
    	lowerAustriaStatistics.setText(String.format("Einsätze insgesamt: \t %d" +
    												 "%nFeuerwehren im Einsatz: \t %d" +
    												 "%nBezirke im Einsatz: \t %d", 
    												 WastlStatus.GetCountMissions(),
    												 WastlStatus.GetCountFireDepartments(), 
    												 hierarchy.getActiveDistricts().size()));
    	
    	this.mLinearLowerAustria.addView(lowerAustriaStatistics);
    }
    
    private void addWastlStatistics()
    {    	
    	FireDepartments fireDepartments = new FireDepartments(this.getApplicationContext());
    	Districts districts = new Districts(this.getApplicationContext());
    	
    	TextView wastlStatistics = new TextView(this.getApplicationContext());
    	wastlStatistics.setTextSize(20);
    	wastlStatistics.setTextColor(Color.BLACK);
    	wastlStatistics.setText(String.format("Feuerwehren verzeichnet: \t %d " +
										   	  "%nBezirke verzeichnet: \t %d",
										   	  fireDepartments.countFireDepartments(), 
										   	  districts.countDistricts()));
    	
    	this.mLinearWastl.addView(wastlStatistics);
    }
}
