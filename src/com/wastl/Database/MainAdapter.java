package com.wastl.Database;

import com.wastl.AppFacade;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Provides access to the database. Opens or creates the database.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 04/03/2012
 * @since 1.2.2
 */
public abstract class MainAdapter 
{
	protected static Context mContext = null;
	protected static SQLiteDatabase mDatabase = null;
	protected static MainDatabaseHelper mHelper = null;
	private static Boolean mCreated = false;
	
	/** 
	 * Constructor, saves the application context 
	 * @param _context the application context 
	 */
	public MainAdapter(Context _context)
	{
		mContext = _context;
		
		mHelper = this.getInstance();
	}
	
	private MainDatabaseHelper getInstance()
	{
		if(mHelper == null)
		{
			mHelper = new MainDatabaseHelper(mContext);
			
			try
			{
				Log.i(AppFacade.GetTag(), "Opening database");
				mDatabase = mHelper.getWritableDatabase();
			}catch(SQLiteException se){ 
				Log.e(AppFacade.GetTag(), "Error opening database"); 
			}
			
			if(true == mCreated)
			{
				DatabaseBuilder builder = new DatabaseBuilder(mContext);
				builder.buildDatabase();
				mCreated = false;
			}
		}
		
		return mHelper;
	}
	
	/** Database helper */
	protected static class MainDatabaseHelper extends SQLiteOpenHelper
	{
		/** 
		 * Constructor
		 * @param _context the application context.
		 */
		public MainDatabaseHelper(Context _context){
			super(_context, DatabaseFacade.GetDatabaseName(), null, DatabaseFacade.GetDatabaseVersion());
		}

		@Override
		public void onCreate(SQLiteDatabase _db) {
			
			Log.i(AppFacade.GetTag(), "Creating database");

			try {			
				_db.execSQL(DatabaseFacade.GetCreateDistricts());
				_db.execSQL(DatabaseFacade.GetCreateFireDepartments());				
			} catch(SQLException _se){ 
				Log.e(AppFacade.GetTag(), "Could not create the database"); 
			}
			
			mCreated = true;
		}
	
		@Override
		public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
			Log.w(AppFacade.GetTag(), "Upgrading database from " + _oldVersion + " to " + _newVersion);
			
			try{
				_db.execSQL(DatabaseFacade.GetDropDistrict());
				_db.execSQL(DatabaseFacade.GetDropFireDepartments());
			}catch(SQLException _se){
				Log.e(AppFacade.GetTag(), "Could not drop table");
			}
			
			this.onCreate(_db);
		}
	}
		
}
