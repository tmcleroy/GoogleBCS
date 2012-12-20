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
import datastructures.DirectedMultiGraph;
import datastructures.Graph;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


public class GraphGeneratorImpl implements GraphGenerator
{
	private Set<Team> teamSet;
	private Graph graph;
	

	//constructor generates a graph from a Season and a Settings
	public GraphGeneratorImpl(Season theSeason, Settings theSettings)
	{
    	// Graph<V, E> where V is the type of the vertices 
        // and E is the type of the edges
        //Graph<Team, Integer> g = new DirectedSparseMultigraph<Team, Integer>();
            graph = new DirectedMultiGraph();
            Set<Game> theGameSet = theSeason.getGameSet();
            teamSet = new LinkedHashSet<Team>();

		

            Iterator<Game> theGameListIterator = theGameSet.iterator();
            while (theGameListIterator.hasNext())
            {
                Game g1 = theGameListIterator.next();

                if(theSettings.getTimeInterval().gameIsWithin(g1))
                {
                        //add the teams to the teamSet (collection of unique elements)
                        //add the teams as vertexes in the graph
                        //this bloc of code assures that each team is only added as one vertex
                        //even though they may have many games in which they are listed as T1 or T2
                        if (!(teamSet.contains(g1.getT1())))
                        {
                                teamSet.add(g1.getT1());
                                graph.addVertex(g1.getT1());
                        }
                        if (!(teamSet.contains(g1.getT2())))
                        {
                                teamSet.add(g1.getT2());
                                graph.addVertex(g1.getT2());
                        }

                        //This adds a directed edge going from the loser to the winner with the hash code of the game
                        //as it's unique ID
                        if(!graph.containsEdge(g1.hashCode()))
                                graph.addEdge(g1.hashCode(), g1.getTloser(), g1.getTwinner());

                    }			
		} 
	}
	
	//returns the graph generated in the constructor
	public Graph getGraph() 
	{
		return graph;
	}

}
