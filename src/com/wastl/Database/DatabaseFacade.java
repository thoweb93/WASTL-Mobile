package com.wastl.Database;

/**
 * Provides access for commonly-used database related variables.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 04/03/2012
 * @since 1.2.2
 */
public abstract class DatabaseFacade 
{
	// DB settings
	private static final String DB_NAME 	  = "wastl.db";
	private static final Integer DB_VERSION = 3;
	
	// Table FireDepartments
	private static final String FIREDEPARTMENTS_TABLE_NAME 	= "FireDepartments";	
	private static final String COLUMN_FD_ID 				= "_id";
	private static final String COLUMN_FD_NAME 				= "name";
	private static final String COLUMN_FD_LOCATION 			= "location";
	private static final String COLUMN_FD_PHONE_NUMBER		= "phone";
	private static final String COLUMN_FD_BAZID 			= "baz";
	
	// Table Districts
	private static final String DISTRICTS_TABLE_NAME	= "Districts";
	private static final String COLUMN_DISTRICT_ID 		= "_id";
	private static final String COLUMN_DISTRICT_NAME 	= "name";
	
	// SQL Statements
	private static final String CREATE_TABLE_DISTRICTS = 	"CREATE TABLE IF NOT EXISTS " + DISTRICTS_TABLE_NAME + " ("
													+ COLUMN_DISTRICT_ID   + " INTEGER PRIMARY KEY, " 
													+ COLUMN_DISTRICT_NAME + " TEXT NOT NULL);";
	
	private static final String CREATE_TABLE_FIREDEPARTMENTS = "CREATE TABLE IF NOT EXISTS " + FIREDEPARTMENTS_TABLE_NAME +" (" 
														+ COLUMN_FD_ID		 	 +" INTEGER PRIMARY KEY AUTOINCREMENT, "
		 												+ COLUMN_FD_NAME 		 +" TEXT NOT NULL, " 
		 												+ COLUMN_FD_LOCATION 	 +" TEXT NOT NULL, " 
		 												+ COLUMN_FD_PHONE_NUMBER +" TEXT NO NULL, " 
		 												+ COLUMN_FD_BAZID 	 	 +" INTEGER NOT NULL, FOREIGN KEY (" 
		 												+ COLUMN_FD_BAZID 	 	 + ") REFERENCES "
		 												+ DISTRICTS_TABLE_NAME 	 + "(" + COLUMN_DISTRICT_ID +"));";
	
	private static final String DROP_DISTRICT = "DROP TABLE IF EXISTS " + DISTRICTS_TABLE_NAME;
	
	private static final String DROP_FIREDEPARTMENTS = "DROP TABLE IF EXISTS " + FIREDEPARTMENTS_TABLE_NAME;

	// Getter
	/**
	 * Retrieves the current database version.
	 * @return the version.
	 */
	public static Integer GetDatabaseVersion(){
		return DB_VERSION;
	}
	
	/**
	 * Retrieves the database name.
	 * @return the name.
	 */
	public static String GetDatabaseName(){
		return DB_NAME;
	}
	
	public static String GetTableFireDepartments(){
		return FIREDEPARTMENTS_TABLE_NAME;
	}
	
	public static String GetTableDistricts(){
		return DISTRICTS_TABLE_NAME;
	}
	
	/**
	 * Retrieves the create table statement for the districts table.
	 * @return the statement.
	 */
	public static String GetCreateDistricts(){
		return CREATE_TABLE_DISTRICTS;
	}
	
    /**
     * Retrieves the create table statement for the fire departments table.
     * @return the statement.
     */
	public static String GetCreateFireDepartments(){
		return CREATE_TABLE_FIREDEPARTMENTS;
	}
	
	/**
	 * Retrieves the drop statement for the district table.
	 * @return the drop statement.
	 */
	public static String GetDropDistrict(){
		return DROP_DISTRICT;
	}
	
	/**
	 * Retrieves the drop statement for the fire department table.
	 * @return the drop statement.
	 */
	public static String GetDropFireDepartments(){
		return DROP_FIREDEPARTMENTS;
	}
	
	public static String GetColumnFdBazId(){
		return COLUMN_FD_BAZID;
	}
	
	public static String GetColumnFdId() {
		return COLUMN_FD_ID;
	}

	public static String GetColumnFdName() {
		return COLUMN_FD_NAME;
	}

	public static String GetColumnFdLocation() {
		return COLUMN_FD_LOCATION;
	}

	public static String GetColumnFdPhoneNumber() {
		return COLUMN_FD_PHONE_NUMBER;
	}

	public static String GetColumnDistrictId() {
		return COLUMN_DISTRICT_ID;
	}

	public static String GetColumnDistrictName() {
		return COLUMN_DISTRICT_NAME;
	}
}
