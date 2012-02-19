/*
 * Filename: DistrictFactory.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: creates instances of District and stores them in a hashMap
 */
package com.wastl.District;

import java.util.HashMap;

import com.wastl.WastlMap;
import com.wastl.XML;
import com.wastl.Enums.EnumDistricts;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class DistrictFactory
{		
	
	private static java.util.Map<Integer, District> instanceMap = new HashMap<Integer, District>();
	private static DistrictFactory instance = null;
	private static String[] DISTRICTS = new String[]{};
	private static EnumDistricts bezirke = new EnumDistricts();
	
	private DistrictFactory()
	{
		
	}
	
	private static void createInstance(Integer _id)
	{
		EnumDistricts enumDistricts = new EnumDistricts();
		String name = enumDistricts.getDistrict(_id);
		
		District bezirk = new District(_id,  name);
		instanceMap.put(_id, bezirk);
	}
	
	public static District getInstance(Integer _id)
	{		
		if(!(instanceMap.containsKey(_id)))
				createInstance(_id);
		
		District bezirk = instanceMap.get(_id);		
		
		return bezirk;
	}
	public static DistrictFactory instance()
	{
		if(instance==null)
			instance = new DistrictFactory();
		
		return instance;
	}
	public static void removeBezirk(Integer _id)
	{
		instanceMap.remove(_id);
	}
	public static java.util.Map<Integer, District> getMap()
	{
		return instanceMap;
	}
	
	public static void fillDistrictsForList()
	{
		if(instanceMap.size()<1)
		{
			XML xml = new XML();
			xml.downloadAndFillDistrictMap();
			
			// says the MapActivity to generate a new map
			WastlMap.map = null;
		}
		
		String buffDistricts = new String();		
		for(District bezirk: instanceMap.values())
		{
			if(!(buffDistricts.contains(bezirke.getDistrict(bezirk.getId()))))
				buffDistricts += bezirke.getDistrict(bezirk.getId()) + ";";
		}
	DISTRICTS = buffDistricts.split(";");
	
	java.util.Arrays.sort(DISTRICTS);
	
	}
	
	public static String[] getDistrictsForList() {return DISTRICTS;}
}