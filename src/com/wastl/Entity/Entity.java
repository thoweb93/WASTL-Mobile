package com.wastl.Entity;

/**
 * Declares an interface that defines the methods implemented by the leafs and composites.
 * Defines methods for accessing and managing components.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.4, 18/06/2012
 * @since 1.2.4
 */
public interface Entity 
{
	void add(Entity _entity);			/* Adds a new child to an existing entity */
	void remove(Entity _entity);		/* Removes a given child from an existing entity */
	void update();						/* Initiates an update process */
	int getCount();						/* Retrieves the count */
	String getName();					/* Returns the name of the object */
}
