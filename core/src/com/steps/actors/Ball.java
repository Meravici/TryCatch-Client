package com.steps.actors;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.steps.screens.GameWorld;

public class Ball extends Image {  
	   
    public static final float RADIUS = 0.8f; // bob is a ball with 0.8m diameter      
    public final Body body; // bob's box2d body  
      
    public Ball(GameWorld world, AssetManager assetManager) {  
          
        // bob is an Image, so we load the graphics from the assetmanager  
        Texture tex = assetManager.get("ball.png", Texture.class);  
        this.setDrawable(new TextureRegionDrawable(new TextureRegion(tex)));
        this.setBounds(0, 0, tex.getWidth(), tex.getHeight());  
        // generate bob's box2d body  
        CircleShape circle = new CircleShape();  
        circle.setRadius(RADIUS);  
          
        BodyDef bodyDef = new BodyDef();  
        bodyDef.type = BodyType.DynamicBody;  
        bodyDef.position.x = 0f;  
        bodyDef.position.y = 0f;  
//        bodyDef.linearDamping = 0.1f;  
//        bodyDef.angularDamping = 0.5f;  
          
        this.body = world.box2dWorld.createBody(bodyDef);  
//        this.body.setUserData(ElementType.BOB);  
          
        Fixture fix = body.createFixture(circle, 50);  
        fix.setDensity(1);  
        fix.setFriction(1f);  
        fix.setRestitution(0.8f);  
          
        circle.dispose();  
          
//        // generate bob's actor  
        System.out.println(body.getPosition().x);
        this.setPosition(body.getPosition().x-RADIUS, body.getPosition().y-RADIUS); // set the actor position at the box2d body position  
        this.setSize(RADIUS*2, RADIUS*2); // scale actor to body's size  
        this.setScaling(Scaling.stretch); // stretch the texture  
        this.setAlign(Align.center);  
    }  
      
    @Override  
    public void act(float delta) {  
        // here we override Actor's act() method to make the actor follow the box2d body  
        super.act(delta);  
        setOrigin(RADIUS, RADIUS);  
        setRotation(MathUtils.radiansToDegrees * body.getAngle());  
        setPosition(body.getPosition().x-RADIUS, body.getPosition().y-RADIUS);  
    }  
}  