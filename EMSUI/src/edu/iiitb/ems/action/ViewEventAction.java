package edu.iiitb.ems.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import antlr.debug.Event;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.iiitb.ems.model.Ticket;
import edu.iiitb.ems.model.User;
import edu.iiitb.ems.model.Venue;

public class ViewEventAction extends ActionSupport implements SessionAware, ServletRequestAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String eventid;

	public Event getEvent()
	{
		return event;
	}

	public void setEvent(Event event)
	{
		this.event = event;
	}

	public Ticket getTicket()
	{
		return ticket;
	}

	public void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}

	public Venue getVenue()
	{
		return venue;
	}

	public void setVenue(Venue venue)
	{
		this.venue = venue;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	private Event event;

	private Ticket ticket;

	private Venue venue;

	public String execute()
	{

		User user = (User) session.get("user");

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/EMSModule/rest/event/get/24");

		/*
		 * String input = "{\"event_name\":\"" + eventname +
		 * "\",\"event_start_date\":\"" + eventstartdate +
		 * "\",\"event_end_date\":\"" + eventenddate + "\",\"event_time\":\"" +
		 * eventtime + "\",\"organiser_id\":\"" + user.getUserId() +
		 * "\",\"event_type\":\"" + eventType + "\"," + "\"event_duration\":" +
		 * eventduration + ",\"event_desc\":\"" + eventDescription + "\"}";
		 */

		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		/*
		 * if (response.getStatus() != 200) { throw new
		 * RuntimeException("Failed : HTTP error code : " +
		 * response.getStatus()); }
		 */

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		 System.out.println(output);

		try
		{
			JSONObject obj = new JSONObject(output);


			String eventdesc = obj.optString("event_desc");


			System.out.println("eventdesc::" + eventdesc);

		}
		catch (JSONException e)
		{ // TODO Auto-generated catch block e.printStackTrace();

		}

		return SUCCESS;

	}

	public String getEventid()
	{
		return eventid;
	}

	public void setEventid(String eventid)
	{
		this.eventid = eventid;
	}

	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		this.session = arg0;

	}

	HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest arg0)
	{
		// TODO Auto-generated method stub

		request = arg0;

	}
}
