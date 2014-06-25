package com.iiitb.rest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iiitb.rest.DBUtil.ConnectionPool;
import com.iiitb.rest.DBUtil.Queries;
import com.iiitb.rest.dao.InvoiceDAO;
//http://stackoverflow.com/questions/14897297/how-to-represent-an-image-from-database-in-json
//http://myjeeva.com/how-to-convert-image-to-string-and-string-to-image-in-java.html

public class InvoiceDAOImpl implements InvoiceDAO
{

	public int insertInvoice(String invoiceType, String invoicestatus) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement stmt;

		try
		{

			stmt = conn.prepareStatement(Queries.INVOICE_INSERT_QRY, PreparedStatement.RETURN_GENERATED_KEYS);

			int index = 0;
			stmt.setString(++index, invoiceType);
			stmt.setString(++index, invoicestatus);
			if (stmt.executeUpdate() > 0)
			{
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next())
				{
					return rs.getInt(1);

				}
			}
		}
		finally
		{
			ConnectionPool.freeConnection(conn);
		}

		return -1;
	}

}
