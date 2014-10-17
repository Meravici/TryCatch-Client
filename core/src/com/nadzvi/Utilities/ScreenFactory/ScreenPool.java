package com.nadzvi.Utilities.ScreenFactory;

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
    public Screen getSplashScreen();

    public Screen getMenuScreen();

    public Screen getGameScreen();

    public Screen getPauseScreen();

    public Screen getSettingsScreen();

    public Screen getAboutScreen();

    public void addScreen(ScreenEnum id, Screen screen);

    public void disposeScreen(Screen screen);
}
