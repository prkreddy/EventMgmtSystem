package com.iiitb.rest.model;

import java.io.InputStream;

public class Event
{

	private String user_event_id;
	public String getUser_event_id()
	{
		return user_event_id;
	}

	public void setUser_event_id(String user_event_id)
	{
		this.user_event_id = user_event_id;
	}

	private int event_id;
	private String event_name;
	private String event_start_date;
	private String event_end_date;
	private InputStream event_poster;
	private String event_desc;
	private String event_time;
	private int event_duration;
	private String event_type;
	public int organiser_id;

	private Venue venue;

	public Venue getVenue()
	{
		return venue;
	}

	public void setVenue(Venue venue)
	{
		this.venue = venue;
	}

	public int getEvent_duration()
	{
		return event_duration;
	}

	public void setEvent_duration(int event_duration)
	{
		this.event_duration = event_duration;
	}

	public int getEvent_id()
	{
		return event_id;
	}

	public void setEvent_id(int event_id)
	{
		this.event_id = event_id;
	}

	public String getEvent_name()
	{
		return event_name;
	}

	public void setEvent_name(String event_name)
	{
		this.event_name = event_name;
	}

	public String getEvent_start_date()
	{
		return event_start_date;
	}

	public void setEvent_start_date(String event_start_date)
	{
		this.event_start_date = event_start_date;
	}

	public String getEvent_end_date()
	{
		return event_end_date;
	}

	public void setEvent_end_date(String event_end_date)
	{
		this.event_end_date = event_end_date;
	}

	public InputStream getEvent_poster()
	{
		return event_poster;
	}

	public void setEvent_poster(InputStream event_poster)
	{
		this.event_poster = event_poster;
	}

	public String getEvent_desc()
	{
		return event_desc;
	}

	public void setEvent_desc(String event_desc)
	{
		this.event_desc = event_desc;
	}

	public String getEvent_time()
	{
		return event_time;
	}

	public void setEvent_time(String event_time)
	{
		this.event_time = event_time;
	}

	public String getEvent_type()
	{
		return event_type;
	}

	public void setEvent_type(String event_type)
	{
		this.event_type = event_type;
	}

	public int getOrganiser_id()
	{
		return organiser_id;
	}

	public void setOrganiser_id(int organiser_id)
	{
		this.organiser_id = organiser_id;
	}

}
