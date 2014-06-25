package com.iiitb.rest.dao;

import java.sql.SQLException;

import com.iiitb.rest.model.Venue;

public interface VenueDAO
{

	public int insertVenue(Venue venue) throws SQLException;

}
