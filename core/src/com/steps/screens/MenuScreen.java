package com.steps.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.steps.utils.ButtonCreator;

public class MenuScreen implements Screen {
	private Game myGame;
	private Skin skin;
	private Stage stage;
	private Stack stack;

	public MenuScreen(Game myGame, AssetManager manager) {
		this.myGame = myGame;
		
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage();
		stack = new Stack();
		stack.setWidth(Gdx.graphics.getWidth()*0.9f);
		stack.setHeight(Gdx.graphics.getHeight()*0.9f);
//		stack.setFillParent(true);
		ClickListener stubListener = new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				((TextButton)event.getListenerActor()).setText("You clicked the button");
			}
		};
		
		final TextButton quickGame = ButtonCreator.createButton("Quick Game", skin, stubListener);
		final TextButton settings = ButtonCreator.createButton("Settings", skin, stubListener);
		final TextButton about = ButtonCreator.createButton("About", skin, stubListener);
		final TextButton exit = ButtonCreator.createButton("Exit", skin, stubListener);

//		button.setWidth(400f);
//		button.setHeight(50f);
//		button.setFillParent(true);
//		button.setPosition(Gdx.graphics.getWidth() / 2 - button.getWidth()/2,
//				Gdx.graphics.getHeight() / 2 - button.getHeight()/2);

		
		
		
		stack.add(quickGame);
		stack.add(settings);
		stage.addActor(stack);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

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
	}
}
