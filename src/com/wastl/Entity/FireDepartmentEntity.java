package com.wastl.Entity;

import java.util.ArrayList;

import com.wastl.Database.DatabaseFacade;

import android.content.ContentValues;

/**
 * Defines the structure of a fire department instance.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 10/03/2012
 * @since 1.2.1
 */
public class FireDepartmentEntity implements Entity {

	private long mFireDepartmentId 			= 0; 
	private Integer mNumber 		= 0;
	private Integer mId				= 0;
	private String  mStatus		= "";
	private String 	mPhoneNumber	= ""; 
	private String  mName			= ""; 
	private String  mLocation		= ""; 
	private long	mDistrictId	= 0;  
	
	/**
	 * Default Constructor
	 */
	public FireDepartmentEntity(){
		
	}
	
	public FireDepartmentEntity(Integer _fireDepartmentId)
	{
		this.mFireDepartmentId = _fireDepartmentId;
	}

	public long getFireDepartmentDistrictID()  {	
		return this.mDistrictId;
	}
	

	public String getFireDepartmentLocation()  {	
		return this.mLocation;
	}

	public String getFireDepartmentPhoneNumber()  {	
		return this.mPhoneNumber;
	}
	
	public long getFireDepartmentId() {	
		return this.mFireDepartmentId;
	}

	public Integer getFireDepartmentNumber() {
		return this.mNumber;
	}

	public Integer getId() { 
		return this.mId;
	}

	public String getFireDepartmentStatus() {
		return this.mStatus;
	}

	public void setFireDepartmentDistrictID(long _fireDepartmentDistrictID){
		this.mDistrictId = _fireDepartmentDistrictID;
	}
	
	public void setFireDepartmentLocation(String _fireDepartmentLocation){
		this.mLocation = _fireDepartmentLocation;
	}
	
	public void setFireDepartmentPhoneNumber(String _fireDepartmentPhoneNumber){
		this.mPhoneNumber = _fireDepartmentPhoneNumber;
	}
	

	public void setFireDepartmentName(String _fireDepartmentName) {
		this.mName = _fireDepartmentName;
	}
	

	public void setFireDepartmentId(Integer _fireDepartmentId) {
		this.mFireDepartmentId = _fireDepartmentId;
	}


	public void setFireDepartmentNumber(Integer _fireDepartmentNumber) {
		this.mNumber = _fireDepartmentNumber;
	}

	public void setId(Integer _id) {
		this.mId = _id;
	}

	public void setFireDepartmentStatus(String _fireDepartmentStatus) {
		this.mStatus = _fireDepartmentStatus;
	}
	
	public ContentValues getContentValues()
	{
		ContentValues values = new ContentValues();
		
		values.put(DatabaseFacade.GetColumnFdName(), 		this.getName());
		values.put(DatabaseFacade.GetColumnFdLocation(), 	this.getFireDepartmentLocation());
		values.put(DatabaseFacade.GetColumnFdPhoneNumber(), this.getFireDepartmentPhoneNumber());
		values.put(DatabaseFacade.GetColumnFdBazId(), 		this.getFireDepartmentDistrictID());
		
		return values;
	}

	public ArrayList<String> traverse() {
		
		
		return null;
	}

	public void add(Entity _entity) 
	{
		// no-op
	}

	public void remove(Entity _entity) 
	{
		// no-op
	}

	public void update() 
	{
		// TODO Implement update
	}

	public int getCount() 
	{
		return 1;
	}

	public String[] getChildren() 
	{	
		return new String[] {this.mName};
	}

	public String getName() 
	{
		return this.mName;
	}

}
