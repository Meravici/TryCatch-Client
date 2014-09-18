package com.org.trycatch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.org.objects.Ball;

public class Board {
	private static final Vector2 NULL_GRAVITY = new Vector2(0.1f,0);
	
	World world;
	
	public Board(float width, float height){
		world = new World(NULL_GRAVITY, true);
		addWalls(width, height);
	}
	
	
	private void addWalls(float width, float height){
		//TODO implementation of building walls
	}
	
	public void addBalls(Ball...ball){
		for(Ball b:ball){
			b.createBody(world);
		}
	}
	
	public void render(float delta, SpriteBatch batch){
		batch.begin();
		Array<Body> bodies = new Array<Body>();
		world.getBodies(bodies);
		for(Body b:bodies){
			Texture texture = (Texture)b.getUserData();
			Vector2 position = b.getPosition();
			batch.draw(texture, position.x, position.y);
			//TODO need to draw those walls
		}
		batch.end();
		world.step(1, 1, 1);
		world.setGravity(new Vector2(Gdx.input.getAccelerometerY(), -Gdx.input.getAccelerometerX()));
	}
}
