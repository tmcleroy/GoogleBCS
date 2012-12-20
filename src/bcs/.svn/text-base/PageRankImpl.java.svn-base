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
import java.util.HashMap;
import java.util.Map;


public class PageRankImpl implements PageRank
{	 
	 
	    private Graph graph;
	    private double dampingFactor = 0.85;
	    private double epsilon = 0.001;
	    private double[] pageranks;
	    private String[] teams;
	    private Map<String, Double> results;
	    

	    public PageRankImpl(Graph g, double df) 
	    {
	    	graph = g;
	    	dampingFactor = df;
	    	execute();
	    }
	    
	    public Map<String, Double> getResults()
	    {
	    	results = new HashMap<String, Double>();
	    	for(int i=0; i<teams.length; i++)
	    	{
	    		results.put(teams[i], (Double)pageranks[i]);
	    	}
	    	return results;
	    }


	    private void execute()
	    {
	        int N = graph.getVertexCount();
	        teams = new String[N];
	        pageranks = new double[N];
	        double[] temp = new double[N];
	        HashMap<Team, Integer> indicies = new HashMap<Team, Integer>();
	        int index = 0;

	        double[] weights = null;


	        for (Object o : graph.getVertices())
	        {
	        	Team s = (Team) o;
	            indicies.put(s, index);
	            teams[index] = s.getTeamName();
	            pageranks[index] = 1.0f / N;
	            index++;
	        }

	        while (true) 
	        {
	            double r = 0;
	            for (Object o : graph.getVertices())
	            {
	            	Team s = (Team) o;
	                int s_index = indicies.get(s);
	                boolean out = (graph.getOutDegree(s) > 0);

	                if(out) 
	                    r += (1.0 - dampingFactor) * (pageranks[s_index] / N);
	                else 
	                    r += (pageranks[s_index] / N);
	            }

	            boolean done = true;
	            
	            for (Object o : graph.getVertices()) 
	            {
	            	Team s = (Team) o;
	                int s_index = indicies.get(s);
	                temp[s_index] = r;

	                for (Object oEdge : graph.getInEdges(s)) 
	                {
                            Integer edge = (Integer)oEdge;
	                    Team neighbor = (Team) graph.getSource(edge);
	                    int neigh_index = indicies.get(neighbor);
	                    int normalize = ((Graph) graph).getOutDegree(neighbor);

	                    temp[s_index] += dampingFactor * (pageranks[neigh_index] / normalize);
	                }

	                if ((temp[s_index] - pageranks[s_index]) / pageranks[s_index] >= epsilon) 
	                {
	                    done = false;
	                }

	            }
	            pageranks = temp;
	            temp = new double[N];
	            if (done) break;
	        }
	    }
	}
