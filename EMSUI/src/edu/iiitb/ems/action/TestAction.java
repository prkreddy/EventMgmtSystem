package edu.iiitb.ems.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import edu.iiitb.ems.dao.EventDAO;
import edu.iiitb.ems.dao.impl.EventDAOImpl;
import edu.iiitb.ems.model.Event;
import edu.iiitb.ems.model.User;

public class TestAction implements SessionAware
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

		User user = (User) session.get("user");

		if (user != null)
		{

			if ("organiser".equals(user.getUserType()))
			{
				return "organiser";
			}
			else if ("visitor".equals(user.getUserType()))
			{
				return "visitor";
			}
			else
			{
				return "guest";
			}
		}
		return "guest";

	}

	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		this.session = arg0;

	}
}
