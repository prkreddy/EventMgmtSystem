package com.iiitb.rest.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iiitb.rest.DBUtil.ConnectionPool;
import com.iiitb.rest.DBUtil.Queries;
import com.iiitb.rest.dao.TransportServiceDAO;
import com.iiitb.rest.model.Event;
import com.iiitb.rest.model.Transport;
import com.iiitb.rest.model.Venue;

public class TransportServiceDAOImpl implements TransportServiceDAO
{

	public int insertData(String transport_id, Transport transport) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement stmt;

		try
		{
			stmt = conn.prepareStatement(Queries.TRANS_SERVICE_INSERT_QRY, PreparedStatement.RETURN_GENERATED_KEYS);
			int index = 0;
			stmt.setString(++index, transport_id);
			stmt.setString(++index, transport.getSource());
			stmt.setString(++index, transport.getDestination());
			stmt.setString(++index, transport.getTravelmode());
			stmt.setString(++index, transport.getDepartureDate());
			stmt.setInt(++index, transport.getPassCount());
			stmt.setString(++index, transport.getReturnDate());
			stmt.setString(++index, transport.getDepartureTime());
			stmt.setString(++index, transport.getReturnTime());

			if (stmt.executeUpdate() > 0)
			{

				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next())
				{
					return rs.getInt(1);

				}
			}
		}

		finally
		{
			ConnectionPool.freeConnection(conn);
		}

		return -1;
	}

	@Override
	public List<Event> getEventsTransportBooked(String userId) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		Event event;
		Venue venue;
		Transport transport;
		List<Event> events = new ArrayList<Event>();

		PreparedStatement stmt;

		try
		{

			stmt = conn.prepareStatement(Queries.GET_REGISTERED_TRASPORT);

			stmt.setString(1, userId);

			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				event = new Event();
				venue = new Venue();
				transport = new Transport();
				int index = 0;
				event.setEvent_id(rs.getInt(++index));
				event.setEvent_name(rs.getString(++index));
				event.setEvent_start_date(rs.getString(++index));
				event.setEvent_end_date(rs.getString(++index));
				// InputStream eventPic = rs.getBinaryStream(++index);

				Blob blob1 = rs.getBlob(++index);
				byte[] bytes1 = blob1.getBytes(1, (int) blob1.length());

				event.setEvent_poster(bytes1);
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
				++index;

				transport.setTransportId(rs.getInt("transport_id"));
				transport.setSource(rs.getString("source"));
				transport.setDestination(rs.getString("destination"));
				transport.setTravelmode(rs.getString("travel_mode"));
				transport.setDepartureDate(rs.getString("departure_date"));
				transport.setPassCount(rs.getInt("person_count"));
				transport.setReturnDate(rs.getString("return_date"));
				transport.setDepartureTime(rs.getString("departure_time"));
				transport.setReturnTime(rs.getString("return_time"));

				event.setTransport(transport);
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
