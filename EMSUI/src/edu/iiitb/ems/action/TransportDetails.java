package edu.iiitb.ems.action;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.struts2.interceptor.RequestAware;
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

public class TransportDetails extends ActionSupport implements SessionAware
{

	private String trackingId;

	public String getTrackingId()
	{
		return trackingId;
	}

	public void setTrackingId(String trackingId)
	{
		this.trackingId = trackingId;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	public Event event = new Event();

	public Event getEvent()
	{
		return event;
	}

	public void setEvent(Event event)
	{
		this.event = event;
	}

	public String execute()
	{

		User user = (User) session.get("user");

		if (user != null)
		{

			Client client = Client.create();

			System.out.println("userID: " + user.getUserId());
			WebResource webResource = client.resource(Constants.TRAVEL_MODULE_HOST + "transport/get/transportData/" + trackingId);

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

			String output = response.getEntity(String.class);
			System.out.println(output);

			System.out.println("Output from Server .... \n");

			try
			{
				JSONObject jsonObject = new JSONObject(output);

				if (jsonObject != null)
				{

					event.setEvent_name(jsonObject.optString("event_name"));
					event.getVenue().setName(jsonObject.optString("venue_name"));
					event.getTransport().setTransportId(jsonObject.optString("transport_id"));
					event.getTransport().setSource(jsonObject.optString("source"));
					event.getTransport().setDestination(jsonObject.optString("destination"));
					event.getTransport().setTravelmode(jsonObject.optString("travel_mode"));
					event.getTransport().setDepartureDate(jsonObject.optString("departure_date"));
					event.getTransport().setReturnDate(jsonObject.optString("return_date"));
					event.getTransport().setDepartureTime(jsonObject.optString("departure_time"));
					event.getTransport().setReturnTime(jsonObject.optString("return_time"));
					event.getTransport().setPassCount(Integer.parseInt(jsonObject.optString("person_count")));

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
