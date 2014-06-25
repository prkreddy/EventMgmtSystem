package edu.iiitb.ems.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.iiitb.ems.util.ConnectionPool;

public class TestAction
{

	public String execute()
	{

		Connection conn = ConnectionPool.getConnection();

		try
		{
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Events");

			while (rs.next())
			{
				System.out.println("COLUMN: " + rs.getString(2));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
			ConnectionPool.freeConnection(conn);
		}

		return "success";

	}

}
