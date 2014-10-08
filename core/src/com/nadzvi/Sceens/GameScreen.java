package com.nadzvi.Sceens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nadzvi.Game.GameWorld;
import com.nadzvi.Utilities.ScreenPool;


public class GameScreen implements Screen {
	// this is actually my tablet resolution in landscape mode. I'm using it for
	// making the GUI pixel-exact.

	private GameWorld world; // contains the game world's bodies and actors.
	private Stage HUD; // stage that holds the GUI. Pixel-exact size.
	private ScreenPool screenPool;
    private boolean pause;

	public GameScreen(Stage HUD, GameWorld world, ScreenPool screenPool){
		this(screenPool);
        this.HUD = HUD;
		this. world = world;
	}

    public GameScreen(ScreenPool screenPool){
        this.screenPool = screenPool;
        Gdx.app.getApplicationListener();
    }

    public void setWorld(GameWorld world){
        this. world = world;
    }

    public void setHUD(Stage HUD){
        this.HUD = HUD;
    }
	
	@Override
	public final void show() {		
		//Nothing to do here //TODO maybe
	}

	@Override
	public void render(float delta) {
		if(!pause) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            HUD.act(delta); // update GUI
            world.update(delta); // update the box2d world

            world.render(); // draw the box2d world
            HUD.draw(); // draw the GUI
        }
	}

	@Override
	public void resize(int width, int height) {
		world.resize(width, height);
		HUD.getViewport().update(width, height, true);
	}

	@Override
	public void hide() {
       pause();
	}

	@Override
	public void pause() {
        pause = true;
        ((Game)Gdx.app.getApplicationListener()).setScreen(screenPool.getScreen(ScreenPool.ScreenEnum.PAUSE));
	}

	@Override
	public void resume() {
		pause = false;
	}

	@Override
	public void dispose() {
		HUD.dispose();
		world.dispose();
	}
}