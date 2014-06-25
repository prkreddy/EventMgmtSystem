package com.iiitb.rest.DBUtil;

public interface Queries
{

	String SERVICE_INSERT_QRY = "INSERT INTO service (service_type,date,user_event_id) VALUES (?, NOW(),?)";

	String TRANS_SERVICE_INSERT_QRY = "INSERT INTO Transport_service (transport_id,source,destination,travel_mode,departure_date,person_count,return_date,departure_time,return_time) VALUES(?,?,?,?,?,?,?,?,?)";

	String INVOICE_INSERT_QRY = "INSERT INTO Invoice(invoice_type,invoice_status,transaction_date)VALUES(?,?,NOW())";

	String INVOICE_SERVICE_INSERT_QRY = "INSERT INTO service_invoice (service_invoice_id,service_id) VALUES(?,?)";

	String GET_EVENTS_TRANSPORT_NOT_REGISTERED_QRY = "select ue.user_event_id, e.*, v.* from User u inner join user_event ue on u.user_id= ue.user_id inner join Events e on e.event_id = ue.event_id inner join Venue v on v.event_id = e.event_id where u.user_id=? and ue. user_event_id not in (select user_event_id from service s where service_type=?)";

	// String GET_EVENTS_TRANSPORT_NOT_REGISTERED_QRY =
	// "select e.*, v.* from User u inner join user_event ue on u.user_id= ue.user_id inner join Events e on e.event_id = ue.event_id inner join Venue v on v.event_id = e.event_id where u.user_id=? and ue. user_event_id not in (select user_event_id from service s where service_type='?') 	and ue.user_event_id in (select distinct uev.user_event_id from user_event_venue_ticket uevt, user_event_venue uev, Invoice i, ticket_invoice ti 	where uevt.user_event_venue_id=uev.user_event_venue_id and i.invoice_id= ti.ticket_invoice_id 	and ti.user_event_venue_ticket_id= uevt.user_event_venue_ticket_id 	and i.invoice_type='ticket' and i.invoice_status='completed')";

}
