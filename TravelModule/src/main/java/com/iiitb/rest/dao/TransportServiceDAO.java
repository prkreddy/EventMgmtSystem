package com.iiitb.rest.dao;

import java.sql.SQLException;

import com.iiitb.rest.model.Transport;

public interface TransportServiceDAO
{
	public int insertData(String transport_id,Transport transport) throws SQLException;

}
