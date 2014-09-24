package com.steps.screens;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class GameRenderer {
	GameWorld world;
	Box2DDebugRenderer renderer;

	public GameRenderer(GameWorld world) {
		this.world = world;
		this.renderer = new Box2DDebugRenderer();
	}

	public void render() {
		renderer.render(world.box2dWorld, world.stage.getCamera().combined);
		world.stage.draw();
	}
}
