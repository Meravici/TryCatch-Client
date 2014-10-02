package com.nadzvi.data;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
	public static AssetManager assetManager = new AssetManager();
    public static Skin menuSkin;
    public static Texture ball;
    public static Texture wall;
    

    // In here we'll put everything that needs to be loaded in this format:
    // manager.load("file location in assets", fileType.class);
    // 
    // libGDX AssetManager currently supports: Pixmap, Texture, BitmapFont,
    //     TextureAtlas, TiledAtlas, TiledMapRenderer, Music and Sound.
    public static void queueLoading() {
    	assetManager.load("ball.png", Texture.class);
		assetManager.load("wall.png", Texture.class);
		assetManager.load("uiskin.json", Skin.class);
    }

    //In here we'll create our skin, so we only have to create it once.
    public static Skin getMenuSkin() {
        if (menuSkin == null)
            menuSkin = assetManager.get("uiskin.json", Skin.class);
        return menuSkin;
    }
    // This function gets called every render() and the AssetManager pauses the loading each frame
    // so we can still run menus and loading screens smoothly
    public static boolean update() {
        return assetManager.update();
    }

	public static Texture getBall() {
		if(ball == null)
			ball = assetManager.get("ball.png", Texture.class);
		return ball;
	}

	public static Texture getWall() {
		if(wall == null)
			wall = assetManager.get("wall.png", Texture.class);
		return null;
	}
}
