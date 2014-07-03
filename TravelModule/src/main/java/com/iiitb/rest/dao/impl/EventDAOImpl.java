package com.iiitb.rest.dao.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.iiitb.rest.DBUtil.ConnectionPool;
import com.iiitb.rest.DBUtil.Queries;
import com.iiitb.rest.dao.EventDAO;
import com.iiitb.rest.model.Event;
import com.iiitb.rest.model.Venue;
//http://stackoverflow.com/questions/14897297/how-to-represent-an-image-from-database-in-json
//http://myjeeva.com/how-to-convert-image-to-string-and-string-to-image-in-java.html

public class EventDAOImpl implements EventDAO
{

	private final String INSERT_EVENT_QRY = "INSERT INTO Events (event_name,event_start_date,event_end_date,event_desc,event_time,event_duration,event_type,organiser_id) "
			+ "VALUES (?,?,?,?,?,?,(SELECT ID FROM Event_Type WHERE CODE=?),?)";

	private final String GET_EVENT_BY_EVENT_ID = "SELECT event_id,event_name,event_start_date,event_end_date,event_poster,event_desc,event_time,event_duration,CODE,organiser_id FROM Events, Event_Type where Events.event_type= Event_Type.id and event_id = ?";

	public int insertEvent(Event event) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement stmt;

		try
		{

			stmt = conn.prepareStatement(INSERT_EVENT_QRY, PreparedStatement.RETURN_GENERATED_KEYS);

			int index = 0;
			stmt.setString(++index, event.getEvent_name());
			stmt.setString(++index, event.getEvent_start_date());
			stmt.setString(++index, event.getEvent_end_date());
			Blob blob = null;
			blob = new SerialBlob(event.getEvent_desc().getBytes());
			stmt.setBlob(++index, blob);

			stmt.setString(++index, event.getEvent_time());

			stmt.setInt(++index, event.getEvent_duration());
			stmt.setString(++index, event.getEvent_type());
			stmt.setInt(++index, event.getOrganiser_id());

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
			{
				return rs.getInt(1);

			}
		}

		finally
		{
			ConnectionPool.freeConnection(conn);
		}

		return -1;
	}

	@Override
	public Event getEventByEventId(String id) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		Event event;

		PreparedStatement stmt;

		try
		{
			int index = 0;

			stmt = conn.prepareStatement(GET_EVENT_BY_EVENT_ID);

			stmt.setString(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next())
			{
				event = new Event();
				event.setEvent_id(rs.getInt(++index));
				event.setEvent_name(rs.getString(++index));
				event.setEvent_start_date(rs.getString(++index));
				event.setEvent_end_date(rs.getString(++index));
				// InputStream eventPic = rs.getBinaryStream(++index);

				Blob blob1 = rs.getBlob(++index);
				byte[] bdata1 = blob1.getBytes(1, (int) blob1.length());

				event.setEvent_poster(bdata1);
				Blob blob = rs.getBlob(++index);
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				String s = new String(bdata);
				event.setEvent_desc(s);
				event.setEvent_time(rs.getString(++index));
				event.setEvent_duration(rs.getInt(++index));
				event.setEvent_type(rs.getString(++index));
				event.setOrganiser_id(rs.getInt(++index));

				return event;

			}
		}

		finally
		{
			ConnectionPool.freeConnection(conn);
		}

		return null;
	}

	public List<Event> getEventsTransportNotBooked(String userId, String serviceType) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		Event event;
		Venue venue;
		List<Event> events = new ArrayList<Event>();

		PreparedStatement stmt;

		try
		{

			stmt = conn.prepareStatement(Queries.GET_EVENTS_TRANSPORT_NOT_REGISTERED_QRY);

			stmt.setString(1, userId);
			stmt.setString(2, serviceType);

			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				event = new Event();
				venue = new Venue();
				int index = 0;
				event.setUser_event_id(rs.getString(++index));
				event.setEvent_id(rs.getInt(++index));
				event.setEvent_name(rs.getString(++index));
				event.setEvent_start_date(rs.getString(++index));
				event.setEvent_end_date(rs.getString(++index));
				InputStream eventPic = rs.getBinaryStream(++index);
				// event.setEvent_poster(eventPic);
				Blob blob = rs.getBlob(++index);
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				String s = new String(bdata);
				event.setEvent_desc(s);
				event.setEvent_time(rs.getString(++index));
				event.setEvent_duration(rs.getInt(++index));
				event.setEvent_type(rs.getString(++index));
				event.setOrganiser_id(rs.getInt(++index));
				++index;
				venue.setName(rs.getString(++index));
				venue.setStreet_no(rs.getString(++index));
				venue.setCity(rs.getString(++index));
				venue.setState(rs.getString(++index));
				venue.setCountry(rs.getString(++index));
				venue.setPincode(rs.getString(++index));

				event.setVenue(venue);

				events.add(event);

			}
		}

		finally
		{
			ConnectionPool.freeConnection(conn);
		}

		System.out.println("Events size:" + events.size());
		return events;
	}

}
