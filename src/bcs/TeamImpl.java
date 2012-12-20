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



public class TeamImpl implements Team
{
	
	private String teamName;
	private String iconURL;

	//constructor
	public TeamImpl(String theTeamName)
	{
		teamName = theTeamName;
		//default helmet icon
		iconURL = "IMAGES/helmet.png";
	}


	public String getTeamName()
	{
		return teamName;
	}
	
	
	public String getIconURL(String theSport)
	{
		setIconURL(theSport);
		return iconURL;
	}
	
	private void setIconURL(String theSport)
	{
		try {
	   		String fname = "TEXT_FILES/icons/"+theSport+"iconFnames.txt";
	   		FileReader fstream = new FileReader(fname);
			BufferedReader bReader = new BufferedReader(fstream);
	   		
			String line;
	 	   	while ((line = bReader.readLine()) != null)
	 	   	{
		 		String t = line.substring(0, 23).trim();
		 		String r = line.substring(24).trim();
		 		if(teamName.equals(t))
		 			iconURL = "http://a.espncdn.com/i/teamlogos/ncaa/sml/trans/"+Integer.parseInt(r)+".gif";
	 	   	}
   		
			} catch (IOException e) {System.err.println("Error in setIconURL(): " + e);}
	}


	//we need these overrides for convenient comparing of teams
	//and easier printing
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamImpl other = (TeamImpl) obj;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return teamName;
	}
	
}
