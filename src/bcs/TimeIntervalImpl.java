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

import java.util.Date;

public class TimeIntervalImpl implements TimeInterval{

	private Date startDate;
	private Date endDate;
	
	public TimeIntervalImpl(Date d1, Date d2) {
		startDate = d1;
		endDate = d2;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public boolean gameIsWithin(Game g1) {
		Date d1 = g1.getDate();
		if(d1.before(endDate) && d1.after(startDate))
			return true;
		return false;
	}

}