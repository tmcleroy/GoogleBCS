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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TeamRecordManagerImpl implements TeamRecordManager
{

	private Set<TeamRecord> TRM;
	private ArrayList<TeamRecord> orderedTRM;
	
	public TeamRecordManagerImpl()
	{
		TRM = new LinkedHashSet<TeamRecord>();
	}
	
	public void addTeamRecord(TeamRecord theTeamRecord)
	{
		TRM.add(theTeamRecord);
	}
	
	public Set<TeamRecord> getUnorderedTRM()
	{
		return TRM;
	}
	
	//an ordered (by page rank) TRM is necessary for the XML file creator
	public ArrayList<TeamRecord> getOrderedTRM()
	{
			orderedTRM = new ArrayList<TeamRecord>(TRM);
			Collections.sort(orderedTRM, new Comparator<Object>(){
				
				public int compare(Object o1, Object o2)
				{
					TeamRecord t1 = (TeamRecord) o1;
					TeamRecord t2 = (TeamRecord) o2;
					Double p1 = new Double(t1.getPageRank());
					Double p2 = new Double(t2.getPageRank());
					return p2.compareTo(p1);
				}
			});
			return orderedTRM;
	}
	
	/*
	public void printOrderedTRM()
	{
		orderedTRM = new ArrayList<TeamRecord>(TRM);
		Collections.sort(orderedTRM, new Comparator<Object>(){
			
			public int compare(Object o1, Object o2)
			{
				TeamRecord t1 = (TeamRecord) o1;
				TeamRecord t2 = (TeamRecord) o2;
				Double p1 = new Double(t1.getPageRank());
				Double p2 = new Double(t2.getPageRank());
				return p2.compareTo(p1);
			}
		});
		
		for(int i = 0; i<orderedTRM.size(); i++)
		{
			System.out.println(orderedTRM.get(i).getPageRank());
		}
	}*/
	
}
