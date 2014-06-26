package edu.iiitb.ems.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ems.dao.EventDAO;
import edu.iiitb.ems.dao.impl.EventDAOImpl;
import edu.iiitb.ems.model.Event;
import edu.iiitb.ems.util.ConnectionPool;

//@Namespace("/default")
//@ResultPath(value = "/")
public class ImageAction extends ActionSupport implements SessionAware
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8188116769915480525L;

	private String userId;

	private Map<String, Object> session;

	private EventDAO eventDao = new EventDAOImpl();

	// @Action(value = "/image")
	public String execute() throws SQLException, IOException
	{
		Connection connection = ConnectionPool.getConnection();
		Event event = eventDao.getEventImageByEventId(userId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/jpeg");
		InputStream in = event.getEvent_poster();
		/*
		 * if (null != picType && picType.equals("cover")) { in =
		 * user.getCurrentCoverPic(); }
		 */
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = in.read(buffer)) != -1)
		{
			out.write(buffer, 0, len);
		}
		ConnectionPool.freeConnection(connection);
		return NONE;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

}
