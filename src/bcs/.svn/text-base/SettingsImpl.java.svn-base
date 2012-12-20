/*
 *************
 * GoogleBCS *
 *************
 *
 * Authors:
 * Tommy McLeroy, Jessica Miller
 * 
 * St. Edward's University
 * Software Engineering
 * Doctor Michael Kart
 */

package bcs;

public class SettingsImpl implements Settings 
{

	private int year;
	private String sport;
	private double dampingFactor;
	private TimeInterval timeInterval;
	private boolean dateMatters;
	private boolean homeFieldMatters;

	public SettingsImpl(int theYear, String theSport, double theDampingFactor,TimeInterval theTimeInterval,
						boolean theDateMatters, boolean theHomeFieldMatters)
	{
		year = theYear;
		sport = theSport;
		dampingFactor = theDampingFactor;
		timeInterval = theTimeInterval;
		dateMatters = theDateMatters;
		homeFieldMatters = theHomeFieldMatters;
	}
	
	public TimeInterval getTimeInterval() 
	{
		return timeInterval;
	}

	public double getDampingFactor() 
	{
		return dampingFactor;
	}

	public int getYear() 
	{
		return year;
	}
	
	public String getSport()
	{
		return sport;
	}
	
	public boolean getDateMatters() 
	{
		return dateMatters;
	}

	public boolean getHomeFieldMatters() 
	{
		return homeFieldMatters;
	}

}