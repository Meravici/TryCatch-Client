package com.nadzvi.game.gravityTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.nadzvi.game.BallFactory;
import com.nadzvi.game.GameWorld;
import com.nadzvi.game.Wall;

public class GravityTestWorld implements GameWorld {
	private final float UNIT_WIDTH; // 6.4 meters
	private final float UNIT_HEIGHT;
	public static final Vector2 GRAVITY = new Vector2(1f, 1f);

	private final Stage stage; // stage containing game actors (not GUI, but
								// actual game elements)
	private World box2dWorld; // box2d world
	// private Actor ball; // our playing character
	private Actor ball;

	private float BORDER_WIDTH = 0.5f;

	public GravityTestWorld(float width, float height) {
		UNIT_WIDTH = width / 30;
		UNIT_HEIGHT = height / 30;
		
		box2dWorld = new World(GRAVITY, true);
		stage = new Stage(new FitViewport(UNIT_WIDTH, UNIT_HEIGHT));
		BallFactory ballFactory = new BallFactory(box2dWorld, UNIT_WIDTH, UNIT_HEIGHT);
		borderWalls();

		for (int i = 0; i < 10; i++) {
			stage.addActor(ballFactory.create());
		}
		ball = ballFactory.create();
		
		stage.addActor(ball);
		InputProcessor processor = new GravityTestInputProcessor(stage, box2dWorld, UNIT_WIDTH, UNIT_HEIGHT, ballFactory);
		
		Gdx.input.setInputProcessor(processor);
	}

	private void borderWalls() {
		stage.addActor(new Wall(box2dWorld, 0, 0, BORDER_WIDTH,2 * UNIT_HEIGHT));
		stage.addActor(new Wall(box2dWorld, UNIT_WIDTH, 0, BORDER_WIDTH, 2 * UNIT_HEIGHT));
		stage.addActor(new Wall(box2dWorld, 0, 0, 2 * UNIT_WIDTH, BORDER_WIDTH));
		stage.addActor(new Wall(box2dWorld, 0, UNIT_HEIGHT, 2 * UNIT_WIDTH, BORDER_WIDTH));
	}

	public void update(float delta) {
		// perform game logic here
		box2dWorld.step(delta, 3, 3); // update box2d world
		stage.act(delta); // update game stage
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	public World getWorld() {
		return box2dWorld;
	}

	public Stage getStage() {
		return stage;
	}
}
