package com.nadzvi.game;

import com.nadzvi.game.gravityTest.GravityTestWorld;

public class GameFactory {
	public enum GameWorldType{
		GRAVITY_TEST,
		DONT_TOUCH
	}
	private float width, height;
	public GameFactory(float width, float height){
		this.width = width;
		this.height = height;
	}
	
	
	public GameWorld create(GameWorldType type){
		GameWorld gameWorld = null;
		switch(type){
		case GRAVITY_TEST:
			gameWorld = new GravityTestWorld(width, height);
			break;
		case DONT_TOUCH:
			gameWorld = null; //TODO needed implementation
			break;
		}
		
		return gameWorld;
	}
}
