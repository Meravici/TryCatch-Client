package com.nadzvi.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.nadzvi.data.Assets;

public class SplashScreen implements Screen {
	private Texture splash;
	private Image splashImage;
	private Stage stage;
	private boolean animationDone = false;
	public SplashScreen() {
		this.stage = new Stage();
		splash = new Texture(Gdx.files.internal("Splash.png"));
		splashImage = new Image(splash);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(210/255f, 210/255f, 210/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		
		if(Assets.update()){ // check if all files are loaded
            
            if(animationDone){ // when the animation is finished, go to MainMenu()
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MenuScreen());
            }
        }
			
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void show() {
		System.out.println("Current Screen: Splash");
		stage.addActor(splashImage);
        
		splashImage.addAction(Actions.sequence(Actions.alpha(0)
                ,Actions.fadeIn(0.75f),Actions.delay(1.5f),Actions.run(new Runnable() {
            @Override
            public void run() {
                animationDone = true;
            }
        })));
        
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		splash.dispose();
		stage.dispose();

	}

}
