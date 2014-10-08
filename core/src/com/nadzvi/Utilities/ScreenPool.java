package com.nadzvi.Utilities;

import com.badlogic.gdx.Screen;

/**
 * Created by Xato on 10/6/2014.
 */
public interface ScreenPool{
    public enum ScreenEnum{
        SPLASH,
        MENU,
        GAME,
        PAUSE,
        SETTINGS,
        ABOUT
    }
    public Screen getScreen(ScreenEnum id);

    public void addScreen(ScreenEnum id, Screen screen);

    public void disposeScreen(Screen screen);
}
