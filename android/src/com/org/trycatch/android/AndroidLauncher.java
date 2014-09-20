package com.org.trycatch.android;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import com.org.trycatch.TryCatch;
import com.org.trycatchAPI.GoogleInterface;

public class AndroidLauncher extends AndroidApplication implements
		GameHelperListener, GoogleInterface {

	private GameHelper aHelper;


	public AndroidLauncher() {


	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		aHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
		aHelper.enableDebugLog(true);
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		aHelper.setup(this);
		initialize(new TryCatch(this), cfg);
	}

	@Override
	public void onStart() {
		super.onStart();
		aHelper.onStart(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		aHelper.onStop();
	}
	
	@Override
	public void onActivityResult(int request, int response, Intent data) {
	super.onActivityResult(request, response, data);
	aHelper.onActivityResult(request, response, data);
	}

	@Override
	public void Login() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				aHelper.beginUserInitiatedSignIn();
			}
		});

	}

	@Override
	public void LogOut() {
		aHelper.signOut();

	}

	@Override
	public boolean getSignedIn() {
		return aHelper.isSignedIn();
	}

	@Override
	public void submitScore(int score) {
		Games.Leaderboards.submitScore(aHelper.getApiClient(),
				getString(R.string.leaderBoardID), score);
	}

	@Override
	public void getScores() {
		startActivityForResult(Games.Leaderboards.getLeaderboardIntent(
				aHelper.getApiClient(), getString(R.string.leaderBoardID)), 105);//dafuck is 105????
	}

	@Override
	public void onSignInFailed() {
		System.out.println("Sign in failed");
	}

	@Override
	public void onSignInSucceeded() {
		System.out.println("Sign in successed");
	}

	@Override
	public void unlockAchievment(int id) {
		Games.Achievements.unlock(aHelper.getApiClient(), getString(id));
	}

	@Override
	public void getAchievements() {
		startActivityForResult(Games.Achievements.getAchievementsIntent(aHelper.getApiClient()), 105);	//again this fucking 105
	}

	@Override
	public void incrementAchievement(int id, int numSteps) {
		Games.Achievements.increment(aHelper.getApiClient(), getString(id), numSteps);
	}
}