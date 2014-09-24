package com.steps.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.steps.actors.Ball;

public class GameWorld {
	public static float UNIT_WIDTH = GameScreen.SCREEN_WIDTH / 30; // 6.4 meters
	public static float UNIT_HEIGHT = GameScreen.SCREEN_HEIGHT / 30;
	public static final Vector2 GRAVITY = new Vector2(1f, 1f);

	public final Stage stage;	// stage containing game actors (not GUI, but actual game elements)
	public World box2dWorld; // box2d world
	public Ball ball; // our playing character
//	private AssetManager assetManager;

	public GameWorld(AssetManager assetManager) {
//		this.assetManager = assetManager;
		box2dWorld = new World(GRAVITY, true);
		stage = new Stage(new FitViewport(UNIT_WIDTH, UNIT_HEIGHT));

		ball = new Ball(this, assetManager);

		stage.addActor(ball);

	}

	public void update(float delta) {
		// perform game logic here
		 box2dWorld.step(delta, 3, 3); // update box2d world
		 stage.act(delta); // update game stage
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
}
