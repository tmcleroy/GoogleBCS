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

import java.util.Set;



public class SeasonImpl implements Season
{
	//make this a set***************
	private Set<Game> gameSet;

	//constructor
	public SeasonImpl(Set<Game> theGameList)
	{
		gameSet = theGameList;
	}

	
	
	public Set<Game> getGameSet()
	{
		return gameSet;
	}



	
	
	
	//***************************************************************************
	//***************************************************************************
	//***************************************************************************
	//***************************TESTING FUNCTIONS*******************************
	//***************************************************************************
	//***************************************************************************
	//***************************************************************************
	
/*	
	//prints info about all the games in the gameList
	//used for testing purposes
	public void printGamesInfo()
	{
		for (int i=0; i < gameList.size(); i++)
			{
				System.out.println("****\n****\n****\n****\nPrinting a Game");
				System.out.println("Address of Game Object: " + gameList.get(i));
				System.out.println("Date: " + gameList.get(i).getDate());
				System.out.println("Team1: " + gameList.get(i).getT1().getTeamName());
				System.out.println("Team1score: " + gameList.get(i).getT1score());
				System.out.println("Team2: " + gameList.get(i).getT2().getTeamName());
				System.out.println("Team2score: " + gameList.get(i).getT2score());
				System.out.println("GameWinner: " + gameList.get(i).getTwinner().getTeamName());
				System.out.println("****\n****\n****\n****");
			}
	}
*/
}
