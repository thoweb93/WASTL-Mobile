package com.wastl.Entity;

import java.util.HashMap;

import com.wastl.AppFacade;
import com.wastl.WastlMap;
import com.wastl.XML;
import com.wastl.XMLParser;
import com.wastl.Enums.EnumDistricts;

/**
 * Stores a list of districts in a hash map.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 19/02/2012
 * @version 1.2.1
 */
public class DistrictMap
{		
	
	private static java.util.Map<Integer, DistrictEntity> instanceMap = new HashMap<Integer, DistrictEntity>();
	private static DistrictMap instance = null;
	private static String[] DISTRICTS = new String[]{};
	private static EnumDistricts bezirke = new EnumDistricts();
	
	private DistrictMap()
	{
		
	}
	
	private static void createInstance(Integer _id)
	{
		XMLParser parser = new XMLParser(AppFacade.GetFullPath());
		DistrictEntity district = parser.getDataOfDistrict(_id.toString());
		
		instanceMap.put(_id, district);
	}
	
	public static DistrictEntity getInstance(Integer _id)
	{		
		if(!(instanceMap.containsKey(_id)))
				createInstance(_id);
		
		DistrictEntity bezirk = instanceMap.get(_id);		
		
		return bezirk;
	}
	public static DistrictMap instance()
	{
		if(instance==null)
			instance = new DistrictMap();
		
		return instance;
	}
	
	public static void removeBezirk(Integer _id)
	{
		instanceMap.remove(_id);
	}
	
	public static void removeBezirk(String _id)
	{
		instanceMap.remove(Integer.valueOf(_id));
	}
	
	public static java.util.Map<Integer, DistrictEntity> getMap()
	{
		return instanceMap;
	}
	
	public static void fillDistrictsForList()
	{
		if(instanceMap.size()<1)
		{
			XML xml = new XML();
			xml.downloadAndFillDistrictMap();
			
			// tells the MapActivity to generate a new map
			WastlMap.map = null;
		}
		
		String buffDistricts = new String();		
		for(DistrictEntity bezirk: instanceMap.values())
		{
			if(!(buffDistricts.contains(bezirke.getDistrict(bezirk.getId()))))
				buffDistricts += bezirke.getDistrict(bezirk.getId()) + ";";
		}
		DISTRICTS = buffDistricts.split(";");
		
		java.util.Arrays.sort(DISTRICTS);
	
	}
	
	public static String[] getDistrictsForList() {return DISTRICTS;}
}