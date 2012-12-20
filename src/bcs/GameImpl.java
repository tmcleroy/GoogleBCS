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

import java.util.Date;

import bcs.Team;

public class GameImpl implements Game
{
	private Date date;
	private Team T1;
	private Team T2;
	private Team Twinner;
	private Team Tloser;
	private Team homeTeam;
	private int T1score;
	private int T2score;
	private int scoreDifferential;
	
	//constructor
	public GameImpl(Date theDate, Team theT1, Team theT2, Team theTwinner, Team theTloser, int theT1score, int theT2score, Team theHomeTeam)
	{
		date = theDate;
		T1 = theT1;
		T2 = theT2;
		Twinner = theTwinner;
		Tloser = theTloser;
		T1score = theT1score;
		T2score = theT2score;
		homeTeam = theHomeTeam;
		if(T1score > T2score)
			scoreDifferential = T1score-T2score;
		if(T2score > T1score)
			scoreDifferential = T2score-T1score;
		else
			scoreDifferential = 0;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public Team getT1()
	{
		return T1;
	}

	public Team getT2()
	{
		return T2;
	}
	
	public Team getTwinner()
	{
		return Twinner;
	}
	
	public Team getTloser()
	{
		return Tloser;
	}
	
	public int getT1score()
	{
		return T1score;
	}
	
	public int getT2score()
	{
		return T2score;
	}
	
	public Team getHomeTeam()
	{
		return homeTeam;
	}
	
	public int getScoreDifferential()
	{
		return scoreDifferential;
	}
}
