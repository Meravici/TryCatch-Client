package com.nadzvi.Utilities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nadzvi.Utilities.AssetsAPI;

public class TryCatchAssets implements AssetsAPI {
	public AssetManager assetManager;

    public TryCatchAssets(){
        this.assetManager = new AssetManager();
    }

    // In here we'll put everything that needs to be loaded in this format:
    // manager.load("file location in assets", fileType.class);
    // 
    // libGDX AssetManager currently supports: Pixmap, Texture, BitmapFont,
    //     TextureAtlas, TiledAtlas, TiledMapRenderer, Music and Sound.
    public void queueLoading() {
    	assetManager.load("ball.png", Texture.class);
		assetManager.load("wall.png", Texture.class);
		assetManager.load("uiskin.json", Skin.class);
    }

    //In here we'll create our skin, so we only have to create it once.
    public Skin getMenuSkin() {
        return assetManager.get("uiskin.json", Skin.class);
    }
    // This function gets called every render() and the AssetManager pauses the loading each frame
    // so we can still run menus and loading screens smoothly
    public boolean isFinished() {
        return assetManager.update();
    }

    @Override
    public float getProgress() {
        return assetManager.getProgress();
    }

    public Texture getBallTexture() {
        return assetManager.get("ball.png", Texture.class);
    }

	public Texture getWallTexture() {
	    return assetManager.get("wall.png", Texture.class);
	}
}
