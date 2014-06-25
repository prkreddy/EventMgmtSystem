package edu.iiitb.ems.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil
{

	public static String getCurrentTimeStamp()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());

	}
}
