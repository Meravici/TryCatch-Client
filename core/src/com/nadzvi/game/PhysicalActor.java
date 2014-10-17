package com.nadzvi.Game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class PhysicalActor extends Image {
	protected Body body;
	protected float width;
	protected float height;
	
	@Override
	public void act(float delta) {
		// here we override Actor's act() method to make the actor follow the
		// box2d body
		super.act(delta);
		setOrigin(width / 2, height / 2);
		setRotation(MathUtils.radiansToDegrees * body.getAngle());
		setPosition(body.getPosition().x - width / 2, body.getPosition().y - height / 2);
	}

    public Body getBody(){
        return this.body;
    }
}
