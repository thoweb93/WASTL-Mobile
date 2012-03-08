package com.wastl.Database;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.ithtl.essapp.R;
import com.wastl.AppFacade;

/**
 * Parses the raw XML files, which are containing the data for the database.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 08/03/2012
 * @since 1.2.2
 */
public class Builder 
{
	public Builder()
	{
		
		
	}
	
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
}
