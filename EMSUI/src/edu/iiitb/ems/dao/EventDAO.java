package edu.iiitb.ems.dao;

import java.util.List;

import edu.iiitb.ems.model.Event;

public interface EventDAO 
{
	
	public List<Event> getEvents();
	
	public Event getEventImageByEventId(String eventid);

}
