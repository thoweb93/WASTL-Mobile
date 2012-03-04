/*
 * Filename: District.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: Provides the structure for a District instance
 */
package com.wastl.District;

import com.wastl.Database.DatabaseFacade;

import android.content.ContentValues;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class District implements IDistrict{

	private Integer bezirkId = 0;
	private Integer countMission = 0;
	private Integer countFireDepartment = 0;
	
	private String name = "";
	
	public District(Integer _id, String _name)
	{
		this.setId(_id);
		this.setName(_name);
	}
	
	public Integer getId()
	{
		return this.bezirkId;
	}

	public String getName()
	{
		return this.name;
	}
	
	public Integer getCountMission() 
	{
		return this.countMission;		
	}

	public Integer getCountFireDepartment()
	{
		return this.countFireDepartment;
	}

	/**
	 * Set id
	 * @see com.wastl.District.IDistrict#setId(java.lang.Integer)
	 */	
	public void setId(Integer _id) {
		this.bezirkId = _id;
	}

	public void setName(String _name){
		this.name = _name;
	}
	
	/** Set count of missions
	 * @see com.wastl.District.IDistrict#setCountMission(java.lang.Integer)
	 */
	public void setCountMission(Integer _countMission) {
		this.countMission = _countMission;
	}

	public void setCountFireDepartment(Integer _countFireDepartment) {
		this.countFireDepartment = _countFireDepartment;
	}
	
	/**
	 * Retrieves the content of a district.
	 * @return the content.
	 */
	public ContentValues getContentValues()
	{
		ContentValues values = new ContentValues();
		
		values.put(DatabaseFacade.GetColumnDistrictId(), this.getId());
		values.put(DatabaseFacade.GetColumnDistrictName(), this.getName());
		
		return values;
	}
	
}


