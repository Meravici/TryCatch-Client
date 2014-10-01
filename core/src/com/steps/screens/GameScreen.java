package com.steps.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.steps.game.GameRenderer;
import com.steps.game.GameWorld;
import com.steps.gui.HUDStage;

public class GameScreen implements Screen {
	// this is actually my tablet resolution in landscape mode. I'm using it for
	// making the GUI pixel-exact.
	private static int SCREEN_WIDTH = 1280;
	private static int SCREEN_HEIGHT = 720;

	private GameWorld world; // contains the game world's bodies and actors.
	private GameRenderer renderer; // our custom game renderer.
	private Stage HUD; // stage that holds the GUI. Pixel-exact size.
	private AssetManager assetManager;

	public GameScreen(Game myGame, AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	@Override
	public final void show() {
		HUD = new HUDStage(new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT), assetManager);

		world = new GameWorld(SCREEN_WIDTH, SCREEN_HEIGHT, assetManager);
		renderer = new GameRenderer(world);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.update(delta); // update the box2d world
		HUD.act(delta); // update GUI

		renderer.render(); // draw the box2d world
		HUD.draw(); // draw the GUI
	}

	@Override
	public void resize(int width, int height) {
		world.resize(width, height);
		HUD.getViewport().update(width, height, true);
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
