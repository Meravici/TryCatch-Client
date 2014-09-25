package com.steps.gui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.steps.utils.ButtonCreator;

public class MenuStage extends Stage {
	Skin skin;
	Stack stack;
	public MenuStage(AssetManager assetManager, Game myGame){
		skin = assetManager.get("uiskin.json", Skin.class);
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
//		final TextButton about = ButtonCreator.createButton("About", skin, stubListener);
//		final TextButton exit = ButtonCreator.createButton("Exit", skin, stubListener);

//		button.setWidth(400f);
//		button.setHeight(50f);
//		button.setFillParent(true);
//		button.setPosition(Gdx.graphics.getWidth() / 2 - button.getWidth()/2,
//				Gdx.graphics.getHeight() / 2 - button.getHeight()/2);

		
		
		
		stack.add(quickGame);
		stack.add(settings);
		this.addActor(stack);
	}
}
