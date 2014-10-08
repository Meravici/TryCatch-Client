package com.nadzvi.Utilities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Xato on 10/6/2014.
 */
public interface AssetsAPI {

    public void queueLoading();

    public boolean isFinished();

    public float getProgress();

    public Skin getMenuSkin();

    public Texture getBallTexture();

    public Texture getWallTexture();
}
