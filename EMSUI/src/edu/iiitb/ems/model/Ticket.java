package edu.iiitb.ems.model;

public class Ticket
{
	private String type;
	private String description;
	private float cost;
	private int ticketscount;
	private int venue_id;

	public String getType()
	{
		return type;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public float getCost()
	{
		return cost;
	}

	public void setCost(float cost)
	{
		this.cost = cost;
	}

	public int getTicketscount()
	{
		return ticketscount;
	}

	public void setTicketscount(int ticketscount)
	{
		this.ticketscount = ticketscount;
	}

	

	public int getVenue_id()
	{
		return venue_id;
	}

	public void setVenue_id(int venue_id)
	{
		this.venue_id = venue_id;
	}

}
