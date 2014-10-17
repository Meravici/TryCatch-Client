package com.nadzvi.Game.Objects;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.nadzvi.Utilities.assets.AssetsAPI;

public class WallFactory {
	private World world;
    AssetsAPI assets;
	public WallFactory(World world, AssetsAPI assets) {
		super();
        this.assets = assets;
		this.world = world;
	}

	public Actor createActor(float x, float y, float width, float height) {
		return new Wall(world, x, y, width, height, assets);
	}
}
