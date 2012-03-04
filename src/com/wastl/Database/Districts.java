package com.wastl.Database;

// com.wastl
import com.wastl.District.District;
// android
import android.content.Context;
import android.database.Cursor;

/**
 * Provides access to the district table.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 04/03/2012
 * @since 1.2.2
 */
public class Districts extends MainAdapter {

	public Districts(Context _context) {
		super(_context);
	}

	/**
	 * Adds a new relation to the database.
	 * @param _relation 	the new relation
	 * @return 				the row id of the newly created relation, or -1 otherwise.
	 */
	public long addDistrict(District _districtEntity)
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
}
