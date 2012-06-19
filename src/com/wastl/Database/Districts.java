package com.wastl.Database;

import com.wastl.Entity.DistrictEntity;

import android.content.Context;
import android.database.Cursor;

/**
 * Exposes methods for accessing the district's table.
 * 
 * @author Lukas Bernreiter
 * @version 1.3, 19/06/2012
 * @since 1.2.2
 */
public class Districts extends MainAdapter {

	/**
	 * Constructor, calls the base constructor.
	 * @param _context the application context.
	 */
	public Districts(Context _context) {
		super(_context);
	}
	
	/**
	 * Fetches every districts in the database.
	 * @return a cursor containing all districts.
	 */
	public Cursor fetchAllDistricts()
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableDistricts(), new String[]{DatabaseFacade.GetColumnDistrictId(), DatabaseFacade.GetColumnDistrictName()},
				null, null, null, null, DatabaseFacade.GetColumnDistrictName());
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}

	/**
	 * Adds a new district to the database.
	 * @param _relation 	the new district
	 * @return 				the row id of the created district, or -1 otherwise.
	 */
	public long addDistrict(DistrictEntity _districtEntity)
	{	
		return mDatabase.insert(DatabaseFacade.GetTableDistricts(), null, _districtEntity.getContentValues());	
	}
	
	/**
	 * Fetches a district from the database.
	 * @param _id 	the id of the district.
	 * @return		a cursor containing all matched districts.
	 */
	public Cursor fetchDistrict(Integer _id)
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableDistricts(), new String[]{DatabaseFacade.GetColumnDistrictId(), DatabaseFacade.GetColumnDistrictName()},
				DatabaseFacade.GetColumnDistrictId() + "=" +  _id, null, null, null, null);
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}
	
	/**
	 * Fetches a district from the database.
	 * @param _name 	the name of the district.
	 * @return			a cursor containing all matched districts.
	 */
	public Cursor fetchDistrict(String _name)
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableDistricts(), new String[]{DatabaseFacade.GetColumnDistrictId(), DatabaseFacade.GetColumnDistrictName()},
				DatabaseFacade.GetColumnDistrictName() + "=" +  _name, null, null, null, null);	
		
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}	
	
	/**
	 * Deletes a district from the database.
	 * @param _id 	the id of the district.
	 * @return		true if successful, false otherwise.
	 */
	public Boolean deleteDistrict(Integer _id)
	{
		return mDatabase.delete(DatabaseFacade.GetTableDistricts(), DatabaseFacade.GetColumnDistrictId() + "=" +_id, null) > 0;
	}
	
	/**
	 * Counts every row in the districts table. 
	 * @return The number of rows in the districts table.
	 */
	public int countDistricts()
	{
		Cursor cursor = mDatabase.rawQuery(DatabaseFacade.GetAllDistricts(), null);
		
		return cursor.getCount();
	}
}
