package com.org.trycatch;

import com.badlogic.gdx.graphics.Texture;
import com.org.trycatchAPI.Textures;

public class TryCatchTextures implements Textures {
	private Texture[] textures;
	
	public TryCatchTextures(){
		textures = new Texture[2];
		textures[0] = new Texture("ball.png");
		textures[0] = new Texture("wall.png");
	}
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Texture getTexture(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
