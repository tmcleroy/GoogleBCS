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


package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;



import bcs.*;


public class StartMain 
{
	
       public static void main(String[] args) throws IOException, NumberFormatException, ParseException
       {
    	   //blow up if not enough args given
    	   if(args.length < 5)
    	   {
    		   System.err.println("Not enough args. Call with [sport] [year] [start date] [end date] [damping factor]");
    		   System.exit(0);
    	   }
    	   //assign the args to variables
    	   String theSport = args[0];
    	   int theYear = Integer.parseInt(args[1]);
    	   String theStartDate = args[2];
    	   String theEndDate = args[3];
    	   double theDampingFactor = Double.parseDouble(args[4])/100;
    	   //these two variables are currently unused
    	   boolean theDateMatters = false;
    	   boolean theHomeFieldMatters = false;

    	   
    	   //initialize the program with the variables created from the args
    	   Initializer theInitializer = new InitializerImpl(theSport, theYear, theStartDate, theEndDate, theDampingFactor, theDateMatters, theHomeFieldMatters);
    	   
    	   //grab a season from the initializer
    	   Season theSeason = theInitializer.getSeason();
    	   
    	   //grab a settings from the initializer
    	   Settings theSettings = theInitializer.getSettings();
    	   
    	   //generate the graph
    	   GraphGenerator theGraphGenerator = new GraphGeneratorImpl(theSeason, theSettings);
    	   
    	   //calculate pagerank, create a TeamRecord for each team and put it in the TeamRecordManager
    	   PageRankCalculator thePageRankCalculator = new PageRankCalculatorImpl(theGraphGenerator.getGraph(), theSettings);
    	   
    	   //this is the final object containing each team's record that we need to convert to a format that's readable by Jessica's web page
    	   TeamRecordManager theTeamRecordManager = thePageRankCalculator.getTeamRecordManager();
    	   
    	   //theTeamRecordManager.printOrderedTRM();
    	   
    	   //does the actual creation of the xml file
           createXML(theTeamRecordManager, theSport);
           
           
       }
       
       //creates the xml file that will be read by Jessica's script
       public static void createXML(TeamRecordManager theTeamRecordManager, String theSport)
       {

    	   try{
	    		   // Create file 
    		   	   String fname = "output.xml";
	    		   FileWriter fstream = new FileWriter(fname);
	    		   BufferedWriter out = new BufferedWriter(fstream);
	    		   ArrayList<TeamRecord> orderedTRM = theTeamRecordManager.getOrderedTRM();
	    		   Iterator<TeamRecord> i = orderedTRM.iterator();
	    		   out.write("<?xml version=\"1.0\"?>\n\n<TRM>\n");
	    		   while(i.hasNext())
	    		   {
	    			   TeamRecord t = i.next();
	    			   
	    			   //These next two for loops create the win and loss
	    			   //lists in a nice format for the web script
	    			   String wins = "";
	    			   int winCount = 0;
	    			   for(Team w:t.getWinCollection())
	    			   {
	    				   wins += w.getTeamName();
	    				   if(winCount != t.getWinCollection().size()-1)
	    					   wins += ", ";
	    				   winCount++;
	    				   if(winCount % 4 == 0) wins += "\n";  
	    			   }
	    			   
	    			   String losses = "";
	    			   int lossCount = 0;
	    			   for(Team l:t.getLossCollection())
	    			   {
	    				   losses += l.getTeamName();
	    				   if(lossCount != t.getLossCollection().size()-1)
	    					   losses += ", ";
	    				   lossCount++;
	    				   if(lossCount % 4 == 0) losses += "\n";  
	    			   }

	    			   String theTeam = t.getTeam().getTeamName();
	    			   int theNumWins = t.getNumWins();
	    			   int theNumLosses = t.getNumLosses();
	    			   //make page rank more visually pleasing
	    			   Double thePageRank = t.getPageRank()*10000;
	    			   String thePageRankStr = thePageRank.toString().substring(0, 6);
	    			   int theBcsRank = t.getBcsRank();
	    			   String theIconURL = t.getTeam().getIconURL(theSport);
	    			   if(theNumWins+theNumLosses>8)
	    			   {
		    			   String output =	"<teamRecord>\n" +
			    					   			"\t<team>" + theTeam + "</team>\n" +
			    			   					"\t<numWins>" + theNumWins + "</numWins>\n" +
			    			   					"\t<numLosses>" + theNumLosses + "</numLosses>\n" +
			    			   					"\t<pageRank>" + thePageRankStr + "</pageRank>\n" +
			    			   					"\t<bcsRank>" + theBcsRank + "</bcsRank>\n" +
			    			   					"\t<iconURL>" + theIconURL + "</iconURL>\n" +
			    			   					"\t<winCollection>" + wins + "</winCollection>\n" +
			    			   					"\t<lossCollection>" + losses + "</lossCollection>\n" +
			    			   				"</teamRecord>\n\n\n";
		    			   
		    			   //we need to do this to be xml 1.0 compliant
		    			   if(output.contains("&"))
		    				   output = output.replace("&", "&amp;");
		    			   
		    			   out.write(output);
	    			   }
	    		   }
	    		   out.write("</TRM>");
    		   //Close the output stream
    		   out.close();
    		   System.out.println("Wrote file " + fname);
    		   }
    	   		catch (Exception e)
    	   		{
    	   			System.err.println("Exception in createXML(): " + e.getMessage());
    	   		}
       }   
}