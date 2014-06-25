package com.iiitb.rest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iiitb.rest.DBUtil.ConnectionPool;
import com.iiitb.rest.DBUtil.Queries;
import com.iiitb.rest.dao.TransportServiceDAO;
import com.iiitb.rest.model.Transport;

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

}
