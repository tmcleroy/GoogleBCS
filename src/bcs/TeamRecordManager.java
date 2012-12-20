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
import java.util.Set;

public interface TeamRecordManager 
{

	public void addTeamRecord(TeamRecord theTeamRecord);
	
	public Set<TeamRecord> getUnorderedTRM();

	//an ordered (by page rank) TRM is necessary for the XML file creator
	public ArrayList<TeamRecord> getOrderedTRM();
	
}
