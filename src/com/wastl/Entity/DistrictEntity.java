package com.wastl.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.wastl.Database.DatabaseFacade;

import android.content.ContentValues;

/**
 * Defines the structure of a district entity.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.3, 19/02/2012
 * @since 1.2.1
 */
public class DistrictEntity extends DistrictIds implements Entity {

	private Integer mDistrictId = 0;
	private Integer mCountMission = 0;
	private Integer mCountFireDepartment = 0;
	private String mName = "";
	private List<Entity> mChildren = new ArrayList<Entity>();

	/**
	 * Default constructor
	 */
	public DistrictEntity() {
		this(0, "");
	}

	/**
	 * Constructor, sets the name and the id of the district.
	 * 
	 * @param _id
	 *            the name of the district.
	 * @param _name
	 *            the id of the district.
	 */
	public DistrictEntity(Integer _id, String _name) {
		this.setId(_id);
		this.setName(_name);
	}

	/**
	 * Retrieves the id of the district.
	 * 
	 * @return the id.
	 */
	public Integer getId() {
		return this.mDistrictId;
	}

	/**
	 * Sets the id of the district.
	 * 
	 * @param _id
	 *            the id.
	 */
	public void setId(Integer _id) {
		this.mDistrictId = _id;
	}

	/**
	 * Retrieves the name of the district.
	 * 
	 * @return the name.
	 */
	public String getName() {
		return this.mName;
	}

	/**
	 * Sets the name of the district.
	 * 
	 * @param _name
	 *            the name.
	 */
	public void setName(String _name) {
		this.mName = _name;
	}

	/**
	 * Retrieves the count of missions.
	 * 
	 * @return the count.
	 */
	public Integer getCountMission() {
		return this.mCountMission;
	}

	/**
	 * Sets the count of missions.
	 * 
	 * @param _countMission
	 *            the count.
	 */
	public void setCountMission(Integer _countMission) {
		this.mCountMission = _countMission;
	}

	/**
	 * Retrieves the count of fire departments in the district.
	 * 
	 * @return the count.
	 */
	public Integer getCountFireDepartment() {
		return this.mCountFireDepartment;
	}

	/**
	 * Sets the count of fire departments in the district.
	 * 
	 * @param _countFireDepartment
	 *            the count.
	 */
	public void setCountFireDepartment(Integer _countFireDepartment) {
		this.mCountFireDepartment = _countFireDepartment;
	}

	/**
	 * Retrieves the content of a district.
	 * 
	 * @return the content.
	 */
	public ContentValues getContentValues() {
		ContentValues values = new ContentValues();

		values.put(DatabaseFacade.GetColumnDistrictId(), this.getId());
		values.put(DatabaseFacade.GetColumnDistrictName(), this.getName());

		return values;
	}

	public static Integer[] FetchAllIds()
	{
		return fetchAllIds();
	}
	
	/**
	 * Checks the state of this district.
	 * @return True if a fire department is currently employing, false otherwise.
	 */
	public Boolean checkState()
	{
		return this.mCountFireDepartment > 0 || this.mCountMission > 0;
	}

	public void add(Entity _entity) 
	{
		this.mChildren.add(_entity);
	}

	public void remove(Entity _entity) 
	{
		this.mChildren.remove(_entity);
	}

	public void update() 
	{	
		for(Iterator<Entity> it = this.mChildren.iterator(); it.hasNext();)
			it.next().update();
	}

	public int getCount() 
	{
		int size = 0;
		for(Iterator<Entity> it = this.mChildren.iterator(); it.hasNext();)
			size += it.next().getCount();
		
		return size;
	}

	public ArrayList<String> getChildrenName() {
		
		ArrayList<String> children = new ArrayList<String>();
		
		for(Iterator<Entity> it = this.mChildren.iterator(); it.hasNext();)
			children.add(it.next().getName());
		
		return children;
	}	
	
	public Entity getEntity(int _key)
	{
		DistrictEntity tmp = null;
		
		for(Iterator<Entity> it = this.mChildren.iterator(); it.hasNext();)
		{
			tmp = (DistrictEntity)it.next();
			if(_key == tmp.getId())
					return tmp;
		}

		return null;
	}
}
