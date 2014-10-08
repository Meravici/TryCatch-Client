package com.nadzvi.Game.GravityTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.nadzvi.Game.BallFactory;
import com.nadzvi.Game.GameWorld;
import com.nadzvi.Game.WallFactory;

public class GravityTestWorld implements GameWorld {
	private final float UNIT_WIDTH; // 6.4 meters
	private final float UNIT_HEIGHT;
	public static final Vector2 GRAVITY = new Vector2(1f, 1f);

    private Box2DDebugRenderer debugRenderer;

	private final Stage stage; // stage containing game actors (not GUI, but
								// actual game elements)
	private World box2dWorld; // box2d world

	private float BORDER_WIDTH = 0.5f;
	
	BallFactory ballFactory;
	WallFactory wallFactory;

	public GravityTestWorld(float width, float height, World world, BallFactory ballFactory, WallFactory wallFactory) {
		UNIT_WIDTH = width / 30;
		UNIT_HEIGHT = height / 30;
        this.debugRenderer = new Box2DDebugRenderer();
		stage = new Stage(new FitViewport(UNIT_WIDTH, UNIT_HEIGHT));
		this.box2dWorld = world;
		this.ballFactory = ballFactory;
		this.wallFactory = wallFactory;
		borderWalls();

		for (int i = 0; i < 10; i++) {
			stage.addActor(ballFactory.createActor(UNIT_WIDTH * (float)Math.random(),UNIT_HEIGHT * (float)Math.random()));
		}
		
		InputProcessor processor = new GravityTestInputProcessor(box2dWorld);
		
		Gdx.input.setInputProcessor(processor);
	}

	private void borderWalls() {
		stage.addActor(wallFactory.createActor(0, 0, BORDER_WIDTH,2 * UNIT_HEIGHT));
		stage.addActor(wallFactory.createActor(UNIT_WIDTH, 0, BORDER_WIDTH, 2 * UNIT_HEIGHT));
		stage.addActor(wallFactory.createActor(0, 0, 2 * UNIT_WIDTH, BORDER_WIDTH));
		stage.addActor(wallFactory.createActor(0, UNIT_HEIGHT, 2 * UNIT_WIDTH, BORDER_WIDTH));
	}

	public void update(float delta) {
		// perform game logic here
		box2dWorld.step(delta, 3, 3); // update box2d world
		stage.act(delta); // update game stage
	}

    @Override
    public void render() {
        debugRenderer.render(box2dWorld, stage.getCamera().combined);
        stage.draw();
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

	@Override
	public void dispose() {
		stage.dispose();
		box2dWorld.dispose();
	}
}
