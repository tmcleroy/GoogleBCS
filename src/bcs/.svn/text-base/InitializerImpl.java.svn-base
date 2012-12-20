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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class InitializerImpl implements Initializer
{
	
	private Settings settings;
	private Season season;
	
	//constructor
	public InitializerImpl (String theSport, int theYear, String theStartDate, String theEndDate, double theDampingFactor, boolean theDateMatters, boolean theHomeFieldMatters) throws NumberFormatException, IOException, ParseException
	{
		//convert the date strings to Dates
	   	DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	   	Date startDate = (Date)formatter.parse(theStartDate);
	   	//set time of day on startDate*************************************
	   	Date endDate = (Date)formatter.parse(theEndDate);
		
	   	//get a TimeInterval
		TimeInterval theTimeInterval = new TimeIntervalImpl(startDate, endDate);
		
		//create the Settings
		settings = new SettingsImpl(theYear, theSport, theDampingFactor, theTimeInterval, theDateMatters, theHomeFieldMatters);
		
		//populate an actual Season
		if(theSport.equals("FB"))
			season = populateFBSeason(settings);
		if(theSport.equals("BB"))
			season = populateBBSeason(settings);
	}
	
	
	public Season getSeason()
	{
		return season;
	}
	
	public Settings getSettings()
	{
		return settings;
	}
	
	 //returns a football season
    private static Season populateFBSeason(Settings theSettings) throws NumberFormatException, IOException, ParseException
    {
 	   Set<Game> gameSet = getFBGameList(theSettings);

 	   Season S1 = new SeasonImpl(gameSet);

 	   return S1;
    }

    
    //returns a basketball season
    private static Season populateBBSeason(Settings theSettings) throws NumberFormatException, IOException, ParseException
    {
 	   Set<Game> gameSet = getBBGameList(theSettings);

 	   Season S1 = new SeasonImpl(gameSet);

 	   return S1;
    }



    //returns an ArrayList<Game> of all football games in a season
    private static Set<Game> getFBGameList(Settings theSettings) throws NumberFormatException, IOException, ParseException
    {
		   String fname = "TEXT_FILES/FB/FB"+theSettings.getYear()+".txt";
		   FileReader fstream = new FileReader(fname);
		   BufferedReader bReader = new BufferedReader(fstream);
		   //this is the set of games we will return
		   Set<Game> gameSet = new LinkedHashSet<Game>();
		   String line;
 	   while ((line = bReader.readLine()) != null)
 	   {
	   		//converts date from string to Date
	   		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	   		Date date = (Date)formatter.parse(line.substring(0, 10));
 	 	   		
 	   		//gets teams and their scores
 	   		Team team1 = new TeamImpl(line.substring(11, 39).trim());
 	   		Team team2 = new TeamImpl(line.substring(43,71).trim());
 	   		int team1Score = Integer.parseInt(line.substring(39,43).trim());
 	   		int team2Score = Integer.parseInt(line.substring(71, 73).trim());
 	   		
 	   		//home team is listed second according to source file creator
 	   		Team homeTeam = team2;
 	   		
 	   		//game was played elsewhere if noted after index 74
 	   		//if game was not played at either teams home stadium,
 	   		//we ignore the possible homefield advantage
 	   		if(line.length() > 74) homeTeam = new TeamImpl("NO HOME"); 	   


 	   		//determines the winner, tie by default
 	   		Team winner = new TeamImpl("TIE");
 	   		Team loser = new TeamImpl("TIE");
 	   		if(team1Score > team2Score)
 	   		{
 	   			winner = team1;
 	   			loser = team2;
 	   		}
 	   		else if(team2Score > team1Score)
 	   		{
 	   			winner = team2;
 	   			loser = team1;
 	   		}
 	   		
 	   		//creates the actual game and adds it to the set we will return
 	   		Game G1 = new GameImpl(date, team1, team2, winner, loser, team1Score, team2Score, homeTeam);
 	   		gameSet.add(G1);
 	   }
 	   //clean up before we return
 	   bReader.close();
 	   return gameSet;
    }
    
  //returns an ArrayList<Game> of all basketball games in a season
    private static Set<Game> getBBGameList(Settings theSettings) throws NumberFormatException, IOException, ParseException
    {
    	String fname = "TEXT_FILES/BB/BB"+theSettings.getYear()+".txt";
   		FileReader fstream;
		fstream = new FileReader(fname);
		BufferedReader bReader = new BufferedReader(fstream);
		Set<Game> gameSet = new LinkedHashSet<Game>();
		String line;
 	   	while ((line = bReader.readLine()) != null)
 	   	{
 	   		String[] gameArray = line.split("__");
 	   		if(gameArray.length < 6)
 	   			break;
 	   		else
 	   		{
 		   		//Dates look like this in the basketball file 
 	   			//"Sat Mar 05 00:00:00 CST 2011"
 		   		DateFormat formatter = new SimpleDateFormat("MMM dd HH:mm:ss zzz yyyy");
 		   		Date date = (Date)formatter.parse(gameArray[0].substring(4));
 	   
 	   			Team team1 = new TeamImpl(gameArray[1]);
 	   			Team team2 = new TeamImpl(gameArray[3]);
 	   			int team1Score = Integer.parseInt(gameArray[2]);
 	   			int team2Score = Integer.parseInt(gameArray[4]);
 	   			//get winner, tie by default
 	   			Team winner = new TeamImpl("TIE");
 	   			Team loser = new TeamImpl("TIE");
 	   			if(team1Score > team2Score)
 	   			{
 	   				winner = team1;
 	   				loser = team2;
 	   			}
 	   			else if(team2Score > team1Score)
 	   			{
 	   				winner = team2;
 	   				loser = team1;
 	   			}
 	   			//get home team, no home by default
 	   			Team homeTeam = new TeamImpl("NO HOME");
 	   			if(team1.getTeamName().equals(gameArray[6]))
 	   				homeTeam = team1;
 	   			else if(team2.getTeamName().equals(gameArray[6]))
 	   				homeTeam = team2;
 	   			
 	 	   		//creates the actual game and adds it to the set we will return
 	 	   		Game G1 = new GameImpl(date, team1, team2, winner, loser, team1Score, team2Score, homeTeam);
                                //System.out.println("date: "+date+" | team1: "+team1+" | team2: "+team2+" | winner: "+winner+" | loser: "+loser+" | team1score: "+team1Score+" | team2score: "+team2Score+" | homeTeam: "+homeTeam);
 	 	   		gameSet.add(G1);
 	   		}
 	   	}
    	//clean up before we return
 	   	bReader.close();
 	   	return gameSet;
    }

}//end class
