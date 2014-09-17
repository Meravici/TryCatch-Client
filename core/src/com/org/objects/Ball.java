package com.org.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.utils.Box2DBuild;

public class Ball {
	Body body;
	Texture texture;
	
	
	/**
	 * Creates new instance of ball
	 * @param body physical representation of body in {@link Box2DBuild} world
	 * @param texture 
	 */
	public Ball(Body body, Texture texture){
		this.body = body;
		this.texture = texture;
	}
	
}
