package com.nadzvi.Game;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface GameWorld {

	public World getWorld();
	
	public Stage getStage();
	
	public void resize(int width, int height);
	
	public void update(float delta);

    public void render();
	
	public void dispose();
}
