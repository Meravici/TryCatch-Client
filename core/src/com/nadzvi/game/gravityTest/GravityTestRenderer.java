package com.nadzvi.game.gravityTest;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class GravityTestRenderer {
	GravityTestWorld world;
	Box2DDebugRenderer renderer;

	public GravityTestRenderer(GravityTestWorld world) {
		this.world = world;
		this.renderer = new Box2DDebugRenderer();
	}

	public void render() {
		renderer.render(world.getBox2dWorld(), world.getStage().getCamera().combined);
		world.getStage().draw();
	}
}
