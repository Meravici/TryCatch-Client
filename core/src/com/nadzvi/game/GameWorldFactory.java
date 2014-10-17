package com.nadzvi.Game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.nadzvi.Game.DontTouchWalls.DontTouchWallsWorld;
import com.nadzvi.Game.GravityTest.GravityTestWorld;
import com.nadzvi.Game.Objects.BallFactory;
import com.nadzvi.Game.Objects.WallFactory;
import com.nadzvi.Utilities.assets.AssetsAPI;
import com.nadzvi.Utilities.Utils;


public class GameWorldFactory {
	public enum GameWorldType{
		GRAVITY_TEST,
		DONT_TOUCH_WALLS
	}

	public static GameWorld create(GameWorldType type, AssetsAPI assets){

		World world = new World(new Vector2(0, 0), false);
		GameWorld gameWorld = null;
        BallFactory ballFactory = new BallFactory(world,assets);
        WallFactory wallFactory = new WallFactory(world,assets);
		switch(type){
		case GRAVITY_TEST:
			gameWorld = new GravityTestWorld(Utils.GAME_WIDTH, Utils.GAME_HEIGHT, world, ballFactory, wallFactory);
			break;
		case DONT_TOUCH_WALLS:
			gameWorld = new DontTouchWallsWorld(Utils.GAME_WIDTH, Utils.GAME_HEIGHT, world, ballFactory, wallFactory);
			break;
		}
		
		return gameWorld;
	}
}
