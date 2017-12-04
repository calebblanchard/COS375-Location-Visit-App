package edu.usm.cos375.model;

public class Location
{
	private Long id;
	private String name;
	private String town;
	private String county;
	private double latitude;
	private double longitude;
	private String fieldWorkerName;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

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
	
	public String getFieldWorkerName()
	{
		return fieldWorkerName;
	}

	public void setFieldWorkerName(String fieldWorkerName)
	{
		this.fieldWorkerName = fieldWorkerName;
	}
}
