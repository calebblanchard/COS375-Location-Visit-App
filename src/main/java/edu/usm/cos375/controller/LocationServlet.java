package edu.usm.cos375.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usm.cos375.model.Location;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(
		name = "locationServlet",
		urlPatterns = {"/locations"},
		loadOnStartup = 1
		)

@MultipartConfig( 
		fileSizeThreshold = 5_242_880, // 5MB 
		maxFileSize = 20_971_520L, // 20MB  
		maxRequestSize = 41_943_040L // 40MB
		)
public class LocationServlet extends HttpServlet
{
	private volatile int LOCATION_ID_SEQUENCE = 1;

	private Map<Integer, Location> locationDatabase = new LinkedHashMap<>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");

		if(action == null)
			action = "list";

		switch(action)
		{
		case "create":
			this.showLocationForm(request, response);
			break;
		case "view":
			this.viewLocation(request, response);
			break;
		case "list":
		default:
			this.listAllLocations(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");

		if(action == null)
			action = "list";

		switch(action)
		{
		case "create":
			this.createLocation(request, response);
			break;
		case "list":
		default:
			response.sendRedirect("locations");
			break;
		}
	}

	private void showLocationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view/locationForm.jsp");
		dispatcher.forward(request, response);
	}

	private void viewLocation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idString = request.getParameter("locationId");
		Location location = this.getLocation(idString, response);
		if(location == null)
			return;

		request.setAttribute("locationId", idString);
		request.setAttribute("location", location);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view/viewLocation.jsp");
		dispatcher.forward(request, response);
	}

	private void listAllLocations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("locationDatabase", this.locationDatabase);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view/listLocations.jsp");
		dispatcher.forward(request, response);
	}

	private void createLocation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(!request.getParameter("name").isEmpty() 
				&& !request.getParameter("town").isEmpty() 
				&& !request.getParameter("county").isEmpty() 
				&& !request.getParameter("latitude").isEmpty()
				&& !request.getParameter("longitude").isEmpty())
		{
			Location location = new Location();
			location.setId(LOCATION_ID_SEQUENCE);
			location.setName(request.getParameter("name"));
			location.setTown(request.getParameter("town"));
			location.setCounty(request.getParameter("county"));
			location.setFieldWorkerName((String)request.getSession().getAttribute("username"));
			location.setLatitude(!request.getParameter("latitude").isEmpty() ? Double.parseDouble(request.getParameter("latitude")) : 0);
			location.setLongitude(!request.getParameter("longitude").isEmpty() ? Double.parseDouble(request.getParameter("longitude")) : 0);

			int id;
			synchronized(this)
			{
				id = this.LOCATION_ID_SEQUENCE++;
				this.locationDatabase.put(id, location);
			}

			response.sendRedirect("locations?action=view&locationId=" + id);
		}
		else
			response.sendRedirect("locations?action=create");
	}

	private Location getLocation(String idString, HttpServletResponse response) throws ServletException, IOException
	{
		if(idString == null || idString.length() == 0)
		{
			response.sendRedirect("locations");
			return null;
		}
		try
		{
			Location location = this.locationDatabase.get(Integer.parseInt(idString));
			if(location == null)
			{
				response.sendRedirect("locations");
				return null;
			}
			return location;
		}
		catch(Exception e)
		{
			response.sendRedirect("locations");
			return null;
		}
	}
}