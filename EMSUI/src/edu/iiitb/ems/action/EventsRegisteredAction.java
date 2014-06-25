package edu.iiitb.ems.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.iiitb.ems.model.Event;
import edu.iiitb.ems.model.User;

public class EventsRegisteredAction extends ActionSupport implements SessionAware
{

	/**
	 * 
	 */
	List<Event> events = new ArrayList<Event>();

	public List<Event> getEvents()
	{
		return events;
	}

	public void setEvents(List<Event> events)
	{
		this.events = events;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	public String execute()
	{

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/TravelModule/rest/transport/get/2");

		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");

		try
		{
			JSONArray jsonArray = new JSONArray(output);
			JSONObject jsonObject = null;

			for (int i = 0; i < jsonArray.length(); i++)
			{
				jsonObject = jsonArray.getJSONObject(i);
				Event event = new Event();
				event.setUser_event_id(jsonObject.optString("user_event_id"));
				event.setEvent_name(jsonObject.optString("event_name"));
				event.setEvent_start_date(jsonObject.optString("event_startdate"));
				event.setEvent_time(jsonObject.optString("event_time"));
				event.getVenue().setName(jsonObject.optString("venue_name"));
				System.out.println("***********************************"+event.getUser_event_id());
				events.add(event);

				System.out.println(jsonObject);

			}

		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;

	}

	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		this.session = arg0;

	}
}
