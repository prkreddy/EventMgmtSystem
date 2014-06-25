package com.iiitb.rest.dao;

import java.sql.SQLException;
import java.util.List;

import com.iiitb.rest.model.Event;

public interface EventDAO 
{
	
	public int insertEvent(Event event) throws SQLException;
	
	public Event getEventByEventId(String id) throws SQLException;
	
	public List<Event> getEventsTransportNotBooked(String userId, String serviceType) throws SQLException;

}
