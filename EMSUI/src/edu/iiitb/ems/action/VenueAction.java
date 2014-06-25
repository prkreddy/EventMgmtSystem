package edu.iiitb.ems.action;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jettison.json.JSONException;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.iiitb.ems.model.User;

public class VenueAction extends ActionSupport implements SessionAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String venueid;

	public String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String streetno;

	public String city;

	public String state;

	public String country;

	public String pincode;

	public String eventid;

	public String getVenueid()
	{
		return venueid;
	}

	public void setVenueid(String venueid)
	{
		this.venueid = venueid;
	}

	public String getStreetno()
	{
		return streetno;
	}

	public void setStreetno(String streetno)
	{
		this.streetno = streetno;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getPincode()
	{
		return pincode;
	}

	public void setPincode(String pincode)
	{
		this.pincode = pincode;
	}

	public String getEventid()
	{
		return eventid;
	}

	public void setEventid(String eventid)
	{
		this.eventid = eventid;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	public String execute()
	{

		System.out.println("EventID: in venueAction" + eventid);

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/EMSModule/rest/venue/post/insert");

		String input = "{\"name\":\"" + name + "\",\"street_no\":\"" + streetno + "\",\"city\":\"" + city + "\",\"state\":\"" + state
				+ "\",\"country\":\"" + country + "\",\"pincode\":\"" + pincode + "\"," + "\"event_id\":" + eventid + "}";

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

			venueid = obj.optString("status_id");

			System.out.println("VENUE_ID::" + venueid);
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
