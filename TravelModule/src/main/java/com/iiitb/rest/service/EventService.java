package com.iiitb.rest.service;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import com.iiitb.rest.dao.EventDAO;
import com.iiitb.rest.dao.UserDAO;
import com.iiitb.rest.dao.impl.EventDAOImpl;
import com.iiitb.rest.dao.impl.UserDAOImpl;
import com.iiitb.rest.model.Event;
import com.iiitb.rest.model.User;

@Path("/event")
public class EventService
{

	@GET
	@Path("/get/{eventid}")
	public Response findEvent(@PathParam("eventid") int eventId)
	{
		System.out.println(eventId);
		String output = "";

		EventDAO dao = new EventDAOImpl();

		Event event;
		try
		{
			event = dao.getEventByEventId(eventId + "");
			output = "Event name : " + event.getEvent_name() + ", Event StartDate: " + event.getEvent_start_date();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.status(200).entity(output).build();

	}

	@POST
	@Path("/post/insert")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertEvent(Event event) throws Exception
	{

		int status_id = -1;
		int status_code = -1;
		JSONObject jsonObject = new JSONObject();

		String returnString = "";

		try
		{

			EventDAO dao = new EventDAOImpl();

			status_id = dao.insertEvent(event);

			if (status_id != -1)
			{
				jsonObject.put("MSG", "Item has been entered successfully");
				jsonObject.put("status_id", status_id);
				status_code = 200;
				returnString = jsonObject.toString();
			}
			else
			{
				status_code = 500;
				returnString = "Unable to enter Item";
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			status_code = 500;
			returnString = "Server was not able to process your request";

		}

		return Response.status(status_code).entity(returnString).build();

	}
}