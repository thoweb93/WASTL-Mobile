package com.wastl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
	public XMLParser()
	{
		
	}
	
	/** Retrieves the content of an parent Item (_searchPattern) */
	public int getDataOfDistrict(String _xmlFile, String _id, Element _bezirInfo, String _searchPattern)
	{
		int count = 0 ;
		
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();		
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(_xmlFile));
			
			doc.getDocumentElement().normalize();			
			
			_bezirInfo = doc.getElementById(_id);
			
			_bezirInfo.getTextContent();
						
		} catch (Exception _e) {
			Log.e(AppFacade.GetTag(), _e.getMessage());
		}

		// retrieve the count
		Node nodeCount = this.getNodeByString(_bezirInfo,_searchPattern);
		// convert the count
		count = Integer.parseInt(nodeCount.getTextContent());
		
		return count;
	}
	
	/** Is used to retrieve a element
	 * @param _element defines the element to search
	 * @param _searchString search term */
	private Node getNodeByString(Element _element,String _searchString)
	{
		Element element = _element;
		
		NodeList nodeList = element.getElementsByTagName(_searchString);
				
		Node node = nodeList.item(0);		
		
		return node;
	}
}
