package com.org.trycatchAPI;

public interface GoogleInterface {

	public void Login();

	public void LogOut();

	// get if client is signed in to Google+
	public boolean getSignedIn();

	// submit a score to a leaderboard
	public void submitScore(int score);
	
	//unlock achievement
	public void unlockAchievment(int id);
	
	//increments achievement
	public void incrementAchievement(int id, int numSteps);

	// gets the scores and displays them threw googles default widget
	public void getScores();
	
	//gets achevements and displays them threw googles default widget
	public void getAchievements();
}