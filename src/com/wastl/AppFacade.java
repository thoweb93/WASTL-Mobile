package com.wastl;

import java.io.File;

import android.os.Environment;

/**
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * @since 1.2.1
 */
public class AppFacade
{
	private static final String TAG = "WASTL Mobile";
	private static final String PATH = "/data/WASTL/";
	private static final File SD = Environment.getExternalStorageDirectory();
	private static final String FILENAME = "wastlmain.xml";
	private static final String URL_MAIN = "http://www.feuerwehr-krems.at/CodePages/Wastl/GetDaten/getwastlmain.asp";
	private static final String URL_DISTRICT = "http://www.feuerwehr-krems.at/CodePages/Wastl/GetDaten/GetWastlBezirk.asp?Bezirk=";
	
	/** Retrieves the tag of the application. Used for logging */ 
	public static String GetTag(){ return TAG;}
	
	/** Retrieves the path to store the files. */
	public static String GetPath(){return SD + PATH;}
	
	/** Retrieves the path to the SD card. */
	public static File GetSD(){return SD;}
	
	/** Retrieves the filename. Used to store the files */
	public static String GetFilename(){return FILENAME;}
	
	/** Retrieves the full path to the main XML file. */
	public static String GetFullPath(){return SD+PATH+FILENAME;}
	
	/** Retrieves the main URL. */
	public static String GetMainURL(){return URL_MAIN;}
	
	/** Retrieves the URL for the districts. */
	public static String GetDistrictURL(){return URL_DISTRICT;}
}
