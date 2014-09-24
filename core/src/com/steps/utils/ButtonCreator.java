package com.steps.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ButtonCreator {
	public static TextButton createButton(String text, Skin skin, ClickListener listener){
		TextButton button = new TextButton(text, skin);
		button.addListener(listener);
		button.setSize(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()*0.2f);
		return button;
	};
}
