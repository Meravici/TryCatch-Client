package com.org.trycatch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.org.objects.Ball;
import com.org.objects.Wall;

public class Board {
	private static final Vector2 NULL_GRAVITY = new Vector2(0,0);
	Ball ball;
	World world;
	
	public Board(float width, float height){
		world = new World(NULL_GRAVITY, true);
		addWalls(width, height);
		ball = new Ball(null, 300,350); //TODO add texture
		addBalls(ball);
	}
	
	
	private void addWalls(float width, float height){
		Wall w1 = new Wall(null, 10,10,100,50); //TODO add texture
		w1.createBody(world);
	}
	
	public void addBalls(Ball...ball){
		for(Ball b:ball){
			b.createBody(world);
		}
	}
	
	public void render(float delta, SpriteBatch batch, Box2DDebugRenderer rend, Matrix4 mat){
		batch.begin();
		rend.render(world, mat);
		Array<Body> bodies = new Array<Body>();
		world.getBodies(bodies);
//		for(Body b:bodies){
//			Texture texture = (Texture)b.getUserData();
//			Vector2 position = b.getPosition();
//			batch.draw(texture, position.x, position.y);
//			//TODO need to draw those walls
//		}
		ball.applyForce(new Vector2(100*Gdx.input.getAccelerometerY(), -100*Gdx.input.getAccelerometerX()), bodies.get(1).getPosition(), true);
		batch.end();
		world.step(1,1,1);
	}
}
