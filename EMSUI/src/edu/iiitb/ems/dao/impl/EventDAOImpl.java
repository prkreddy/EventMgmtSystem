package edu.iiitb.ems.dao.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.iiitb.ems.dao.EventDAO;
import edu.iiitb.ems.model.Event;
import edu.iiitb.ems.util.ConnectionPool;

public class EventDAOImpl implements EventDAO
{

	@Override
	public List<Event> getEvents()
	{

		List<Event> events = new ArrayList<Event>();
		Connection conn = ConnectionPool.getConnection();
		Event event = null;
		PreparedStatement preparedStmt;
		try
		{
			preparedStmt = conn.prepareStatement("select event_id, event_name, event_poster, event_desc from Events");

			ResultSet resultSet = preparedStmt.executeQuery();
			// System.out.println(resultSet.getFetchSize());
			// System.out.println(preparedStmt);

			while (resultSet.next())
			{

				event = new Event();
				event.setEvent_id(resultSet.getInt(1));
				event.setEvent_name(resultSet.getString(2));
				InputStream eventPoster = resultSet.getBinaryStream(3);
				event.setEvent_poster(eventPoster);
				Blob blob = resultSet.getBlob(4);
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				String s = new String(bdata);
				event.setEvent_desc(s);

				events.add(event);

			}
		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(conn);

		}

		return events;
	}

	@Override
	public Event getEventImageByEventId(String eventid)
	{

		Connection conn = ConnectionPool.getConnection();
		Event event = null;
		PreparedStatement preparedStmt;
		try
		{
			preparedStmt = conn.prepareStatement("select event_id, event_name, event_poster, event_desc from Events where event_id="
					+ eventid);

			ResultSet resultSet = preparedStmt.executeQuery();
			// System.out.println(resultSet.getFetchSize());
			// System.out.println(preparedStmt);

			if (resultSet.next())
			{

				event = new Event();
				event.setEvent_id(resultSet.getInt(1));
				event.setEvent_name(resultSet.getString(2));
				InputStream eventPoster = resultSet.getBinaryStream(3);
				event.setEvent_poster(eventPoster);
				Blob blob = resultSet.getBlob(4);
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				String s = new String(bdata);
				event.setEvent_desc(s);

			}
		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(conn);

		}

		return event;
	}
}
