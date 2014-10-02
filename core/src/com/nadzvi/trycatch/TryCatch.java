package com.nadzvi.trycatch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.nadzvi.screens.SplashScreen;


public class TryCatch extends Game {
	@Override
	public void create() {
		AssetManager manager = new AssetManager();
		manager.load("Splash.png", Texture.class);
		manager.finishLoading();
		setScreen(new SplashScreen(this,manager));
	}
	
}
