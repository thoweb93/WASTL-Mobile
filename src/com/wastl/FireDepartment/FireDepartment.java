/*
 * Filename: FireDepartment.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: structure for a FireDepartment instance
 */
package com.wastl.FireDepartment;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class FireDepartment implements IFireDepartment{

	private Integer fireDepartmentId 			= 0; //DB
	private Integer fireDepartmentNumber 		= 0;
	private Integer id							= 0;
	private String  fireDepartmentstatus		= "";
	private String 	fireDepartmentPhoneNumber	= ""; //DB
	private String  fireDepartmentName			= ""; //DB
	private String  fireDepartmentLocation		= ""; //DB
	private Integer	fireDepartmentDistrictID	= 0;  //DB
	
	// Constructor
	public FireDepartment(Integer _fireDepartmentId)
	{
		this.fireDepartmentId = _fireDepartmentId;
	}
	
	public FireDepartment(){
		
	}
	

	public Integer getFireDepartmentDistrictID()  {	
		return this.fireDepartmentDistrictID;
	}
	

	public String getFireDepartmentLocation()  {	
		return this.fireDepartmentLocation;
	}

	public String getFireDepartmentPhoneNumber()  {	
		return this.fireDepartmentPhoneNumber;
	}

	public String getFireDepartmentName() {	
		return this.fireDepartmentName;
	}
	
	public Integer getFireDepartmentId() {	
		return this.fireDepartmentId;
	}


	public Integer getFireDepartmentNumber() {
		return this.fireDepartmentNumber;
	}

	public Integer getId() { 
		return this.id;
	}

	public String getFireDepartmentStatus() {
		return this.fireDepartmentstatus;
	}

	public void setFireDepartmentDistrictID(Integer _FireDepartmentDistrictID){
		this.fireDepartmentDistrictID = _FireDepartmentDistrictID;
	}
	
	public void setFireDepartmentLocation(String _FireDepartmentLocation){
		this.fireDepartmentLocation = _FireDepartmentLocation;
	}
	
	public void setFireDepartmentPhoneNumber(String _FireDepartmentPhoneNumber){
		this.fireDepartmentPhoneNumber = _FireDepartmentPhoneNumber;
	}
	

	public void setFireDepartmentName(String _FireDepartmentName) {
		this.fireDepartmentName = _FireDepartmentName;
	}
	

	public void setFireDepartmentId(Integer _fireDepartmentId) {
		this.fireDepartmentId = _fireDepartmentId;
	}


	public void setFireDepartmentNumber(Integer _fireDepartmentNumber) {
		this.fireDepartmentNumber = _fireDepartmentNumber;
	}


	public void setId(Integer _id) {
		this.id = _id;
	}


	public void setFireDepartmentStatus(String _fireDepartmentStatus) {
		this.fireDepartmentstatus = _fireDepartmentStatus;
	}

}
