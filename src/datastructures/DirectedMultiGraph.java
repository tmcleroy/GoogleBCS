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

import bcs.*;
import java.util.*;

class Edge
{
    private int id;
    private Team team;
    public Edge(int ID, Team t2)
    {
        id = ID;
        team = t2;
    }
    public int getID() { return id; }
    public Team getTeam() { return team; }
}

public class DirectedMultiGraph implements Graph
{
    private Map<Team, ArrayList<Edge>> map;
    
    public DirectedMultiGraph()
    {   
        map = new HashMap<Team, ArrayList<Edge>>();
    }
 
    public void addVertex(Team t)
    {
        if(!map.containsKey(t))
        {
            ArrayList<Edge> emptyList = new ArrayList<Edge>();
            map.put(t, emptyList);
        }
    }
    
    public void addEdge(int id, Team t1, Team t2)
    {
        if(map.get(t1) == null)
            addVertex(t1);
        ArrayList<Edge> curList = map.get(t1);
        
        curList.add(new Edge(id, t2));
                
        map.put(t1, curList);
    }
    
    public int getOutDegree(Team t1)
    {
        return map.get(t1).size();
    }

    public int getInDegree(Team t1)
    {
        int inDegree = 0;
        
        for(Team t : map.keySet())
        {
            for(Edge e : map.get(t))
            {
                if(e.getTeam().equals(t1))
                    inDegree++;
            }
        }   
        return inDegree;
    }

    public Collection<Team> getVertices()
    {
        return (Collection<Team>)map.keySet();
    }

    public int getVertexCount()
    {
        return map.size();
    }

    public Collection<Integer> getInEdges(Team t1)
    {
        Collection<Integer> inEdges = new ArrayList<Integer>();

        for(Team t : map.keySet())
        {
            for(Edge e : map.get(t))
            {
                if(e.getTeam().equals(t1))
                    inEdges.add(e.getID());
            }
        }
        return inEdges;
    }

    public Team getSource(Integer theEdge)
    {
        Team q = new TeamImpl("NO SOURCE");
        
        for(Team t : map.keySet())
        {
            for(Edge e : map.get(t))
            {
                if(e.getID() == (theEdge))
                    q = t;
            }
        }   
        return q;
    }

    public Collection<Team> getPredecessors(Team t1)
    {
        ArrayList<Team> preds = new ArrayList<Team>();
        
        for(Team t : map.keySet())
        {
            for(Edge e : map.get(t))
            {
                if(e.getTeam().equals(t1))
                    preds.add(t);
            }
        }   
        return preds;
    }

    public Collection<Team> getSuccessors(Team t1)
    {
        Collection<Team> succ = new ArrayList<Team>();
        for(Edge e : map.get(t1))
        {
            succ.add(e.getTeam());
        }
        return succ;
    }
    
    public boolean containsEdge(int ID)
    {
        for(Team t : map.keySet())
        {
            for(Edge e : map.get(t))
            {
                if(e.getID() == ID)
                    return true;
            }
        }
        return false;
    }

}
