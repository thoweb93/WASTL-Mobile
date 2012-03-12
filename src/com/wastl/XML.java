/*
 * Filename: XML.java
 * Author: Lukas Bernreiter
 * Last change: 06.12.2011
 * Description: downloads and stores a XML file. Calculates the current count
 * of missions and fire departments employing in Lower Austria
 */

package com.wastl;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException; 
import org.apache.http.util.ByteArrayBuffer;

import com.ithtl.essapp.R;
import com.wastl.Activity.MainActivity;
import com.wastl.Entity.DistrictEntity;
import com.wastl.Entity.DistrictMap;
import com.wastl.Entity.FireDepartmentEntity;
import com.wastl.Enums.EnumDistricts;
import com.wastl.Enums.EnumFireDepartments;
import com.wastl.Enums.EnumFireDepartments.ID_FireDistricts;
import com.wastl.FireDepartment.FireDepartmentMap;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.TextView;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 *
 */

public class XML {

	//Objects
	private EnumDistricts bezirke = new EnumDistricts();	
	private Element bezirkInfo;
	private MainActivity essApp;	
	private Boolean removedLWZ = false;
	private EnumFireDepartments fireDepartments = new EnumFireDepartments(); 	
	
	//results of the calculation-
	private static int districtsEmploying = 0;
	private static int missionCount = 0;
	private static int fireDepartmentCount = 0;
	
	public XML()
	{
		this(null);
	}
	public XML(MainActivity _essApp)
	{
		//Get instance
		if(null != _essApp)
			this.essApp = _essApp;
	}
	
	public void initaliazeObjects(){
		// initialize results
		this.initiliaseResults();
		
		// download XML file and save it to the external device		
		// fill the hashMap with instances
		this.downloadAndFillDistrictMap();
		
		if(this.removedLWZ)
			districtsEmploying -= 1;
		
		districtsEmploying += DistrictMap.getMap().size();
		
		// get the amount of missions and fire departments employing
		missionCount = this.countMissions();
		fireDepartmentCount = this.countFireDepartments();		
	}
		
	// needs to be done on startup
	public void setStartup()
	{	/*
		//now get the textViews from the main activity
		TextView textView_missionCount = (TextView)this.essApp.findViewById(R.id.textView_missionCount);
		TextView textView_fireDepartmentCount = (TextView)this.essApp.findViewById(R.id.textView_fireDepartmentCount);
		TextView textView_districts = (TextView)this.essApp.findViewById(R.id.textView_districts);
		
		
		//print the current count of mission and fire departments employing
		textView_missionCount.setText("Einsätze insgesamt: " + missionCount);
		textView_fireDepartmentCount.setText("Feuerwehren im Einsatz: " + fireDepartmentCount);
		textView_districts.setText("Bezirke im Einsatz: " + districtsEmploying);*/
		
	}
	public void downloadAndFillDistrictMap()
	{
		this.downloadXML(AppFacade.GetMainURL(), AppFacade.GetPath(), AppFacade.GetFilename());							
		this.removedLWZ = false;			
		
		//fill the hashMap with instances
		this.fillDistricts();		
	}
	
/*	public void setFireDepartments(ID_FireDistricts _district)
	{
		//set objects		
		String addition 		= this.fireDepartments.getURL(_district);
		String downloadURL 		= AppFacade.GetDistrictURL() + addition;
		String fileName 		= this.fireDepartments.getFileName(_district);
		String fullPathToFile 	= AppFacade.GetSD() + AppFacade.GetPath() + fileName;
		
		DistrictMap.getMap().clear();
		this.fillDistricts(AppFacade.GetFullPath());
		
		//download the XML file and store it on the external storage
		this.downloadXML(downloadURL, AppFacade.GetPath(), fileName);
		
		FireDepartmentFactory.getMap().clear();		
		
		//fill the hashMap with instances of fire departments
		this.fillFireDepartments(fullPathToFile);
	}
	
	//retrieves and parses a given xml file, it is also used to create the instance in the hashMap
	private void fillFireDepartments(String _filePath)
	{
		NodeList listOfFireDepartments = getListOfFireDepartments(_filePath);							
		
		for(int i = 0; i < listOfFireDepartments.getLength(); i++)
		{		
			Node fireDepartment 		= listOfFireDepartments.item(i);						
			Element element 			= (Element)fireDepartment;
								
			Node fireDepartmentIdNode 	= this.getNodeByString(element, "ID");									
			Node fireDepartmentStatus 	= this.getNodeByString(element, "Title");
			
			Integer fireDepartmentNr 	= Integer.parseInt(fireDepartmentIdNode.getTextContent());
			Integer fireDepartmentId 	= Integer.parseInt(element.getAttribute("id"));
					
			FireDepartment fireDepartmentInstance = FireDepartmentFactory.getFireDepartmentInstance(fireDepartmentId);
			
			fireDepartmentInstance.setFireDepartmentStatus(fireDepartmentStatus.getTextContent());
			
			fireDepartmentInstance.setFireDepartmentNumber(fireDepartmentNr);			
		}		
	}
	
	//get every fire department
	private NodeList getListOfFireDepartments(String _xmlFile)
	{
		NodeList listOfFireDepartments = null;
		
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();		
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(_xmlFile));
			
			doc.getDocumentElement().normalize();			
			
			listOfFireDepartments = doc.getElementsByTagName("aFFNr");

		} catch (ParserConfigurationException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (SAXException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (IOException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		}
		
		return listOfFireDepartments;
	}*/
	
	/** initialize results */
	private void initiliaseResults()
	{
		missionCount 			= 0;
		districtsEmploying 		= 0;
		fireDepartmentCount 	= 0;
		DistrictMap.getMap().clear();
	}
	
	/** Counts every mission from every district stored in the hashMap */
	private int countMissions()
	{
		int missions = 0;
		
		for(DistrictEntity _bezirk: DistrictMap.getMap().values())
		{
			int newCount = _bezirk.getId();
			
			DistrictEntity bezirk = DistrictMap.getInstance(newCount);
			
			missions += bezirk.getCountMission();
		}	
		
		return missions;
	}
	/** Counts every fire department employing from every district stored in the hashMap */
	private int countFireDepartments()
	{
		int departments = 0;
		
		for(DistrictEntity _bezirk: DistrictMap.getMap().values())
		{
			int newCount = _bezirk.getId();
			
			DistrictEntity bezirk = DistrictMap.getInstance(newCount);
			
			departments += bezirk.getCountFireDepartment();
		}	
		
		return departments;
	}
	/** fills the hashMap with a instance of every district, containing the current count of missions
	 * and fire departments deploying in this district */
	public void fillDistricts()
	{
		// clear the list
		DistrictMap.getMap().clear();
		
		for(String districtId: this.getIds())
		{					
			// Create a new instance
			DistrictEntity district = DistrictMap.getInstance(Integer.parseInt(districtId));
								
			
			if(district.getCountFireDepartment().equals(0) && district.getCountMission().equals(0)){
				DistrictMap.removeBezirk(district.getId());				
				if(district.getId().equals(Integer.parseInt(this.bezirke.ID_LWZ)))
					this.removedLWZ = false;
			}else
				if(district.getId().equals(Integer.parseInt(this.bezirke.ID_LWZ)))
					this.removedLWZ = true;
		}
	}
	public void fillDistrictsFull()
	{
		// clear the list
		DistrictMap.getMap().clear();
		
		for(String bezirkID: this.getIds())
			DistrictMap.getInstance(Integer.parseInt(bezirkID));		
	}
	
	/** Retrieves the content of an parent Item (_searchPattern) */
	private int getDataOfDistrict(String _xmlFile, String _id, Element _bezirInfo, String _searchPattern)
	{
		int count = 0 ;
		
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();		
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(_xmlFile));
			
			doc.getDocumentElement().normalize();			
			
			_bezirInfo = doc.getElementById(_id);
			
			_bezirInfo.getTextContent();
						
		} catch (ParserConfigurationException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (SAXException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (IOException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		}

		// retrieve the count
		Node nodeCount = this.getNodeByString(_bezirInfo,_searchPattern);
		// convert the count
		count = Integer.parseInt(nodeCount.getTextContent());
		
		return count;
	}
		
	
	/** Is used to download and store the XML file on the SD card.
	 * @param _URL 			specifies the download URL
	 * @param _path 		specifies the location to store the file
	 * @param _fileName 	the filename */
	private void downloadXML(String _URL, String _path, String _fileName)
	{
		try {
			//download URL
			URL url = new URL(_URL);
				
			//create directory if needed
			File filechk = new File(AppFacade.GetSD() + _path);
			filechk.mkdirs();
			
			//create file
			File file = new File(AppFacade.GetSD() +_path +_fileName);
			
            //open connection
            URLConnection ucon = url.openConnection();
			
            //get the inputStream
            InputStream inputStream = ucon.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            
            ByteArrayBuffer buffer = new ByteArrayBuffer(50);
            int current = 0;
            long totalSize = 0;
            
            //get all bytes
            while ((current = bufferedInputStream.read()) != -1) {
                    buffer.append((byte) current);
                    totalSize += current;
            } 
            //write to file
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(buffer.toByteArray());
            
            //close all existing streams
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            
            //log the result
            Log.i(AppFacade.GetTag(), "download finished ("+totalSize+" Bytes)");
            
		} catch (MalformedURLException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (IOException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		}
		
	}
	
	/** returns a ArrayList containing every district id */
	public ArrayList<String> getIds(){

		ArrayList<String> bezirksIDs = new ArrayList<String>();
		
		for(EnumDistricts.ID_Districts district: EnumDistricts.ID_Districts.values())
		{
			bezirksIDs.add(this.bezirke.getID(district));
		}		
		
		return bezirksIDs;
	}
		
	/** Is used to retrieve a element
	 * @param _element defines the element to search
	 * @param _searchString search term */
	public Node getNodeByString(Element _element,String _searchString)
	{
		Element element = _element;
		
		NodeList nodeList = element.getElementsByTagName(_searchString);
				
		Node node = nodeList.item(0);		
		
		return node;
	}
	
	/*
	 * ------------------------------------------ Build DB from XML ------------------------------------------
	 */	
		
	/** Loads the BAZ XML file from the resources and returns every BAZ as a NodeList. */
	public NodeList load_BAZ_XML_FromRes(Context _context)
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
			
		} catch (SAXException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (IOException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (ParserConfigurationException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		}
		
		return bazList;
	}
	
	public NodeList load_Fire_Department_XML_FromRes(Context _context)
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
			
		} catch (SAXException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (IOException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		} catch (ParserConfigurationException e) {
			Log.e(AppFacade.GetTag(), e.getMessage());
		}
		
		return fireDepartmentList;
	
	}
	
	public static int getMissionCount(){return missionCount;}
	public static int getFireDepartmentCount(){return fireDepartmentCount;}
	public static int getDistrictsEmploying(){return districtsEmploying;}
}
