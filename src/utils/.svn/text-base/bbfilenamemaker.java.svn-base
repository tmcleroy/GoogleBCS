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

package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class bbfilenamemaker {

	//this program just makes a file containing all basketball team names
	//so we can fill it in with icon file name numbers
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Set<String> teamSet = new HashSet<String>();
			int year = 2010;
			String Outfname = "BBfnames"+year+".txt";
	 	   FileWriter Outfstream = new FileWriter(Outfname);
	 	   BufferedWriter out = new BufferedWriter(Outfstream);

	   		String fname = "BB"+year+".txt";
	   		FileReader fstream;
			fstream = new FileReader(fname);
			BufferedReader bReader = new BufferedReader(fstream);
	   		
			String line;
	 	   	while ((line = bReader.readLine()) != null)
	 	   	{
	 	   		System.out.println(line);
	 	   		String[] gameArray = line.split("__");
	 	   		if(gameArray.length > 2)
	 	   		{
	 	   		String team1 = gameArray[1];
	 	   		String team2 = gameArray[3];
	 	   		teamSet.add(team1);
	 	   		teamSet.add(team2);
	 	   		}
	 	   	}
	 	   	
	 	   	Iterator<String> i = teamSet.iterator();
	 	   	
	 	   	while(i.hasNext())
	 	   	{
	 	   		String str = i.next();
	 	   		out.write(str+"\n");
	 	   	}
	 	   	System.out.println("Wrote BBfnames file");
	 	   	out.close();
   		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
