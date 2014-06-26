package edu.iiitb.ems.action;

import java.util.ArrayList;
import java.util.List;

import edu.iiitb.ems.dao.EventDAO;
import edu.iiitb.ems.dao.impl.EventDAOImpl;
import edu.iiitb.ems.model.Event;

public class TestAction
{

	String pagetype;

	public String getPagetype()
	{
		return pagetype;
	}

	public void setPagetype(String pagetype)
	{
		this.pagetype = pagetype;
	}

	List<String> eventids = new ArrayList<String>();

	public List<String> getEventids()
	{
		return eventids;
	}

	public void setEventids(List<String> eventids)
	{
		this.eventids = eventids;
	}

	public String execute()
	{

		EventDAO dao = new EventDAOImpl();
		List<Event> events = dao.getEvents();

		for (Event event : events)
		{
			eventids.add(event.getEvent_id() + "");

		}

		if ("organiser".equals(pagetype))
		{
			return "organiser";
		}
		else if ("visitor".equals(pagetype))
		{
			return "visitor";
		}
		else
		{
			return "guest";
		}

	}
}
