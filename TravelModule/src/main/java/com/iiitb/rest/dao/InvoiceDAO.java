package com.iiitb.rest.dao;

import java.sql.SQLException;

import com.iiitb.rest.model.Event;

public interface InvoiceDAO 
{
	
	public int insertInvoice(String invoiceType, String invoicestatus) throws SQLException;
	

}
