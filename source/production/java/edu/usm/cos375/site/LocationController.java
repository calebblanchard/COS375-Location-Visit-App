package edu.usm.cos375.site;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import edu.usm.cos375.model.Location;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("location")
public class LocationController
{
	private static final Logger log = LogManager.getLogger();

	private volatile long LOCATION_ID_SEQUENCE = 1;

	private Map<Long, Location> locationDatabase = new LinkedHashMap<>();

	@RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
	public String list(Map<String, Object> model)
	{
		log.debug("Listing locations.");
		model.put("locationDatabase", this.locationDatabase);

		return "location/list";
	}

	@RequestMapping(value = "view/{locationId}", method = RequestMethod.GET)
	public ModelAndView view(Map<String, Object> model,
			@PathVariable("locationId") long locationId)
	{
		Location location = this.locationDatabase.get(locationId);
		if(location == null)
			return this.getListRedirectModelAndView();
		model.put("locationId", Long.toString(locationId));
		model.put("location", location);
		return new ModelAndView("location/view");
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Map<String, Object> model)
	{
		model.put("locationForm", new Form());
		return "location/create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(Map<String, Object> model, HttpSession session, Form form) throws IOException
	{
		model.put("invalidLocation", true);
		
		if(form.getName().isEmpty() || form.getName() == null
				|| form.getTown().isEmpty() || form.getTown() == null 
				|| form.getCounty().isEmpty() || form.getCounty() == null)
		{
			model.put("invalidLocation", true);
	        model.put("locationForm", form);
	        return this.getCreateLocationRedirect();
		}
		else
		{
			Location location = new Location();
			location.setId(this.getNextLocationId());
			location.setName(form.getName());
			location.setTown(form.getTown());
			location.setCounty(form.getCounty());
			location.setLatitude(form.getLatitude());
			location.setLongitude(form.getLongitude());
			location.setFieldWorkerName((String) session.getAttribute("username"));

			this.locationDatabase.put(location.getId(), location);
			model.put("invalidLocation", false);
			
			return new ModelAndView(new RedirectView("/location/view/" + location.getId(), true, false));
		}
	}

	private ModelAndView getCreateLocationRedirect()
    {
        return new ModelAndView(new RedirectView("/location/create", true, false));
    }
	
	private ModelAndView getListRedirectModelAndView()
	{
		return new ModelAndView(this.getListRedirectView());
	}

	private View getListRedirectView()
	{
		return new RedirectView("/location/list", true, false);
	}

	private synchronized long getNextLocationId()
	{
		return this.LOCATION_ID_SEQUENCE++;
	}

	public static class Form
	{
		private String name;
		private String town;
		private String county;
		private double latitude;
		private double longitude;

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public String getTown()
		{
			return town;
		}

		public void setTown(String town)
		{
			this.town = town;
		}
		public String getCounty()
		{
			return county;
		}

		public void setCounty(String county)
		{
			this.county = county;
		}

		public double getLatitude()
		{
			return latitude;
		}

		public void setLatitude(double latitude)
		{
			this.latitude = latitude;
		}

		public double getLongitude()
		{
			return longitude;
		}

		public void setLongitude(double longitude)
		{
			this.longitude = longitude;
		}
	}
}
