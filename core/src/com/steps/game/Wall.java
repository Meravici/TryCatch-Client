package com.steps.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Wall extends Image {  
	   
//    public static final float RADIUS = 0.8f; // bob is a ball with 0.8m diameter      
    private final Body body; // bob's box2d body  
    private float width;
    private float height;
    public Wall(World world, AssetManager assetManager, float x, float y, float width, float height) {  
          
    	this.width = width;
    	this.height = height;
        // bob is an Image, so we load the graphics from the assetmanager  
        Texture tex = assetManager.get("wall.png", Texture.class);  
        this.setDrawable(new TextureRegionDrawable(new TextureRegion(tex)));
        this.setBounds(0, 0, width, height);  
        // generate bob's box2d body  
        
        PolygonShape rect = new PolygonShape();
        rect.setAsBox(width/2, height/2);
        
        BodyDef bodyDef = new BodyDef();  
        bodyDef.type = BodyType.StaticBody;  
        bodyDef.position.x = x;  
        bodyDef.position.y = y;  
//        bodyDef.linearDamping = 0.1f;  
//        bodyDef.angularDamping = 0.5f;  
          
        this.body = world.createBody(bodyDef);  
//        this.body.setUserData(ElementType.BOB);  
          
        Fixture fix = body.createFixture(rect, 50);  
        fix.setDensity(1);  
        fix.setFriction(1f);  
        fix.setRestitution(0.8f);  
          
        rect.dispose();  
          
        // generate bob's actor  
//        System.out.println(body.getPosition().x);
        this.setPosition(body.getPosition().x-width/2, body.getPosition().y-height/2); // set the actor position at the box2d body position  
        this.setSize(width, height); // scale actor to body's size  
        this.setScaling(Scaling.stretch); // stretch the texture  
        this.setAlign(Align.center);
    }  
      
    @Override  
    public void act(float delta) {  
        // here we override Actor's act() method to make the actor follow the box2d body  
        super.act(delta);  
        setOrigin(width/2, height/2);  
        setRotation(MathUtils.radiansToDegrees * body.getAngle());  
        setPosition(body.getPosition().x-width/2, body.getPosition().y-height/2);  
    }  
}  