package com.iiitb.rest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iiitb.rest.DBUtil.ConnectionPool;
import com.iiitb.rest.dao.VenueDAO;
import com.iiitb.rest.model.Venue;

public class VenueDAOImpl implements VenueDAO
{

	private final String INSERT_VENUE_QRY = "INSERT INTO Venue(name,street_no,city,state,country,pincode,event_id) VALUES(?,?,?,?,?,?,?)";

	public int insertVenue(Venue venue) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement stmt;

		try
		{
			stmt = conn.prepareStatement(INSERT_VENUE_QRY, PreparedStatement.RETURN_GENERATED_KEYS);
			int index = 0;
			stmt.setString(++index, venue.getName());
			stmt.setString(++index, venue.getStreet_no());
			stmt.setString(++index, venue.getCity());

			stmt.setString(++index, venue.getState());

			stmt.setString(++index, venue.getCountry());
			stmt.setString(++index, venue.getPincode());
			stmt.setInt(++index, venue.getEvent_id());

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

}
