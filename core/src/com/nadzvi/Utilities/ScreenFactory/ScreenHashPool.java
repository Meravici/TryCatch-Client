package com.nadzvi.Utilities.ScreenFactory;

import com.badlogic.gdx.Screen;
import com.nadzvi.Sceens.*;
import com.nadzvi.Utilities.assets.AssetsAPI;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xato on 10/7/2014.
 */
public class ScreenHashPool implements ScreenPool {
    private Map<ScreenEnum, Screen> map;
    private AssetsAPI assets;
    public ScreenHashPool(AssetsAPI assets){
        this.assets = assets;
        this.map = new HashMap<ScreenEnum, Screen>();
    }

    @Override
    public Screen getSplashScreen() {
        if(!map.containsKey(ScreenEnum.SPLASH))
            map.put(ScreenEnum.SPLASH, new SplashScreen(assets, this));
        return map.get(ScreenEnum.SPLASH);
    }

    @Override
    public Screen getMenuScreen() {
        if(!map.containsKey(ScreenEnum.MENU))
            map.put(ScreenEnum.MENU, new MenuScreen());//TODO will need changes when menuScreen is implemented
        return map.get(ScreenEnum.MENU);
    }

    @Override
    public Screen getGameScreen() {
        if(!map.containsKey(ScreenEnum.GAME))
            map.put(ScreenEnum.GAME, new GameScreen(this));
        return map.get(ScreenEnum.GAME);
    }

    @Override
    public Screen getPauseScreen() {
        if(!map.containsKey(ScreenEnum.PAUSE))
            map.put(ScreenEnum.PAUSE, new PauseScreen(assets));//TODO needs this
        return map.get(ScreenEnum.PAUSE);
    }

    @Override
    public Screen getSettingsScreen() {
        if(!map.containsKey(ScreenEnum.SETTINGS))
            map.put(ScreenEnum.SETTINGS, new SettingsScreen()); //TODO will need changes when settingsScreen is implemented
        return map.get(ScreenEnum.SETTINGS);
    }

    @Override
    public Screen getAboutScreen() {
//        if(!map.containsKey(ScreenEnum.ABOUT))
//            map.put(ScreenEnum.ABOUT, new AboutScreen(assets, this));
//        return map.get(ScreenEnum.ABOUT);
        return null; //TODO remove comments after about is implemented
    }

    @Override
    public void addScreen(ScreenEnum id, Screen screen) {
        map.put(id, screen);
    }

    @Override
    public void disposeScreen(Screen screen) {
        map.remove(screen);
    }
}
