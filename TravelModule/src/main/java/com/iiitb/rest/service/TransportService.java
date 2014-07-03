package com.iiitb.rest.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.iiitb.rest.dao.EventDAO;
import com.iiitb.rest.dao.InvoiceDAO;
import com.iiitb.rest.dao.ServiceDAO;
import com.iiitb.rest.dao.ServiceInvoiceDAO;
import com.iiitb.rest.dao.TransportServiceDAO;
import com.iiitb.rest.dao.impl.EventDAOImpl;
import com.iiitb.rest.dao.impl.InvoiceDAOImpl;
import com.iiitb.rest.dao.impl.ServiceDAOImpl;
import com.iiitb.rest.dao.impl.ServiceInvoiceDAOImpl;
import com.iiitb.rest.dao.impl.TransportServiceDAOImpl;
import com.iiitb.rest.model.Event;
import com.iiitb.rest.model.Transport;

@Path("/transport")
public class TransportService
{

	@GET
	@Path("/get/eventRegistered/{userid}")
	public Response getAllEventsTransportNotBooked(@PathParam("userid") int userid) throws JSONException
	{
		System.out.println(userid);
		String output = "";

		EventDAO dao = new EventDAOImpl();

		List<Event> events;
		try
		{
			events = dao.getEventsTransportNotBooked(userid + "", "transport");

			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = null;
			for (Event event : events)
			{
				jsonObject = new JSONObject();
				jsonObject.put("user_event_id", event.getUser_event_id());
				jsonObject.put("event_name", event.getEvent_name());
				jsonObject.put("event_startdate", event.getEvent_start_date());
				jsonObject.put("event_time", event.getEvent_time());
				jsonObject.put("event_type", event.getEvent_type());
				jsonObject.put("venue_name", event.getVenue().getName() + "," + event.getVenue().getStreet_no());
				jsonArray.put(jsonObject);
			}

			output = jsonArray.toString();

			System.out.println(output);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/get/transRegistered/{userid}")
	public Response getAllRegisteredTransport(@PathParam("userid") int userid) throws JSONException
	{
		System.out.println(userid);
		String output = "";

		TransportServiceDAO dao = new TransportServiceDAOImpl();
		List<Event> events;
		try
		{
			events = dao.getEventsTransportBooked(userid + "");

			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = null;
			for (Event event : events)
			{
				jsonObject = new JSONObject();
				jsonObject.put("serviceId", event.getTransport().getTransportId());
				jsonObject.put("event_name", event.getEvent_name());
				jsonObject.put("venue_name", event.getVenue().getName() + "," + event.getVenue().getStreet_no());
				jsonObject.put("source", event.getTransport().getSource());
				jsonObject.put("destination", event.getTransport().getDestination());
				jsonObject.put("passengercount", event.getTransport().getPassCount());
				jsonArray.put(jsonObject);
			}

			output = jsonArray.toString();

			System.out.println(output);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.status(200).entity(output).build();

	}

	@POST
	@Path("/post/insert")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertTransportService(Transport transport) throws Exception
	{

		System.out.println(transport.getSource());

		int service_id = -1, invoice_id = -1;

		boolean status = false;
		int status_code = -1;
		JSONObject jsonObject = new JSONObject();

		String returnString = "";

		try
		{

			ServiceDAO dao = new ServiceDAOImpl();
			service_id = dao.insertService("transport", transport.getUser_event());

			if (service_id == -1)
			{
				status_code = 500;
				returnString = "Error in inserting data to ServiceTable";
				status = true;
			}
			else
			{

				TransportServiceDAO transdao = new TransportServiceDAOImpl();
				if (transdao.insertData(service_id + "", transport) > 0)
				{

					InvoiceDAO invoiceDAO = new InvoiceDAOImpl();
					invoice_id = invoiceDAO.insertInvoice("service", "pending");

					if (invoice_id == -1)
					{

						status_code = 500;
						returnString = "Error in inserting data to Service";
						status = true;
					}
					else
					{

						ServiceInvoiceDAO serviceInvoiceDAO = new ServiceInvoiceDAOImpl();
						serviceInvoiceDAO.insertData(service_id + "", invoice_id + "");
						status = false;
						
						/*SendingEmail email = new SendingEmail();
						email.sendmail("prk.reddy96@gmail.com", "mynewpassword");*/
					}

				}
				else
				{

					status_code = 500;
					returnString = "Error in inserting data to ServiceInvoice";
					status = true;

				}

			}

			if (!status)
			{
				System.out.println("SUCCESS");
				jsonObject.put("MSG", "Item has been entered successfully");
				jsonObject.put("service_id", service_id);
				jsonObject.put("invoice_id", invoice_id);

				status_code = 200;
				returnString = jsonObject.toString();
			}

		}
		catch (SQLException e)
		{
			System.out.println("SQL SUCCESS");
			e.printStackTrace();
			status_code = 500;
			returnString = "Server was not able to process your request";

		}

		return Response.status(status_code).entity(returnString).build();
	}
}