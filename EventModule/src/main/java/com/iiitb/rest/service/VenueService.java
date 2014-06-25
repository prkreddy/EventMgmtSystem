package com.iiitb.rest.service;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import com.iiitb.rest.dao.VenueDAO;
import com.iiitb.rest.dao.impl.VenueDAOImpl;
import com.iiitb.rest.model.Venue;

@Path("/venue")
public class VenueService
{

	@POST
	@Path("/post/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertVenue(Venue venue) throws Exception
	{

		int status_id = -1;
		int status_code = -1;
		JSONObject jsonObject = new JSONObject();

		String returnString = "";

		try
		{

			VenueDAO dao = new VenueDAOImpl();

			status_id = dao.insertVenue(venue);

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
