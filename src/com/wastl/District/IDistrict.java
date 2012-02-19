/*
 * Filename: IDistrict.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: interface class for District
 */
package com.wastl.District;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public interface IDistrict {
	
	public Integer getId();
	public Integer getCountMission();
	public Integer getCountFireDepartment();
	
	public void setId(Integer _id);
	public void setCountMission(Integer _countMission);
	public void setCountFireDepartment(Integer _countFireDepartment);
}
