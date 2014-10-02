package com.nadzvi.game;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BallFactory {
	private World world;
	private float width;
	private float height;
	
	public Ball create(){
		float x = width * (float)Math.random();
		float y = height * (float)Math.random();
		return new Ball(world, x, y);
	}
	
	public BallFactory(World world, float width, float height) {
		super();
		this.world = world;
		this.width = width;
		this.height = height;
	}

	public Actor create(float x, float y) {
		return new Ball(world, x, y);
	}
}
