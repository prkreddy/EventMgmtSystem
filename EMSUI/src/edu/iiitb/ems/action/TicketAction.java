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
import edu.iiitb.ems.util.Constants;

public class TicketAction extends ActionSupport implements SessionAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String venueid;

	public String eventid;

	public String getEventid()
	{
		return eventid;
	}

	public void setEventid(String eventid)
	{
		this.eventid = eventid;
	}

	public String ticketType;

	public String description;

	public String cost;

	public String ticketcount;

	public String ticketid;

	public String getVenueid()
	{
		return venueid;
	}

	public void setVenueid(String venueid)
	{
		this.venueid = venueid;
	}

	public String getTicketType()
	{
		return ticketType;
	}

	public void setTicketType(String ticketType)
	{
		this.ticketType = ticketType;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCost()
	{
		return cost;
	}

	public void setCost(String cost)
	{
		this.cost = cost;
	}

	public String getTicketcount()
	{
		return ticketcount;
	}

	public void setTicketcount(String ticketcount)
	{
		this.ticketcount = ticketcount;
	}

	public String getTicketid()
	{
		return ticketid;
	}

	public void setTicketid(String ticketid)
	{
		this.ticketid = ticketid;
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

		System.out.println("VenueID: in TicketAction" + venueid);

		Client client = Client.create();

		WebResource webResource = client.resource(Constants.EVENT_MODULE_HOST
				+"ticket/post/insert");

		String input = "{\"type\":\"" + ticketType + "\",\"description\":\"" + description + "\",\"cost\":" + cost + ",\"ticketscount\":"
				+ ticketcount + ",\"venue_id\":" + venueid + "}";

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

			ticketid = obj.optString("status_id");

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
