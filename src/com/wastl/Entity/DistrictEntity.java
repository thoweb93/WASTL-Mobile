/*
 * Filename: District.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: Provides the structure for a District instance
 */
package com.wastl.Entity;

import com.wastl.Database.DatabaseFacade;

import android.content.ContentValues;

/**
 * Defines the structure of a district entity.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 19/02/2012
 * @since 1.2.1
 */
public class DistrictEntity extends DistrictIds
{

	private Integer mDistrictId = 0;
	private Integer mCountMission = 0;
	private Integer mCountFireDepartment = 0;	
	private String mName = "";
	
	
	/**
	 * Default constructor
	 */
	public DistrictEntity()
	{
		this(0,"");
	}
	
	/**
	 * Constructor, sets the name and the id of the district.
	 * @param _id 		the name of the district.
	 * @param _name		the id of the district.
	 */
	public DistrictEntity(Integer _id, String _name)
	{
		this.setId(_id);
		this.setName(_name);
	}
	
	/**
	 * Retrieves the id of the district.
	 * @return the id.
	 */
	public Integer getId()
	{
		return this.mDistrictId;
	}
	
	/**
	 * Sets the id of the district.
	 * @param _id the id.
	 */
	public void setId(Integer _id) {
		this.mDistrictId = _id;
	}

	/**
	 * Retrieves the name of the district.
	 * @return the name.
	 */
	public String getName()
	{
		return this.mName;
	}
	
	/**
	 * Sets the name of the district.
	 * @param _name the name.
	 */
	public void setName(String _name){
		this.mName = _name;
	}
	
	/**
	 * Retrieves the count of missions.
	 * @return the count.
	 */
	public Integer getCountMission() 
	{
		return this.mCountMission;		
	}
	
	/**
	 * Sets the count of missions.
	 * @param _countMission the count.
	 */
	public void setCountMission(Integer _countMission) {
		this.mCountMission = _countMission;
	}

	/**
	 * Retrieves the count of fire departments in the district.
	 * @return the count.
	 */
	public Integer getCountFireDepartment()
	{
		return this.mCountFireDepartment;
	}	
	
	/**
	 * Sets the count of fire departments in the district.
	 * @param _countFireDepartment the count.
	 */
	public void setCountFireDepartment(Integer _countFireDepartment) {
		this.mCountFireDepartment = _countFireDepartment;
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
	
	public static Integer[] FetchAllIds()
	{
		return new Integer[]{ID_AAZ_KLOSTERNEUBURG, ID_AAZ_PURKERSDORF, ID_AAZ_SCHWECHAT, ID_BAZ_AMSTETTEN, ID_BAZ_BADEN, ID_BAZ_BRUCK_LEITHA, 
				ID_BAZ_GMÜND, ID_BAZ_GÄNSENDORF, ID_BAZ_HOLLABRUNN, ID_BAZ_HORN, ID_BAZ_KREMS_DONAU, ID_BAZ_LILIENFELD, ID_BAZ_MELK, ID_BAZ_MISTELBACH,
				ID_BAZ_MÖDLING, ID_BAZ_NEUNKIRCHEN, ID_BAZ_SCHEIBBS, ID_BAZ_ST_PÖLTEN, ID_BAZ_STOCKERAU, ID_BAZ_TULLN, ID_BAZ_WAIDHOFEN_THAYA,
				ID_BAZ_WIENER_NEUSTADT, ID_BAZ_ZWETTL, ID_LWZ};
		
	}
	
}


