package com.org.trycatch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.org.screens.GameScreen;
import com.org.trycatchAPI.GoogleInterface;

public class TryCatch extends Game {
	private GoogleInterface gInterface;
	public TryCatch(GoogleInterface gInteface){
		super();
		this.gInterface = gInteface;
	}
	
	@Override
	public void create() {
		
		
		
		Screen screen = new GameScreen(gInterface);
		setScreen(screen);
	}
	
}
