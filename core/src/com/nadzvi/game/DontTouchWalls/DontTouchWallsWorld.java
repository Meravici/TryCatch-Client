package com.nadzvi.Game.DontTouchWalls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.nadzvi.Game.Objects.Ball;
import com.nadzvi.Game.Objects.BallFactory;
import com.nadzvi.Game.GameWorld;
import com.nadzvi.Game.Objects.WallFactory;

public class DontTouchWallsWorld implements GameWorld {
	private final float UNIT_WIDTH; // 6.4 meters
	private final float UNIT_HEIGHT;
	public static final Vector2 GRAVITY = new Vector2(0f, 0f);

    private Box2DDebugRenderer debugRenderer;

	private final Stage stage; // stage containing game actors (not GUI, but
								// actual game elements)
	private World box2dWorld; // box2d world

	private float BORDER_WIDTH = 0.5f;

	BallFactory ballFactory;
	WallFactory wallFactory;

    private Ball ball;
    private Ball enemy;

	public DontTouchWallsWorld(float width, float height, World world, BallFactory ballFactory, WallFactory wallFactory) {
        world.setGravity(GRAVITY);
        UNIT_WIDTH = width / 30;
        UNIT_HEIGHT = height / 30;
        this.debugRenderer = new Box2DDebugRenderer();
        stage = new Stage(new FitViewport(UNIT_WIDTH, UNIT_HEIGHT));
        this.box2dWorld = world;
        this.ballFactory = ballFactory;
        this.wallFactory = wallFactory;
        borderWalls();
        this.ball = (Ball)ballFactory.createActor(UNIT_WIDTH * (float)Math.random(),UNIT_HEIGHT * (float)Math.random());
        this.enemy = (Ball)ballFactory.createActor(UNIT_WIDTH * (float)Math.random(),UNIT_HEIGHT * (float)Math.random());
        stage.addActor(ball);
        stage.addActor(enemy);
    }
	private void borderWalls() {
		stage.addActor(wallFactory.createActor(0, 0, BORDER_WIDTH,2 * UNIT_HEIGHT));
		stage.addActor(wallFactory.createActor(UNIT_WIDTH, 0, BORDER_WIDTH, 2 * UNIT_HEIGHT));
		stage.addActor(wallFactory.createActor(0, 0, 2 * UNIT_WIDTH, BORDER_WIDTH));
		stage.addActor(wallFactory.createActor(0, UNIT_HEIGHT, 2 * UNIT_WIDTH, BORDER_WIDTH));
	}

    private void enemyAI(){
        float ex = enemy.getBody().getPosition().x;
        float ey = enemy.getBody().getPosition().y;

        float ax = ball.getBody().getPosition().x;
        float ay = ball.getBody().getPosition().y;

        float a = ax - ex;
        float b = ay - ey;

        //double angle = Math.atan(a/b);
        float x = a/(a*a + b*b)*10000;
        float y = b/(b*b + a*a)*10000;
//        Vector2 vec = new Vector2(a*(float)Math.cos(angle), b*(float)Math.sin(angle));
        Vector2 vec = new Vector2(x,y);
        enemy.getBody().applyForceToCenter(vec, true);

    }

	public void update(float delta) {
		// perform game logic here
        enemyAI();
        ball.getBody().applyForceToCenter(Gdx.input.getAccelerometerY()*100, -Gdx.input.getAccelerometerX()*100, true);
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
