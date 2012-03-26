package com.wastl;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ithtl.essapp.R;
import com.wastl.Entity.DistrictEntity;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

/**
 * Reads and parses the status file.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 04/03/2012
 * @since 1.2.2
 */
public class XMLParser 
{
	private String mFile = "";
	
	public XMLParser()
	{
		
	}
	
	/**
	 * Constructor, saves the path to the file.
	 * @param _file	a path to the XML file.
	 */
	public XMLParser(String _file)
	{
		this.mFile = _file;
	}
	
	/**
	 * Retrieves the details of a district using a id.
	 * @param _id the id of the district.
	 * @return a instance of DistrictEntity, containing all details.
	 */
	public DistrictEntity getDataOfDistrict(Integer _id)
	{
		Element districtInfo = null;
		
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();		
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(this.mFile));
			
			doc.getDocumentElement().normalize();			
			
			districtInfo = doc.getElementById(_id.toString());
			
			districtInfo.getTextContent();
						
		} catch (Exception _e) {
			Log.e(AppFacade.GetTag(), _e.getMessage());
		}

		// create a new instance
		DistrictEntity district = new DistrictEntity();
		
		try{
			district.setId(_id);
			district.setName(this.getNodeByString(districtInfo, "cFriendlyName"));
			district.setCountMission(Integer.parseInt(this.getNodeByString(districtInfo, "CountEinsatz")));
			district.setCountFireDepartment(Integer.parseInt(this.getNodeByString(districtInfo, "CountFeuerwehr")));
		}catch (Exception _e) {
			Log.e(AppFacade.GetTag(), _e.getMessage());
		}
		
		return district;
	}
	
	public NodeList getListOfFireDepartments(String _xmlFile)
	{
		NodeList fireDepartments = null;
		
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();		
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(_xmlFile));
			
			doc.getDocumentElement().normalize();			
			
			fireDepartments = doc.getElementsByTagName("aFFNr");

		} catch (Exception e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} 
		
		return fireDepartments;
	}
	
	public NodeList load_Fire_Department_XML(Context _context)
	{
		Resources resources = _context.getResources();
		NodeList fireDepartmentList = null;
		InputStream inputStream = resources.openRawResource(R.raw.fire_departments_lower_austria);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(inputStream);
			
			document.getDocumentElement().normalize();
			
			fireDepartmentList = document.getElementsByTagName("FireDepartmentEntity");
			
		} catch (Exception e) {
			Log.e(AppFacade.GetTag(), e.getMessage());		
		}
		
		return fireDepartmentList;	
	}
	
	public NodeList load_BAZ_XML(Context _context)
	{		
		Resources resources = _context.getResources();
		NodeList bazList = null;
		InputStream inputStream = resources.openRawResource(R.raw.baz_lower_austria);
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
		
			Document document = builder.parse(inputStream);
			
			document.getDocumentElement().normalize();
			
			bazList = document.getElementsByTagName("BAZ");
			
		} catch (Exception e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		}
		
		return bazList;
	}
	
	/** Is used to retrieve a element.
	 * @param _element 		defines the element to search
	 * @param _searchString search term 
	 */
	public String getNodeByString(Element _element, String _searchString)
	{
		Element element = _element;
		
		NodeList nodeList = element.getElementsByTagName(_searchString);
				
		Node node = nodeList.item(0);
		
		if("".equals(node))
			return "-";
		
		return node.getTextContent();
	}
}
