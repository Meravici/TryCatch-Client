package com.org.trycatch;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.org.objects.Ball;

public class TryCatchOld extends ApplicationAdapter {
	SpriteBatch batch;
	Texture ball;
	Board board;
	Box2DDebugRenderer rend;
	OrthographicCamera cam;
	
	@Override
	public void create () {
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		rend = new Box2DDebugRenderer();
		ball = new Texture("ball.png");
		board = new Board(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		board.addBalls(new Ball(ball, 300,350), new Ball(ball,50,50));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		board.render(0, batch, rend, cam.combined);
	}
}
