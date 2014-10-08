package com.nadzvi.Game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.nadzvi.Game.GravityTest.GravityTestWorld;
import com.nadzvi.Utilities.AssetsAPI;
import com.nadzvi.Utilities.Utils;


public class GameWorldFactory {
	public enum GameWorldType{
		GRAVITY_TEST,
		DONT_TOUCH
	}

	public static GameWorld create(GameWorldType type, AssetsAPI assets){

		World world = new World(new Vector2(0, 0), false);
		GameWorld gameWorld = null;
		switch(type){
		case GRAVITY_TEST:
			gameWorld = new GravityTestWorld(Utils.GAME_WIDTH, Utils.GAME_HEIGHT, world, new BallFactory(world, assets), new WallFactory(world, assets));
			break;
		case DONT_TOUCH:
			gameWorld = null; //TODO needed implementation
			break;
		}
		
		return gameWorld;
	}
}
