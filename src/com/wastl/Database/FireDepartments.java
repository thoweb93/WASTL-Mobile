package com.wastl.Database;

// com.wastl
import com.wastl.Entity.FireDepartmentEntity;
//android
import android.content.Context;
import android.database.Cursor;

/**
 * Exposes methods for accessing the fire department's table.
 * 
 * @author Lukas Bernreiter
 * @version 1.3, 19/06/2012
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
				null, null, null, null, DatabaseFacade.GetColumnFdName());
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}
	
	/**
	 * Fetches a fire department from the database.
	 * @param _id 	the id of the fire department.
	 * @return		a cursor containing the matched fire department.
	 */
	public Cursor fetchFireDepartment(long _id)
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableFireDepartments(),
				new String[]{DatabaseFacade.GetColumnFdId(), DatabaseFacade.GetColumnFdBazId(), DatabaseFacade.GetColumnFdName(), DatabaseFacade.GetColumnFdLocation(), DatabaseFacade.GetColumnFdPhoneNumber()},
				DatabaseFacade.GetColumnFdId() + "=" + _id, null, null, null, DatabaseFacade.GetColumnFdName());
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}
	
	/**
	 * Fetches a fire department from the database.
	 * @param _bazId	the id of the district.
	 * @return			a cursor containing the matched fire department.
	 */
	public Cursor fetchRelatedFireDepartments(long _bazId)
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableFireDepartments(),
				new String[]{DatabaseFacade.GetColumnFdId(), DatabaseFacade.GetColumnFdBazId(), DatabaseFacade.GetColumnFdName(), DatabaseFacade.GetColumnFdLocation(), DatabaseFacade.GetColumnFdPhoneNumber()},
				DatabaseFacade.GetColumnFdBazId()+ "=" + _bazId, null, null, null, DatabaseFacade.GetColumnFdName());
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}
	
	/**
	 * Queries the database with a given search term.
	 * @param _searchstring 	Will be used in the query
	 * @return 					A Cursor containing the matched fire department
	 */
	public Cursor fetchSimilarFireDepartments(String _searchstring)
	{
		Cursor cursor = mDatabase.query(DatabaseFacade.GetTableFireDepartments(),
				new String[]{DatabaseFacade.GetColumnFdId(), DatabaseFacade.GetColumnFdBazId(), DatabaseFacade.GetColumnFdName(), DatabaseFacade.GetColumnFdLocation(), DatabaseFacade.GetColumnFdPhoneNumber()},
				DatabaseFacade.GetColumnFdName() + " LIKE '%" + _searchstring +"%'", null, null, null, DatabaseFacade.GetColumnFdName());
		
		if(null != cursor)
			cursor.moveToFirst();
		
		return cursor;
	}
	
	/**
	 * Adds a new fire department to the database.
	 * @param _relation 	the new fire department
	 * @return 				the row id of the created fire department, or -1 otherwise.
	 */
	public long addFireDepartment(FireDepartmentEntity _fireDepartmentEntity)
	{
		return mDatabase.insert(DatabaseFacade.GetTableFireDepartments(), null, _fireDepartmentEntity.getContentValues());	
	}
	
	/** 
	 * @return The number of rows in the fire departmens table
	 */
	public int countFireDepartments()
	{
		Cursor cursor = mDatabase.rawQuery(DatabaseFacade.GetAllFireDepartments(), null);
		
		return cursor.getCount();
	}
}
