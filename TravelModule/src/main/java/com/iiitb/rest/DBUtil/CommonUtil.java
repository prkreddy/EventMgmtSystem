package com.iiitb.rest.DBUtil;


public class CommonUtil
{

	public static boolean checkEmpty(String str)
	{

		if (str != null && !("".equals(str)))
		{

			return true;
		}
		else
		{
			return false;
		}

	}

}
