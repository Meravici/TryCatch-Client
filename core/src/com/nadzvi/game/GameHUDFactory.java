package com.nadzvi.Game;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.nadzvi.Game.GravityTest.GravityTestGUI;
import com.nadzvi.Utilities.AssetsAPI;
import com.nadzvi.Utilities.Utils;

public class GameHUDFactory {

	public static Stage create(GameWorldFactory.GameWorldType type, AssetsAPI assets){

		Stage stage = null;
		switch(type){
		case GRAVITY_TEST:
			stage = new GravityTestGUI(new FillViewport(Utils.GAME_WIDTH, Utils.GAME_HEIGHT), assets);
			break;
		case DONT_TOUCH:
			stage = null; //TODO needed implementation
			break;
		}
		
		return stage;
	}
}
