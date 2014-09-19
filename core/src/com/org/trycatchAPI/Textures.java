package com.org.trycatchAPI;

import com.badlogic.gdx.graphics.Texture;

public interface Textures {
	public static final int BALL_TEXTURE = 19001;
	public static final int WALL_TEXTURE = 19002;
	
	
	public void load();
	public Texture getTexture(int id);
}
