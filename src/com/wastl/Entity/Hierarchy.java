package com.wastl.Entity;

import java.util.ArrayList;

import com.wastl.AppFacade;
import com.wastl.XMLParser;

/**
 * Mantains a hierarchy of districts. 
 * Each district might a have multiple fire departments.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.4, 18/06/2012
 * @since 1.2.4
 */
public class Hierarchy 
{
	private static DistrictEntity sRootItem = null;
	
	public Hierarchy()
	{
		if(null == sRootItem)
			sRootItem = new DistrictEntity();
	}
	
	public DistrictEntity retrieveDistrict(int _id)
	{
		
		DistrictEntity district = (DistrictEntity) sRootItem.getEntity(_id);
		
		if(district == null)
		{
			XMLParser parser = new XMLParser(AppFacade.GetFullPath());
			district = parser.getDataOfDistrict(_id);
			
			if(district.checkState())
				sRootItem.add(district);
		}

		return district;
	}
	
	public void removeDistrict(DistrictEntity _entity)
	{
		sRootItem.remove(_entity);
	}
	
	public DistrictEntity getDistrict(Integer _key) 
	{			
		return (DistrictEntity) sRootItem.getEntity(_key);
	}
	
	public ArrayList<String> getActiveDistricts()
	{
		return sRootItem.getChildrenName();
	}
	
	public void update()
	{
		sRootItem = new DistrictEntity();
		sRootItem.update();
	}		
}
