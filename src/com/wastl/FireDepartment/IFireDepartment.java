/*
 * Filename: IFireDepartment
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: interace class for a FireDepartment instance
 */
package com.wastl.FireDepartment;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public interface IFireDepartment {
	
	Integer fireDepartmentId 		= 0;
	Integer fireDepartmentNumber 	= 0;
	Integer id						= 0;
	String  fireDepartmentstatus	= "";
	
	public Integer getFireDepartmentId();
	public Integer getFireDepartmentNumber();
	public Integer getFireDepartmentDistrictID();
	public Integer getId();
	public String  getFireDepartmentStatus();
	public String  getFireDepartmentPhoneNumber();
	public String  getFireDepartmentName();
	public String  getFireDepartmentLocation();
	
	public void setFireDepartmentDistrictID(Integer _FireDepartmentDistrictID);
	public void setFireDepartmentLocation(String _FireDepartmentLocation);
	public void setFireDepartmentPhoneNumber(String _FireDepartmentPhoneNumber);
	public void setFireDepartmentId(Integer _fireDepartmentId);
	public void setFireDepartmentNumber(Integer _fireDepartmentNumber);
	public void setId(Integer _id);
	public void setFireDepartmentStatus(String _fireDepartmentStatus);
	public void setFireDepartmentName(String _FireDepartmentName);
	
}
