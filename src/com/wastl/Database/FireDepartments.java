package com.wastl.Database;

// android
import android.content.Context;
import android.database.Cursor;

/**
 * Exposes methods for accessing the fire department's table.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 04/03/2012
 * @since 1.2.2
 */
public class FireDepartments extends MainAdapter 
{

	/**
	 * Constructor, calls base constructor.
	 * @param _context the application context.
	 */
	public FireDepartments(Context _context) {
		super(_context);
	}
	
	/**
	 * Fetches every fire department in the database.
	 * @return a cursor containing all fire departments.
	 */
	public Cursor fetchAllFireDepartments()
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableFireDepartments(),
				new String[]{DatabaseFacade.GetColumnFdId(), DatabaseFacade.GetColumnFdBazId(), DatabaseFacade.GetColumnFdName(), DatabaseFacade.GetColumnFdLocation(), DatabaseFacade.GetColumnFdPhoneNumber()},
				null, null, null, null, null);
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}
	
	/**
	 * Fetches a fire department from the database.
	 * @param _id 	the id of the fire department.
	 * @return		a cursor containing the matched fire department.
	 */
	public Cursor fetchFireDepartment(Integer _id)
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableFireDepartments(),
				new String[]{DatabaseFacade.GetColumnFdId(), DatabaseFacade.GetColumnFdBazId(), DatabaseFacade.GetColumnFdName(), DatabaseFacade.GetColumnFdLocation(), DatabaseFacade.GetColumnFdPhoneNumber()},
				DatabaseFacade.GetColumnFdId() + "=" + _id, null, null, null, null);
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}
	
	/**
	 * Fetches a fire department from the database.
	 * @param _bazId	the id of the district.
	 * @return			a cursor containing the matched fire department.
	 */
	public Cursor fetchRelatedFireDepartment(Integer _bazId)
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableFireDepartments(),
				new String[]{DatabaseFacade.GetColumnFdId(), DatabaseFacade.GetColumnFdBazId(), DatabaseFacade.GetColumnFdName(), DatabaseFacade.GetColumnFdLocation(), DatabaseFacade.GetColumnFdPhoneNumber()},
				DatabaseFacade.GetColumnFdBazId()+ "=" + _bazId, null, null, null, null);
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}
}
