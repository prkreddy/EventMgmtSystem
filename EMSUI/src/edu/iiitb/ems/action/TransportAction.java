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

public class TransportAction extends ActionSupport implements SessionAware
{

	private String travelmode;
	private String travel_type;
	private String user_event;
	private String source;
	private String destination;
	private String departureDate;
	private String departureTime;
	private String returnDate;
	private String returnTime;
	private String passCount;
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

	public String getTravelmode()
	{
		return travelmode;
	}

	public void setTravelmode(String travelmode)
	{
		this.travelmode = travelmode;
	}

	public String getTravel_type()
	{
		return travel_type;
	}

	public void setTravel_type(String travel_type)
	{
		this.travel_type = travel_type;
	}

	public String getUser_event()
	{
		return user_event;
	}

	public void setUser_event(String user_event)
	{
		this.user_event = user_event;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getDestination()
	{
		return destination;
	}

	public void setDestination(String destination)
	{
		this.destination = destination;
	}

	public String getDepartureDate()
	{
		return departureDate;
	}

	public void setDepartureDate(String departureDate)
	{
		this.departureDate = departureDate;
	}

	public String getDepartureTime()
	{
		return departureTime;
	}

	public void setDepartureTime(String departureTime)
	{
		this.departureTime = departureTime;
	}

	public String getReturnDate()
	{
		return returnDate;
	}

	public void setReturnDate(String returnDate)
	{
		this.returnDate = returnDate;
	}

	public String getReturnTime()
	{
		return returnTime;
	}

	public void setReturnTime(String returnTime)
	{
		this.returnTime = returnTime;
	}

	public String getPassCount()
	{
		return passCount;
	}

	public void setPassCount(String passCount)
	{
		this.passCount = passCount;
	}

	public String execute()
	{

		User user = (User) session.get("user");

		Client client = Client.create();

		WebResource webResource = client.resource(Constants.TRAVEL_MODULE_HOST + "transport/post/insert");

		StringBuilder br = new StringBuilder();

		String input = "{\"travelmode\":\"" + travelmode + "\",\"travel_type\":\"" + travel_type + "\",\"user_event\":\"" + user_event
				+ "\",\"source\":\"" + source + "\",\"destination\":\"" + destination + "\",\"departureDate\":\"" + departureDate + "\","
				+ "\"departureTime\":\"" + departureTime + "\"";

		br.append(input);

		if (returnDate != null && !("".equals(returnDate)))
		{
			br.append(",\"returnDate\":\"" + returnDate + "\"" + ",\"returnTime\":\"" + returnTime + "\"");
		}
		br.append(",\"passCount\":" + passCount + "}");

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, br.toString());

		if (response.getStatus() != 200)
		{
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);

		try
		{
			org.codehaus.jettison.json.JSONObject obj = new org.codehaus.jettison.json.JSONObject(output);

			trackingId = obj.optString("service_id");

			System.out.println("service_id::" + trackingId);
			String invoice_id = obj.optString("invoice_id");

			System.out.println("invoice_id::" + invoice_id);
		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(output);

		return SUCCESS;

	}

	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		this.session = arg0;

	}

}
