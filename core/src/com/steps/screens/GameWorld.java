package com.steps.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.steps.actors.Ball;

public class GameWorld {
	private final float UNIT_WIDTH; // 6.4 meters
	private final float UNIT_HEIGHT;
	public static final Vector2 GRAVITY = new Vector2(1f, 1f);

	private final Stage stage;	// stage containing game actors (not GUI, but actual game elements)
	private World box2dWorld; // box2d world
	private Actor ball; // our playing character
//	private AssetManager assetManager;

	public GameWorld(float width, float height, AssetManager assetManager) {
//		this.assetManager = assetManager;
		UNIT_WIDTH = width / 30;
		UNIT_HEIGHT = height / 30;
		
		box2dWorld = new World(GRAVITY, true);
		stage = new Stage(new FitViewport(UNIT_WIDTH, UNIT_HEIGHT));

		ball = new Ball(box2dWorld, assetManager);

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

	public World getBox2dWorld() {
		return box2dWorld;
	}

	public Stage getStage() {
		return stage;
	}
}
