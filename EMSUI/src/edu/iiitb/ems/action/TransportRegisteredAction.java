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
import edu.iiitb.ems.util.Constants;

public class TransportRegisteredAction extends ActionSupport implements SessionAware
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

		User user = (User) session.get("user");

		if (user != null)
		{

			Client client = Client.create();

			System.out.println("userID: " + user.getUserId());
			WebResource webResource = client.resource(Constants.TRAVEL_MODULE_HOST + "transport/get/transRegistered/" + user.getUserId());

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

			String output = response.getEntity(String.class);
			System.out.println(output);

			System.out.println("Output from Server .... \n");

			try
			{
				JSONArray jsonArray = new JSONArray(output);
				JSONObject jsonObject = null;

				for (int i = 0; i < jsonArray.length(); i++)
				{
					jsonObject = jsonArray.getJSONObject(i);
					Event event = new Event();
					event.getTransport().setTransportId(jsonObject.optString("serviceId"));
					event.setEvent_name(jsonObject.optString("event_name"));
					event.getVenue().setName(jsonObject.optString("venue_name"));
					event.getTransport().setSource(jsonObject.optString("source"));
					event.getTransport().setDestination(jsonObject.optString("destination"));
					event.getTransport().setPassCount(Integer.parseInt(jsonObject.optString("passengercount")));
					events.add(event);

					System.out.println(jsonObject);

				}

			}
			catch (JSONException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			return LOGIN;
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
