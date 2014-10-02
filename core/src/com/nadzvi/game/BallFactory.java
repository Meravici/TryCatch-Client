package com.nadzvi.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.physics.box2d.World;

public class BallFactory {
	private World world;
	private AssetManager assetManager;
	private float width;
	private float height;
	
	public Ball create(){
		float x = width * (float)Math.random();
		float y = height * (float)Math.random();
		return new Ball(world, assetManager, x, y);
	}
	
	public BallFactory(World world, AssetManager assetManager, float width,
			float height) {
		super();
		this.world = world;
		this.assetManager = assetManager;
		this.width = width;
		this.height = height;
	}
}
