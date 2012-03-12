/*
 * Filename: DBAdapter.java
 * Author: Thomas Weber
 * Last change: 06.12.2011
 * Description: 
 */

package com.wastl.Database;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.wastl.XML;
import com.wastl.Entity.FireDepartmentEntity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 
 * @author Thomas Weber, Lukas Bernreiter
 *
 */

public class DBAdapter  {


	private Context context;
	
	private SQLiteDatabase myDB = null; //DB
	
	//DB settings
	private final static String DB_NAME = "BAZ.db";
	private final static int DB_VERSION = 3;
	
	//Table FireDepartments
	private final static String FIREDEPARTMENTS_TABLE_NAME 	= "FireDepartments";	
	private final static String TABLE_FFID 					= "FF_ID";
	private final static String TABLE_FFNAME 				= "FF_Name";
	private final static String TABLE_FFLOCATION 			= "FF_Location";
	private final static String TABLE_FF_PHONE_NUMBER		= "FF_Phone_Number";
	
	//Table Districts
	private final static String DISTRICTS_TABLE_NAME	= "Districts";
	private final static String TABLE_DISTRICT_ID 		= "District_ID";
	private final static String TABLE_DISTRICT_NAME 	= "District_Name";
	
	//SQL Statements
	private final String CREATE_TABLE_DISTRICTS = 	"CREATE TABLE IF NOT EXISTS " + DISTRICTS_TABLE_NAME +
										 			" ("+TABLE_DISTRICT_ID+" INTEGER primary key, " +
										 			TABLE_DISTRICT_NAME+" VARCHAR(50));";
	
	private final String CREATE_TABLE_FIREDEPARTMENTS = "CREATE TABLE IF NOT EXISTS " + FIREDEPARTMENTS_TABLE_NAME +
		 												" ("+TABLE_FFID+" INTEGER primary key, " +
	 													TABLE_DISTRICT_ID+" INTEGER, " +
		 												TABLE_FFNAME+" VARCHAR(50), " +
		 												TABLE_FFLOCATION+" VARCHAR(50), " +
		 												TABLE_FF_PHONE_NUMBER+" VARCHAR(20));";

	
	public DBAdapter(Context _context){
		this.context = _context;
		
		CustomSQLiteOpenHelper myHelper = new CustomSQLiteOpenHelper(context);
		this.myDB = myHelper.getWritableDatabase();
		
	}
	
	public void addDistrictRow(Integer _DistrictID, String _DistrictName){
		ContentValues values = new ContentValues();
		
		values.put(TABLE_DISTRICT_ID, _DistrictID);
		values.put(TABLE_DISTRICT_NAME, _DistrictName);
		
		try{
			myDB.insert(DISTRICTS_TABLE_NAME, null, values);
		}
		catch(Exception e){
			Log.e("DB ERROR - insert from a firedepartmentrow fail", e.toString());
			e.printStackTrace();			
		}
	}
	
	public void addFireDepartmentRow(FireDepartmentEntity _fireDepartment){
		ContentValues values = new ContentValues();
		
		//fill the content value with one fire department
		values.put(TABLE_FFID, _fireDepartment.getFireDepartmentId());
		values.put(TABLE_FFNAME, _fireDepartment.getFireDepartmentName());
		values.put(TABLE_FFLOCATION, _fireDepartment.getFireDepartmentLocation());
		values.put(TABLE_FF_PHONE_NUMBER, _fireDepartment.getFireDepartmentPhoneNumber());
		values.put(TABLE_DISTRICT_ID, _fireDepartment.getFireDepartmentDistrictID());
		
		try{
			myDB.insert(FIREDEPARTMENTS_TABLE_NAME, null, values);
		}
		catch(Exception e){
			Log.e("DB ERROR - insert from a firedepartmentrow fail", e.toString());
			e.printStackTrace();
		}
		
	}
	
	public void deleteRow(String _tableName, int _rowID){
		try{
//			myDB.delete(_tableName, TABLE_FFID + "="+_rowID, null);
		}
		catch(Exception e){
			Log.e("DB ERROR - Delete Row with ROWID: "+_rowID, e.toString());
			e.printStackTrace();
		}
	}
	
	public FireDepartmentEntity readFireDepartmentByString(String _fireDepartmentName)
	{
		FireDepartmentEntity tmp = new FireDepartmentEntity();
		
		//SQL Query
		Cursor cursor;
		
		try{
			
			cursor = this.myDB.query(
					FIREDEPARTMENTS_TABLE_NAME, 
					new String[] { TABLE_DISTRICT_ID,TABLE_FFNAME,TABLE_FFLOCATION,TABLE_FF_PHONE_NUMBER }, 
					TABLE_FFNAME + "="+ "'"+_fireDepartmentName+"'",
					null, null, null, null, null
			);
			cursor.moveToFirst();
			if(!cursor.isAfterLast()){
				do{
					tmp.setFireDepartmentName(cursor.getString(1));
					tmp.setFireDepartmentLocation(cursor.getString(2));
					tmp.setFireDepartmentPhoneNumber(cursor.getString(3));
				}
				while(cursor.moveToNext());
				
			}
			cursor.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tmp;
	}

	
	public Integer getDistrictIDbyName(String _DistrictName){
		Integer temp = 0;
		
		Cursor cursor;		
		try{
			cursor = this.myDB.query(
					DISTRICTS_TABLE_NAME,
					new String[]{TABLE_DISTRICT_ID},
					TABLE_DISTRICT_NAME + "=" + "'"+_DistrictName+"'", 
					null, null, null, null
			);
			cursor.moveToFirst();			
			if(!cursor.isAfterLast()){
				do{
					temp = (cursor.getInt(0));
				}
				while (cursor.moveToNext());
			}
			cursor.close();
		}
		catch(Exception e){
			Log.d("WASTL", e.toString());
			e.printStackTrace();			
		}		
		
		
		
		return temp;
	}
	
	public String[] readFireDepartmentsbyID(Integer _districtID){
		ArrayList<String> fireDeparment_List = new ArrayList<String>();
		Cursor cursor;
		
		try{
			cursor = this.myDB.query(
					FIREDEPARTMENTS_TABLE_NAME,
					new String[]{TABLE_FFNAME},
					TABLE_DISTRICT_ID + "="  + _districtID, 
					null, null, null, null
			);
			
			cursor.moveToFirst();			
			if(!cursor.isAfterLast()){
				do{
					fireDeparment_List.add(cursor.getString(0));
				}
				while (cursor.moveToNext());
			}
			cursor.close();
		}
		catch(Exception e){
			Log.d("WASTL", e.toString());
			e.printStackTrace();			
		}
		
		// convert the list to a array
		String[] fireDeparments = fireDeparment_List.toArray(new String[fireDeparment_List.size()]);
		
		// sort the list
		java.util.Arrays.sort(fireDeparments);
		
		return fireDeparments;
	}
	
	public String[] readAllDistricts(){
		ArrayList<String> district_List = new ArrayList<String>();
		Cursor cursor;
		
		try{
			cursor = this.myDB.query(
					DISTRICTS_TABLE_NAME,
					new String[]{TABLE_DISTRICT_NAME},
					null, null, null, null, null
			);
			
			cursor.moveToFirst();			
			if(!cursor.isAfterLast()){
				do{
					district_List.add(cursor.getString(0));
				}
				while (cursor.moveToNext());
			}
			cursor.close();
		}
		catch(Exception e){
			Log.d("WASTL", e.toString());
			e.printStackTrace();			
		}		
		
		// convert the list to a array
		String[] districts = district_List.toArray(new String[district_List.size()]);
		
		// sort the list
		java.util.Arrays.sort(districts);
		
		return districts;
	}
	
	
	private class CustomSQLiteOpenHelper extends SQLiteOpenHelper{
		
		private Context context;
		
		public CustomSQLiteOpenHelper(Context _context){			
			super(_context, DB_NAME, null, DB_VERSION);
			this.context = _context;
		}
		
		@Override
		public void onCreate(SQLiteDatabase _myDB){
			_myDB.execSQL(CREATE_TABLE_DISTRICTS);
			_myDB.execSQL(CREATE_TABLE_FIREDEPARTMENTS);					
			
			myDB = _myDB;
			
			this.insertData();
		}

		private void insertData()
		{
			XML xml = new XML();
			
			// load every district and fireDepartment
			NodeList bazList 			= xml.load_BAZ_XML_FromRes(this.context);
			NodeList fireDeparmentList 	= xml.load_Fire_Department_XML_FromRes(this.context);
			
			// create a row for every district in the database
			for(int i = 0; i < bazList.getLength(); i++)
			{					
				Element element = (Element)bazList.item(i);	
				
				Node districtIdNode = xml.getNodeByString(element, "ID");
				Node districtNameNode = xml.getNodeByString(element, "Name");								
				
				Integer districtId = Integer.parseInt(districtIdNode.getTextContent());
				String districtName = districtNameNode.getTextContent();				
				
				addDistrictRow(districtId, districtName);
			}
			
			for(int i = 0; i < fireDeparmentList.getLength(); i++)
			{
				Element element = (Element)fireDeparmentList.item(i);
								
				Node bazIdNode = xml.getNodeByString(element, "BAZ_ID");
				Node fireDepartmentNameNode = xml.getNodeByString(element, "Name");
				String location = xml.getNodeByString(element, "Location").getTextContent();
				String phoneNumber = xml.getNodeByString(element, "Phone").getTextContent();
				
				FireDepartmentEntity fireDepartment = new FireDepartmentEntity();								
				
				fireDepartment.setFireDepartmentId(i);
				fireDepartment.setFireDepartmentDistrictID(Integer.parseInt(bazIdNode.getTextContent()));
				fireDepartment.setFireDepartmentName(fireDepartmentNameNode.getTextContent());							
				fireDepartment.setFireDepartmentLocation(location + " Austria");				
				if(!(phoneNumber == ""))
					fireDepartment.setFireDepartmentPhoneNumber(phoneNumber);
				else
					fireDepartment.setFireDepartmentPhoneNumber("-");
								
				addFireDepartmentRow(fireDepartment);				
			}
			
			
		}
			
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
			if(oldVersion != newVersion)
			{
				// log
				Log.i("WASTL","Updating DB from " + oldVersion +" to " + newVersion);
				
				// delete the current db
				context.deleteDatabase(DB_NAME);

				// and create a new one
				CustomSQLiteOpenHelper myHelper = new CustomSQLiteOpenHelper(context);
				myDB = myHelper.getWritableDatabase();
				
			}
		}
		
		
	}

}
