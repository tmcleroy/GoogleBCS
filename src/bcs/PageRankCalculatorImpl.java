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

import datastructures.Graph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class PageRankCalculatorImpl implements PageRankCalculator
{
	
	private Graph G1;
	private Settings settings;
	private TeamRecordManager TRM;
	
	public PageRankCalculatorImpl(Graph theGraph, Settings theSettings)
	{
		TRM = new TeamRecordManagerImpl();
		G1 = theGraph;
		settings = theSettings;
		//get PageRanks
		PageRank gpr = new PageRankImpl(G1, settings.getDampingFactor());
		Map<String, Double> rMap = gpr.getResults();


		Collection<Team> teamCollection = theGraph.getVertices();
		Iterator<Team> teamCollectionIterator = teamCollection.iterator();
		while(teamCollectionIterator.hasNext())
		{
			Team t = teamCollectionIterator.next();
			int numWins = theGraph.getInDegree(t);
			int numLosses = theGraph.getOutDegree(t);
			
			//build the win and loss collections
			Collection<Team> winCollection = theGraph.getPredecessors(t);
			Collection<Team> lossCollection = theGraph.getSuccessors(t);

			double thePageRank = rMap.get(t.getTeamName());			
			int theBcsRank = getBCSRank(t.getTeamName());
			
			//create the TeamRecord
			TeamRecord tRec = new TeamRecordImpl(t, numWins, numLosses, winCollection, lossCollection, thePageRank, theBcsRank);
			
			//add the TeamRecord tRec to the TeamRecordManager TRM
			TRM.addTeamRecord(tRec);
		}

	}
	
	//returns a TeamRecordManager containing the records
	//of the teams calculated from Graph G1
	public TeamRecordManager getTeamRecordManager()
	{
		return TRM;
	}
	
	private int getBCSRank(String theTeam)
	{
		try {
		   		String fname = "TEXT_FILES/bcs/"+settings.getSport()+"bcs"+settings.getYear()+".txt";
		   		FileReader fstream;
				fstream = new FileReader(fname);
				BufferedReader bReader = new BufferedReader(fstream);
		   		
				String line;
		 	   	while ((line = bReader.readLine()) != null)
	 	   {
		 		String t = line.substring(0, 24).trim();
		 		String r = line.substring(24).trim();
		 		if(theTeam.equals(t))
	 		    return Integer.parseInt(r);
	 	   }
	   		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}
}
