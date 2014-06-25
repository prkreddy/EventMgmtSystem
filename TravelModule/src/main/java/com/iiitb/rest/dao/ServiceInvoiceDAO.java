package com.iiitb.rest.dao;

import java.sql.SQLException;

public interface ServiceInvoiceDAO
{
	
	public int insertData(String serviceid, String invoiceId) throws SQLException;


}
