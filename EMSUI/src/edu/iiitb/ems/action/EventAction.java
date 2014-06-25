package edu.iiitb.ems.action;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jettison.json.JSONException;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.iiitb.ems.model.User;

public class EventAction extends ActionSupport implements SessionAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String eventid;

	public String eventname;

	public String eventstartdate;

	public String eventenddate;

	public String eventDescription;

	public String eventduration;

	public String eventType;

	public String eventtime;

	public String getEventname()
	{
		return eventname;
	}

	public void setEventname(String eventname)
	{
		this.eventname = eventname;
	}

	public String getEventstartdate()
	{
		return eventstartdate;
	}

	public void setEventstartdate(String eventstartdate)
	{
		this.eventstartdate = eventstartdate;
	}

	public String getEventenddate()
	{
		return eventenddate;
	}

	public void setEventenddate(String eventenddate)
	{
		this.eventenddate = eventenddate;
	}

	public String getEventDescription()
	{
		return eventDescription;
	}

	public void setEventDescription(String eventDescription)
	{
		this.eventDescription = eventDescription;
	}

	public String getEventduration()
	{
		return eventduration;
	}

	public void setEventduration(String eventduration)
	{
		this.eventduration = eventduration;
	}

	public String getEventType()
	{
		return eventType;
	}

	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}

	public String getEventtime()
	{
		return eventtime;
	}

	public void setEventtime(String eventtime)
	{
		this.eventtime = eventtime;
	}

	public String execute()
	{

		User user = (User) session.get("user");

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/EMSModule/rest/event/post/insert");

		String input = "{\"event_name\":\"" + eventname + "\",\"event_start_date\":\"" + eventstartdate + "\",\"event_end_date\":\"" + eventenddate
				+ "\",\"event_time\":\"" + eventtime + "\",\"organiser_id\":\"" + user.getUserId() + "\",\"event_type\":\"" + eventType + "\","
				+ "\"event_duration\":" + eventduration + ",\"event_desc\":\"" + eventDescription + "\"}";

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

		if (response.getStatus() != 200)
		{
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);

		try
		{
			org.codehaus.jettison.json.JSONObject obj = new org.codehaus.jettison.json.JSONObject(output);

			eventid = obj.optString("status_id");

			System.out.println("EVENT_ID::" + eventid);
		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(output);

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
}
