package com.iiitb.rest.dao;

import java.sql.SQLException;

import com.iiitb.rest.model.Event;

public interface ServiceDAO 
{
	
	public int insertService(String serviceType, String user_event_id) throws SQLException;
	

}
