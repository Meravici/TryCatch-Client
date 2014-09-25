package com.steps.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {
	// this is actually my tablet resolution in landscape mode. I'm using it for
	// making the GUI pixel-exact.
	private static int SCREEN_WIDTH = 500;
	private static int SCREEN_HEIGHT = 500;

	private GameWorld world; // contains the game world's bodies and actors.
	private GameRenderer renderer; // our custom game renderer.
	private Stage stage; // stage that holds the GUI. Pixel-exact size.
	private AssetManager assetManager;

	public GameScreen(Game myGame, AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	@Override
	public final void show() {
		stage = new Stage(new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT));

		world = new GameWorld(SCREEN_WIDTH, SCREEN_HEIGHT, assetManager);
		renderer = new GameRenderer(world);
		
		// add GUI actors to stage, labels, meters, buttons etc.
		Label labelStatus = new Label("TOUCH TO START", assetManager.get(
				"uiskin.json", Skin.class));
		labelStatus.setPosition(stage.getWidth() / 2 - labelStatus.getWidth()/ 2,
								stage.getHeight() / 2 - labelStatus.getHeight() / 2);

		stage.addActor(labelStatus);
		// add other GUI elements here
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.update(delta); // update the box2d world
		stage.act(delta); // update GUI

		renderer.render(); // draw the box2d world
		stage.draw(); // draw the GUI
	}

	@Override
	public void resize(int width, int height) {
		world.resize(width, height);
		stage.getViewport().update(width, height, true);
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
