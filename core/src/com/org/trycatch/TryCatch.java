package com.org.trycatch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.org.screens.GameScreen;

public class TryCatch extends Game {
	
	@Override
	public void create() {
		
		
		
		Screen screen = new GameScreen();
		setScreen(screen);
	}
	
}
