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
package datastructures;

import bcs.Team;
import java.util.Collection;


public interface Graph
{
    
    public void addVertex(Team theTeam);
	
	public void addEdge(int id, Team theLoser, Team theWinner);

	public int getOutDegree(Team theTeam);

	public int getInDegree(Team theTeam);
	
	public Collection<Team> getVertices();
	
	public int getVertexCount();
	
	public Collection<Integer> getInEdges(Team theTeam);
	
	public Team getSource(Integer theEdge);
	
	public Collection<Team> getPredecessors(Team theTeam);
	
	public Collection<Team> getSuccessors(Team theTeam);
        
        public boolean containsEdge(int ID);
    
}
