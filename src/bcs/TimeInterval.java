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

public interface TimeInterval {

	public Date getStartDate();
	
	public Date getEndDate();

	public boolean gameIsWithin(Game next);

}
