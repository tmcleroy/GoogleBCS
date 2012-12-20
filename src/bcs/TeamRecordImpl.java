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

public class TeamRecordImpl implements TeamRecord
{
	private Team team;
	private int numWins;
	private int numLosses;
	private Collection<Team> winCollection;
	private Collection<Team> lossCollection;
	private double pageRank;
	//this could be a problem now that we are letting the user
	//set whatever dates they want within the season.  That would
	//mean that the official BCS ranking is less significant
	private int bcsRank;
	
	public TeamRecordImpl(Team theTeam, int theNumWins, int theNumLosses, Collection<Team> theWinCollection, Collection<Team> theLossCollection, double thePageRank, int theBcsRank)
	{
		team = theTeam;
		numWins = theNumWins;
		numLosses = theNumLosses;
		winCollection = theWinCollection;
		lossCollection = theLossCollection;
		pageRank = thePageRank;
		bcsRank = theBcsRank;
		
	}
	
	public Team getTeam()
	{
		return team;
	}
	
	public int getNumWins()
	{
		return numWins;
	}
	
	public int getNumLosses()
	{
		return numLosses;
	}
	
	public Collection<Team> getWinCollection()
	{
		return winCollection;
	}
	
	public Collection<Team> getLossCollection()
	{
		return lossCollection;
	}
	
	public double getPageRank()
	{
		return pageRank;
	}
	
	public int getBcsRank()
	{
		return bcsRank;
	}
	
}
