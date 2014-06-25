package com.iiitb.rest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iiitb.rest.DBUtil.ConnectionPool;
import com.iiitb.rest.dao.TicketDAO;
import com.iiitb.rest.model.Ticket;

public class TicketDAOImpl implements TicketDAO
{

	private final String INSERT_TICKET_QRY = "INSERT INTO Tickets(type,description,cost,ticketscount,venue_id) VALUES(?,?,?,?,?)";

	public int insertTicket(Ticket ticket) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement stmt;

		try
		{
			stmt = conn.prepareStatement(INSERT_TICKET_QRY, PreparedStatement.RETURN_GENERATED_KEYS);
			int index = 0;
			stmt.setString(++index, ticket.getType());
			stmt.setString(++index, ticket.getDescription());
			stmt.setFloat(++index, ticket.getCost());

			stmt.setInt(++index, ticket.getTicketscount());

			stmt.setInt(++index, ticket.getVenue_id());

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
