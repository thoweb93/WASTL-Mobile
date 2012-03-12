package com.wastl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import com.wastl.Entity.DistrictEntity;
import com.wastl.Entity.DistrictMap;


import android.util.Log;

/**
 * Downloads and stores the current status in Lower Austria.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 06/03/2012
 * @since 1.2.2
 */
public class WastlStatus 
{	
	private static Integer mCountMissions = 0;
	private static Integer mCountFireDepartments = 0;
	
	/**
	 * Default constructor.
	 */
	public WastlStatus()
	{
		// Create directory if needed
		new File(AppFacade.GetPath()).mkdirs();
	}
	
	private void downloadCurrentStatus()
	{
		InputStream inputStream = null;
		OutputStream outputStream = null;
		int current = 0;
		
		try {
			URL url = new URL(AppFacade.GetMainURL());
			URLConnection connection = (URLConnection) url.openConnection();
			inputStream = new BufferedInputStream(connection.getInputStream(), 1024 * 5);
			outputStream = new FileOutputStream(AppFacade.GetFullPath());
			
			byte buff[] = new byte[1024 * 5];
			
			while((current = inputStream.read(buff)) != -1)
				outputStream.write(buff, 0, current);			
			
		} catch (Exception _e) {
			Log.e(AppFacade.GetTag(), _e.getMessage());
		}
		finally{
			try {
				outputStream.flush();
				outputStream.close();
				inputStream.close();
			} catch (IOException _e) {
				Log.e(AppFacade.GetTag(), _e.getMessage());
			}
		}
	}
	
	public void refreshStatus()
	{
		// Clear the current list.
		DistrictMap.getMap().clear();
		
		// Get the current status of Lower Austria
		this.downloadCurrentStatus();
		
		for(Integer districtId : DistrictEntity.FetchAllIds())
		{	
			// Create a new entity
			DistrictEntity district = DistrictMap.getInstance(districtId);
								
			mCountMissions += district.getCountMission();
			mCountFireDepartments += district.getCountFireDepartment();
		}
	}
	
	public void getFireDepartmentStatus(String _bazId)
	{
		
	}
	
	public static Integer GetCountMissions() {
		return mCountMissions;
	}
	
	public static Integer GetCountFireDepartments(){
		return mCountFireDepartments;
	}
}
