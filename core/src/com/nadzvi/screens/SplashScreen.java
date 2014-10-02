package com.nadzvi.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class SplashScreen implements Screen {
	private Batch batch;
	private Game myGame;
	private long startTime;
	private long duration = 5000l;
	private Texture splash; // #4
	private AssetManager manager;
	public SplashScreen(Game myGame, AssetManager manager) {
		this.myGame = myGame;
		this.manager = manager;
		splash = manager.get("Splash.png");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(210/255f, 210/255f, 210/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(splash, Gdx.graphics.getWidth()/2-splash.getWidth()/2, Gdx.graphics.getHeight()/2 - splash.getHeight()/2);
		batch.end();
		if(TimeUtils.millis()>startTime + duration || Gdx.input.justTouched())
			myGame.setScreen(new LoadingScreen(myGame, manager));
			
	}

	@Override
	public void resize(int width, int height) {
		batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
	}

	@Override
	public void show() {
		System.out.println("Current Screen: Splash");
		startTime = TimeUtils.millis();
		batch = new SpriteBatch();
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
//		manager.unload("Splash.png");
		batch.dispose();

	}

}
