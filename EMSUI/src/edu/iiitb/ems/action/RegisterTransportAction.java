package edu.iiitb.ems.action;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jettison.json.JSONException;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.iiitb.ems.model.User;

public class RegisterTransportAction extends ActionSupport implements SessionAware
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

	public Map<String, Object> getSession()
	{
		return session;
	}

	public String execute()
	{
		System.out.println("************************************"+user_event_id);

		return SUCCESS;
	}

	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		this.session = arg0;

	}

}
