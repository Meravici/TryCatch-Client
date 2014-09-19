package com.org.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public interface TCObject {
	
	public void createBody(World world);
	public void draw(SpriteBatch batch);
}
