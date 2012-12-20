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

import java.util.Collection;

public interface TeamRecord 
{

	public Team getTeam();
	
	
	public int getNumWins();

	
	public int getNumLosses();
	
	
	public Collection<Team> getWinCollection();
	
	
	public Collection<Team> getLossCollection();

	
	public double getPageRank();

	
	public int getBcsRank();

	
}
