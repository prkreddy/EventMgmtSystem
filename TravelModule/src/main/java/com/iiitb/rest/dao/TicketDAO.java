package com.iiitb.rest.dao;

import java.sql.SQLException;

import com.iiitb.rest.model.Ticket;

public interface TicketDAO
{

	public int insertTicket(Ticket ticket) throws SQLException;

}
