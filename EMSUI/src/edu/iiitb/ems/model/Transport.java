package edu.iiitb.ems.model;

public class Transport
{
	private String transportId;

	private String travelmode;

	

	public String getTransportId()
	{
		return transportId;
	}

	public void setTransportId(String transportId)
	{
		this.transportId = transportId;
	}

	private String travel_type;
	private String user_event;
	private String source;
	private String destination;
	private String departureDate;
	private String departureTime;
	private String returnDate;
	private String returnTime;
	private int passCount;

	public String getTravelmode()
	{
		return travelmode;
	}

	public void setTravelmode(String travelmode)
	{
		this.travelmode = travelmode;
	}

	public String getTravel_type()
	{
		return travel_type;
	}

	public void setTravel_type(String travel_type)
	{
		this.travel_type = travel_type;
	}

	public String getUser_event()
	{
		return user_event;
	}

	public void setUser_event(String user_event)
	{
		this.user_event = user_event;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getDestination()
	{
		return destination;
	}

	public void setDestination(String destination)
	{
		this.destination = destination;
	}

	public String getDepartureDate()
	{
		return departureDate;
	}

	public void setDepartureDate(String departureDate)
	{
		this.departureDate = departureDate;
	}

	public String getDepartureTime()
	{
		return departureTime;
	}

	public void setDepartureTime(String departureTime)
	{
		this.departureTime = departureTime;
	}

	public String getReturnDate()
	{
		return returnDate;
	}

	public void setReturnDate(String returnDate)
	{
		this.returnDate = returnDate;
	}

	public String getReturnTime()
	{
		return returnTime;
	}

	public void setReturnTime(String returnTime)
	{
		this.returnTime = returnTime;
	}

	public int getPassCount()
	{
		return passCount;
	}

	public void setPassCount(int passCount)
	{
		this.passCount = passCount;
	}

}
