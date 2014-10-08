package com.nadzvi.Utilities;

/**
 * Created by Xato on 10/6/2014.
 */

import com.nadzvi.Sceens.*;

public class ScreenPoolBuilder {
    public static ScreenPool buildStagePool(AssetsAPI assets){
        ScreenPool pool = new ScreenHashPool();
        pool.addScreen(ScreenPool.ScreenEnum.SPLASH, new SplashScreen(assets, pool));
        pool.addScreen(ScreenPool.ScreenEnum.GAME, new GameScreen(pool));
        pool.addScreen(ScreenPool.ScreenEnum.MENU, new MenuScreen());
        pool.addScreen(ScreenPool.ScreenEnum.PAUSE, new PauseScreen(assets));
        pool.addScreen(ScreenPool.ScreenEnum.SETTINGS, new SettingsScreen());
        return pool;
    }
}