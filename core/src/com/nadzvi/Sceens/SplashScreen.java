package com.nadzvi.Sceens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.nadzvi.Game.GameHUDFactory;
import com.nadzvi.Game.GameWorldFactory;
import com.nadzvi.Utilities.AssetsAPI;
import com.nadzvi.Utilities.ScreenPool;

public class SplashScreen implements Screen {
	private Texture splash;
	private Image splashImage;
	private Stage stage;
    private AssetsAPI assets;
    private ScreenPool screenPool;
    private static final String SPLASH_FILE = "Splash.png";
	public SplashScreen(AssetsAPI assets, ScreenPool screenPool) {
        this.assets = assets;
        this.screenPool = screenPool;

        this.stage = new Stage();
        splash = new Texture(Gdx.files.internal(SPLASH_FILE));
		splashImage = new Image(splash);
        stage.addActor(splashImage);

        assets.queueLoading();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(210/255f, 210/255f, 210/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		
		if(assets.isFinished()){ // check if all files are loaded
            GameScreen screen = (GameScreen)screenPool.getScreen(ScreenPool.ScreenEnum.GAME);
            screen.setWorld(GameWorldFactory.create(GameWorldFactory.GameWorldType.GRAVITY_TEST, assets));
            screen.setHUD(GameHUDFactory.create(GameWorldFactory.GameWorldType.GRAVITY_TEST, assets));
            ((Game)Gdx.app.getApplicationListener()).setScreen(screen);
        }else{
            float progress = assets.getProgress();
            //TODO draw loading percentage (Problem: can't do it with Label b'cos skin isn't loaded)
        }
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void show() {
		System.out.println("Current Screen: Splash");
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
        screenPool.disposeScreen(this);
	}
}
