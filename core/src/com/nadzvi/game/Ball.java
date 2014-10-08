package com.nadzvi.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.nadzvi.Utilities.AssetsAPI;

public class Ball extends PhysicalActor {
	public static enum State {
		CATCH, RUN
	} 
    public static final float RADIUS = 0.8f; // bob is a ball with 0.8m diameter

      
    public Ball(World world, float x, float y, AssetsAPI assets) {
        this.width = RADIUS*2;
        this.height = RADIUS*2;
        // bob is an Image, so we load the graphics from the asset manager
        Texture tex = assets.getBallTexture();
        this.setDrawable(new TextureRegionDrawable(new TextureRegion(tex)));
        this.setBounds(0, 0, tex.getWidth(), tex.getHeight());  
        // generate ball's box2d body  
        CircleShape circle = new CircleShape();  
        circle.setRadius(RADIUS);  
          
        BodyDef bodyDef = new BodyDef();  
        bodyDef.type = BodyType.DynamicBody;  
        bodyDef.position.set(x, y);
        
        this.body = world.createBody(bodyDef);  
        Fixture fix = body.createFixture(circle, 50);  
        fix.setDensity(1);  
        fix.setFriction(1f);  
        fix.setRestitution(0.8f);  
        
        circle.dispose();   //no longer needed
          
        // generate bob's actor  
        this.setPosition(body.getPosition().x-RADIUS, body.getPosition().y-RADIUS); // set the actor position at the box2d body position  
        this.setSize(RADIUS*2, RADIUS*2); // scale actor to body's size  
        this.setScaling(Scaling.stretch); // stretch the texture  
        this.setAlign(Align.center);  
    }  
      
     
}  