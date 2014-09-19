package com.org.trycatch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.org.objects.Ball;
import com.org.objects.TCObject;
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
		//left
		Wall w1 = new Wall(null, -width/2,0,height,50); //TODO add texture
		w1.createBody(world);
		
		//right
		Wall w2 = new Wall(null, width/2,0,height,50); //TODO add texture
		w2.createBody(world);
		
		//top
		Wall w3 = new Wall(null, 0,-height/2,50,width); //TODO add texture
		w3.createBody(world);
		
		//bottom
		Wall w4 = new Wall(null, 0,height/2,50,width); //TODO add texture
		w4.createBody(world);
		
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
		for(Body b:bodies){
			TCObject obj = (TCObject)b.getUserData();
			obj.draw(batch);
		}
		batch.end();
		ball.applyForce(new Vector2(100*Gdx.input.getAccelerometerY(), -100*Gdx.input.getAccelerometerX()));
		world.step(1,1,1);
	}
}
