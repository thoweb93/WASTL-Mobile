/*
 * Filename: FireDepartmentFactory.java
 * Author: Lukas Bernreiter
 * Last change: 08.10.2011
 * Description: returns instances, create instances and stores them in a hashMap
 */
package com.wastl.FireDepartment;

import java.util.HashMap;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class FireDepartmentFactory {

	//objects
	private static java.util.Map<Integer, FireDepartmentEntity> instanceMap = new HashMap<Integer, FireDepartmentEntity>();
	private static FireDepartmentFactory instance = null;
	private static String currentBAZId = null;
	private static String[] FireDepartmentsStatus;
	
	private FireDepartmentFactory()
	{
		
	}
	
	//create the instance and store it in the hashMap
	private static void createInstance(Integer _fireDepartmentId)
	{
		FireDepartmentEntity fireDepartment = new FireDepartmentEntity(_fireDepartmentId);
		instanceMap.put(_fireDepartmentId, fireDepartment);
	}
	
	//if the instance is already in the hashMap return it, create it otherwise
	public static FireDepartmentEntity getFireDepartmentInstance(Integer _fireDepartmentId)
	{
		if(!(instanceMap.containsKey(_fireDepartmentId)))
			createInstance(_fireDepartmentId);
		
		FireDepartmentEntity fireDepartment = instanceMap.get(_fireDepartmentId);
		return fireDepartment;
	}
	//getInstance for singleton
	public static FireDepartmentFactory getInstance()
	{
		if(instance==null)
			instance = new FireDepartmentFactory();
		return instance;
	}
	//remove a instance from the hashMap
	public static void removeFireDepartment(Integer _fireDepartmentId)
	{
		instanceMap.remove(_fireDepartmentId);
	}
	
	//seriously I have no idea, where I use that
	public static void setCurrentBAZId(String _BAZId){
		currentBAZId = _BAZId;
	}
	
	//fill the string[] with the status of the fireDepartments
	public static void fillFireDepartmentsForList(Boolean _showAll)
	{			
		FireDepartmentsStatus = new String[]{};			
		
		String buffFireDepartment = new String(); 		//contains every fire department employing
		String buffFireDepartmentAll = new String(); 	//contains a fire department which is not employing
		for(FireDepartmentEntity fireDepartment: instanceMap.values())
		{
			buffFireDepartmentAll = fireDepartment.getFireDepartmentStatus();

			if(!buffFireDepartmentAll.contains("einsatzbereit!")){			
				String currentFireDepartment = fireDepartment.getFireDepartmentStatus();
				
				if(currentFireDepartment.length() == 0)
					currentFireDepartment = "Nicht angegeben;";
				else
					buffFireDepartment += currentFireDepartment + ";";
			}
		}
		FireDepartmentsStatus = buffFireDepartment.split(";");				
		
		java.util.Arrays.sort(FireDepartmentsStatus);
	}
		
	
	public static String[] getFireDepartmentList(){ return FireDepartmentsStatus; }
	public static java.util.Map<Integer, FireDepartmentEntity> getMap(){ return instanceMap;}
	public static String getCurrentBAZId(){ return currentBAZId; }
}
