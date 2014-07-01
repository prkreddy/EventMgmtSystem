package edu.iiitb.ems.action.login;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ems.dao.UserDAO;
import edu.iiitb.ems.dao.impl.UserDAOImpl;
import edu.iiitb.ems.model.User;

public class LoginAction extends ActionSupport implements SessionAware, ServletResponseAware, ServletRequestAware
{

	private String username;

	private String pagetype;

	public String getPagetype()
	{
		return pagetype;
	}

	public void setPagetype(String pagetype)
	{
		this.pagetype = pagetype;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	private String password;
	private HttpServletResponse servletResponse;

	private HttpServletRequest servletRequest;

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	private Map<String, Object> session;

	public Map<String, Object> getSession()
	{
		return session;
	}

	UserDAO dao = new UserDAOImpl();
	User tempuser = new User();

	public String execute()
	{
		String result = "";

		User user = (User) session.get("user");

		if (user != null)
		{

			result = SUCCESS;

		}

		else
		{

			User newUser = new User(username, password);
			if (isValidUser(newUser) != null)
			{

				newUser = tempuser;
				session.put("user", newUser);

				result = SUCCESS;

			}
			else
			{
				result = INPUT;
			}

		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	private User isValidUser(User user)
	{
		tempuser = dao.getUserByUserName(user.getUsername());
		if (tempuser != null)
		{
			if (!user.getPassword().equals(tempuser.getPassword()))
			{
				addFieldError("wrong password", password);
				return null;
			}
			else
			{
				return tempuser;
			}
		}
		else
		{
			addFieldError("INVALID_USER", username);
			return tempuser;
		}

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0)
	{
		this.servletResponse = arg0;

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0)
	{
		this.servletRequest = arg0;
	}

	public Cookie getCookie(String name)
	{

		Cookie cookies[] = this.servletRequest.getCookies();
		Cookie requestedCookie = null;
		if (cookies != null)
		{
			for (Cookie current : cookies)
			{
				if (current.getName().equals(name))
				{
					requestedCookie = current;
					break;
				}
			}
		}
		return requestedCookie;

	}

}
