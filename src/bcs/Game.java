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

public interface Game
{
	public Date getDate();
	
	public Team getT1();

	public Team getT2();

	public Team getTwinner();
	
	public Team getTloser();

	public int getT1score();

	public int getT2score();
	
	public Team getHomeTeam();
	
	public int getScoreDifferential();

}
