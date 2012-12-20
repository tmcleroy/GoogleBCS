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


import java.net.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

import bcs.Game;
import bcs.GameImpl;
import bcs.Team;
import bcs.TeamImpl;
import bcs.TeamRecord;

//this is the program that generates out basketball text files that we parse from
//this is necessary because it takes way too long to parse basketball from the web
//the file in it's current state works for 07-08 and 08-09 only because those files
//were formatted differently thatn the later seasons by the website author
public class BParser {
    public static void main (String[] args) throws IOException, ParseException 
    {
    	
    	//generateBBSeasonTxtFile(2010, 3790);//needs no line fixes (i think)
    	//generateBBSeasonTxtFile(2009, 3719);//needs one line fix
    	//generateBBSeasonTxtFile(2008, 3478);//needs no line fixes (i think)
    	generateBBSeasonTxtFile(2007, 2613);
    }
    	public static void generateBBSeasonTxtFile(int theYear, int outerLimit) throws IOException, ParseException
    	{
    		int year = theYear;
            String NovembersourceLine;
            String Novembercontent = "";

            
       		String fname2 = "ncaabasketballoddsarchives_Nov_"+year+".htm";
       		FileReader fstream2 = new FileReader(fname2);
            BufferedReader Novembersource = new BufferedReader(fstream2);

            // Append each new HTML line into one string. Add a tab character.
            while ((NovembersourceLine = Novembersource.readLine()) != null)
            	Novembercontent += NovembersourceLine + "\t";

            // Remove style tags & inclusive content
            Pattern Novemberstyle = Pattern.compile("<style.*?>.*?</style>");
            Matcher Novembermstyle = Novemberstyle.matcher(Novembercontent);
            while (Novembermstyle.find()) Novembercontent = Novembermstyle.replaceAll("");

            // Remove script tags & inclusive content
            Pattern Novemberscript = Pattern.compile("<script.*?>.*?</script>");
            Matcher Novembermscript = Novemberscript.matcher(Novembercontent);
            while (Novembermscript.find()) Novembercontent = Novembermscript.replaceAll("");

            // Remove primary HTML tags
            Pattern Novembertag = Pattern.compile("<.*?>");
            Matcher Novembermtag = Novembertag.matcher(Novembercontent);
            while (Novembermtag.find()) Novembercontent = Novembermtag.replaceAll("");

            // Remove comment tags & inclusive content
            Pattern Novembercomment = Pattern.compile("<!--.*?-->");
            Matcher Novembermcomment = Novembercomment.matcher(Novembercontent);
            while (Novembermcomment.find()) Novembercontent = Novembermcomment.replaceAll("");

            // Remove special characters, such as &nbsp;
            Pattern NovembersChar = Pattern.compile("&.*?;");
            Matcher NovembermsChar = NovembersChar.matcher(Novembercontent);
            while (NovembermsChar.find()) Novembercontent = NovembermsChar.replaceAll("");

            // Remove the tab characters. Replace with new line characters.
            Pattern NovembernLineChar = Pattern.compile("\t+");
            Matcher NovembermnLine = NovembernLineChar.matcher(Novembercontent);
            while (NovembermnLine.find()) Novembercontent = NovembermnLine.replaceAll("\n");

            // Print the clean content & close the Readers
            //System.out.println(content.indexOf("2H\n"));
            String NovembergoodContent = Novembercontent.substring(413);

           

         
            
            
            String goodContent = 	NovembergoodContent;
            
            

            ArrayList<String> gameList = new ArrayList<String>();
            String newGame ="";
            Reader r = new StringReader(goodContent);
            BufferedReader br = new BufferedReader(r);
            int limit;

            for(int q = 0; q < outerLimit; q++)
            {
            limit = 22;
            System.out.println("HEYHEYHEYHEY"+q+"HEYHEYHEYHEY");
            
            //handles the weird games with a tie of 0
            if((q==332 && year==2010) || (q==2745 && year==2010))
            	limit = 18;
        	  for(int i = 0; i < limit; i++)
        	  {
        		  newGame += br.readLine()+"__";
        	  }
        	  String[] newGameArray = newGame.split("__");
        	  //we need to get this date into the correct format before giving it to Game
        	  String dateStr = newGameArray[0]+year;
        	  if(dateStr == null)
        		  break;
        	  String df = "MMddyyyy";
        	  //if month is jan, feb, march, or april, we need to process
        	  //the date differently
        	  if((dateStr.length()==7 && dateStr.charAt(0)=='1')
        			  ||  (dateStr.charAt(0)=='2')
        			  ||  (dateStr.charAt(0)=='3')
        			  ||  (dateStr.charAt(0)=='4'))
        	  {
        		  //sets the year to year+1 (since we are in jan, feb, march, or april)
        		  dateStr = newGameArray[0]+(year+1);
        		  df = "Mddyyyy";
        	  }
        	  
		   		DateFormat formatter;
		   		Date date;
		   		formatter = new SimpleDateFormat(df);
		   		date = (Date)formatter.parse(dateStr);
	        	  String T1 = "TEAM 1";
	        	  String T2 = "TEAM 2";
	        	  String winner = "TIE";
	        	  String homeTeam = "NO HOME";
	        	  int T1score = 0;
	        	  int T2score = 0;
        	  
	        	  //get team names
	        	  T1 = newGameArray[3];
	        	  T2 = newGameArray[14];
        	  
        	  
        	  //weird game with no score
        	  if((q==332 && year==2010) || (q==2745 && year==2010))
        	  {
        		  T1score = 0;
        		  T2score = 0;
            	  T1 = newGameArray[3];
            	  T2 = newGameArray[12];
        	  }
        	  //else normal game
        	  else
        	  {
        		  
        		  for(int i = 0;i<22;i++)
        		  {
        			  System.out.println(newGameArray[i]);
        		  }
        		  T1score = Integer.parseInt(newGameArray[6]);
        		  T2score = Integer.parseInt(newGameArray[17]);
        	  }
        	  
        	  //determines home/visitor
        	  if(newGameArray[2].equals("H"))
        	  {
        		  homeTeam = T1;
        	  }
        	  else if(newGameArray[2].equals("V"))
        	  {
        		  homeTeam = T2;
        	  }
        	  
        	  //determines winner
        	  if(T1score > T2score)
        	  {
        		  winner = T1;
        	  }
        	  else if(T2score > T1score)
        	  {
        		  winner = T2;
        	  }
        	  gameList.add(date+"__"+T1+"__"+T1score+"__"+T2+"__"+T2score+"__"+winner+"__"+homeTeam);
        	  newGame = "";
            }

        // Create file 
   		String fname = "BB"+year+".txt";
	   FileWriter fstream = new FileWriter(fname);
	   BufferedWriter out = new BufferedWriter(fstream);

       for(int p = 0; p < outerLimit; p++)
       {
       	out.write(gameList.get(p)+"\n");
       }

   //Close the output stream
   out.close();
   System.out.println("Wrote file " + fname);
        
        
        Novembersource.close();
    }
}