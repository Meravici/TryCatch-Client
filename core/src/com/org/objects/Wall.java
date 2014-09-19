package com.org.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.utils.Box2DBuild;

public class Wall implements TCObject{
	Body body;
	Texture texture;
	BodyDef def;
	FixtureDef fd;
	
	
	/**
	 * Creates new instance of ball
	 * @param body physical representation of body in {@link Box2DBuild} world
	 * @param texture 
	 */
	public Wall(Texture texture, float x, float y, float height, float width){
		def = new BodyDef();
		def.type = BodyType.StaticBody;
		def.position.set(x, y);
	
		PolygonShape ps = new PolygonShape();
		ps.setAsBox(width/2, height/2);
		
		fd = new FixtureDef();
		
		fd.shape = ps;
		
		this.texture = texture;
	}
	
	public void createBody(World world){
		this.body = world.createBody(def);
		body.createFixture(fd);
		body.setUserData(this);
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}
	
}
