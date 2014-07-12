package com.iiitb.rest.dao;

import java.sql.SQLException;
import java.util.List;

import com.iiitb.rest.model.Event;
import com.iiitb.rest.model.Transport;

public interface TransportServiceDAO
{

	public int insertData(String transport_id, Transport transport) throws SQLException;

	public List<Event> getEventsTransportBooked(String userId) throws SQLException;

	public Event getTransportData(String trackId) throws SQLException;

}
