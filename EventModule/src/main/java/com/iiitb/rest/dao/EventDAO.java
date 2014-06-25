package com.iiitb.rest.dao;

import java.sql.SQLException;

import com.iiitb.rest.model.Event;

public interface EventDAO 
{
	
	public int insertEvent(Event event) throws SQLException;
	
	public Event getEventByEventId(String id) throws SQLException;

}
