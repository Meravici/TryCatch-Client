package com.nadzvi.Game.Objects;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.nadzvi.Utilities.assets.AssetsAPI;

public class BallFactory{
	private World world;
	private AssetsAPI assets;
	public BallFactory(World world, AssetsAPI assets) {
		super();
		this.world = world;
        this.assets = assets;
	}

	public Actor createActor(float x, float y) {
		return new Ball(world, x, y, assets);
	}
}
