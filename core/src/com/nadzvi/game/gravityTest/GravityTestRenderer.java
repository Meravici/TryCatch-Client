package com.nadzvi.game.gravityTest;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.nadzvi.game.GameWorld;

public class GravityTestRenderer {
	GameWorld world;
	Box2DDebugRenderer renderer;

	public GravityTestRenderer(GameWorld world) {
		this.world = world;
		this.renderer = new Box2DDebugRenderer();
	}

	public void render() {
		renderer.render(world.getWorld(), world.getStage().getCamera().combined);
		world.getStage().draw();
	}
}
