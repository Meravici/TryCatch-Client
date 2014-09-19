package com.org.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.utils.Box2DBuild;

public class Ball {
	Body body;
	Texture texture;
	BodyDef def;
	FixtureDef fd;
	
	
	/**
	 * Creates new instance of ball
	 * @param body physical representation of body in {@link Box2DBuild} world
	 * @param texture 
	 */
	public Ball(Texture texture, float x, float y){
		def = new BodyDef();
		def.type = BodyType.DynamicBody;
		def.position.set(x, y);
		def.awake = true;
		CircleShape cs = new CircleShape();
		cs.setRadius(10f);
		
		fd = new FixtureDef();
		
		fd.shape = cs;
		fd.density = 10f;
		fd.friction = 0.3f;        
		
		this.texture = texture;
	}
	
	public void createBody(World world){
		this.body = world.createBody(def);
		body.createFixture(fd);
		body.setUserData(texture);
	}
	
	public void applyForce(Vector2 force, Vector2 point, boolean wake){
		body.applyForce(force, point, wake);
	}
	
}
