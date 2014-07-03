package com.iiitb.rest.service;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.iiitb.rest.dao.EventDAO;
import com.iiitb.rest.dao.impl.EventDAOImpl;
import com.iiitb.rest.model.Event;

@Path("/poster")
public class PosterService
{

	@GET
	@Path("/event/{id}")
	@Produces("image/jpeg")
	public byte[] getImageRepresentation(@PathParam("id") int id)
	{
		byte[] buffer = null;

		EventDAO dao = new EventDAOImpl();
		try
		{
			Event event = dao.getEventByEventId(id + "");

			return event.getEvent_poster();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer;
	}

}