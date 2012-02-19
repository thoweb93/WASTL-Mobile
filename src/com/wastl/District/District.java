/*
 * Filename: District.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: Provides the structure for a District instance
 */
package com.wastl.District;

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
	
	public String Name = "";
	
	public District(Integer _id, String _name)
	{
		this.bezirkId = _id;	
		this.Name = _name;
	}
	
	public Integer getId()
	{
		return this.bezirkId;
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

	/** Set count of missions
	 * @see com.wastl.District.IDistrict#setCountMission(java.lang.Integer)
	 */
	public void setCountMission(Integer _countMission) {
		this.countMission = _countMission;
	}

	public void setCountFireDepartment(Integer _countFireDepartment) {
		this.countFireDepartment = _countFireDepartment;
	}
}


