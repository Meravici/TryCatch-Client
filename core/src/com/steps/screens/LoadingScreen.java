package com.steps.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class LoadingScreen implements Screen {
	private Game myGame;
	private AssetManager assetManager;
	private Batch batch;

	private Texture splash;
	private BitmapFont font;

	public LoadingScreen(Game myGame, AssetManager assetManager) {

		this.myGame = myGame;
		this.batch = new SpriteBatch();
		this.assetManager = assetManager;
		this.splash = assetManager.get("Splash.png");
		this.font = new BitmapFont();
		font.setScale(2);
		font.setColor(Color.BLACK);
	}

	@Override
	public void render(float delta) {
		if (assetManager.update()) {
			myGame.setScreen(new GameScreen(myGame, assetManager));
		} else {
			Gdx.gl.glClearColor(210 / 255f, 210 / 255f, 210 / 255f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(splash, Gdx.graphics.getWidth() / 2 - splash.getWidth() / 2, Gdx.graphics.getHeight() / 2 - splash.getHeight() / 2);
			
			int progress = (int) (assetManager.getProgress() * 100);
			String text = "Loading " + progress + "%";
			TextBounds fontBounds = font.getBounds(text);
			float fontWidth = fontBounds.width;
			float fontHeight = fontBounds.height;
			
			font.draw(batch, text, Gdx.graphics.getWidth() / 2 - fontWidth / 2, Gdx.graphics.getHeight() - fontHeight * 2);

			batch.end();
		}
	}

	@Override
	public void resize(int width, int height) {
		// Will never happen

	}

	@Override
	public void show() {
		System.out.println("Current Screen: Loading");
		// TODO Auto-generated method stub
		assetManager.load("ball.png", Texture.class);
		assetManager.load("uiskin.json", Skin.class);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
