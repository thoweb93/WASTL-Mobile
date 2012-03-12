package com.wastl.Database;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.content.Context;

import com.wastl.XMLParser;
import com.wastl.Entity.DistrictEntity;
import com.wastl.Entity.FireDepartmentEntity;

/**
 * Parses the raw XML files, which are containing the data for the database.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 08/03/2012
 * @since 1.2.2
 */
public class DatabaseBuilder 
{
	private Context mContext = null;
	private Districts mDistricts = null;
	private FireDepartments mFireDepartments = null;
	
	public DatabaseBuilder(Context _context)
	{		
		this.mContext = _context;
		
		this.initializeObjects();
	}
	
	private void initializeObjects()
	{
		this.mDistricts = new Districts(mContext);
		this.mFireDepartments = new FireDepartments(mContext);
	}
	
	/**
	 * Builds the database, inserts every district and fire department.
	 */
	public void buildDatabase()
	{
		XMLParser parser = new XMLParser();
		NodeList bazList = parser.load_BAZ_XML(mContext);
		NodeList fireDeparmentList 	= parser.load_Fire_Department_XML(mContext);
		
		// add a row for every district to the database
		for(int i = 0; i < bazList.getLength(); i++)
		{
			DistrictEntity district = null;	
			Element element = (Element)bazList.item(i);	
			
			district = new DistrictEntity(Integer.parseInt(parser.getNodeByString(element, "ID")), parser.getNodeByString(element, "Name"));
			
			mDistricts.addDistrict(district);
		}
		
		for(int i = 0; i < fireDeparmentList.getLength(); i++)
		{
			Element element = (Element)fireDeparmentList.item(i);
							
			FireDepartmentEntity fireDepartment = new FireDepartmentEntity();								
			
			fireDepartment.setFireDepartmentId(0);
			fireDepartment.setFireDepartmentDistrictID(Integer.parseInt(parser.getNodeByString(element, "BAZ_ID")));
			fireDepartment.setFireDepartmentName(parser.getNodeByString(element, "Name"));							
			fireDepartment.setFireDepartmentLocation(parser.getNodeByString(element, "Location") + " Austria");				
			fireDepartment.setFireDepartmentPhoneNumber(parser.getNodeByString(element, "Phone"));
		
			mFireDepartments.addFireDepartment(fireDepartment);			
		}
	}
}
