package com.wastl;

import com.wastl.Entity.DistrictEntity;
import com.wastl.Entity.DistrictMap;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 06/03/2012
 * @since 1.2.2
 */
public class XMLWrapper 
{
	private WastlStatus mStatus = null;
	
	private static Integer mCountMissions = 0;
	private static Integer mCountFireDepartments = 0;
	
	/**
	 * Default constructor.
	 */
	public XMLWrapper()
	{
		// Initialize objects
		this.initializeObjects();
	}
	
	private void initializeObjects()
	{
		this.mStatus = new WastlStatus();
	}
	
	public void refreshStatus()
	{
		// clear the current list.
		DistrictMap.getMap().clear();
		
		// get the current status of Lower Austria
		this.mStatus.downloadCurrentStatus();
		
		for(Integer districtId : DistrictEntity.FetchAllIds())
		{	
			// will create a new entity
			DistrictEntity district = DistrictMap.getInstance(districtId);
								
			mCountMissions += district.getCountMission();
			mCountFireDepartments += district.getCountFireDepartment();
			
		}
	}
	
	public static Integer GetCountMissions() {
		return mCountMissions;
	}
	
	public static Integer GetCountFireDepartments(){
		return mCountFireDepartments;
	}
}
