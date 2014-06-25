package com.iiitb.rest.dao.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import com.iiitb.rest.DBUtil.ConnectionPool;
import com.iiitb.rest.DBUtil.Queries;
import com.iiitb.rest.dao.EventDAO;
import com.iiitb.rest.dao.ServiceDAO;
import com.iiitb.rest.model.Event;
//http://stackoverflow.com/questions/14897297/how-to-represent-an-image-from-database-in-json
//http://myjeeva.com/how-to-convert-image-to-string-and-string-to-image-in-java.html

public class ServiceDAOImpl implements ServiceDAO
{

	private final String GET_EVENT_BY_EVENT_ID = "SELECT event_id,event_name,event_start_date,event_end_date,event_poster,event_desc,event_time,event_duration,CODE,organiser_id FROM Events, Event_Type where Events.event_type= Event_Type.id and event_id = ?";

	public int insertService(String serviceType, String user_event_id) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement stmt;

		try
		{

			stmt = conn.prepareStatement(Queries.SERVICE_INSERT_QRY, PreparedStatement.RETURN_GENERATED_KEYS);

			int index = 0;
			stmt.setString(++index, serviceType);
			stmt.setString(++index, user_event_id);

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

	// @Override
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
				InputStream eventPic = rs.getBinaryStream(++index);
				event.setEvent_poster(eventPic);
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

}
