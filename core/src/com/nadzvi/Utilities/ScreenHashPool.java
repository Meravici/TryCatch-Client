package com.nadzvi.Utilities;

import com.badlogic.gdx.Screen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xato on 10/7/2014.
 */
public class ScreenHashPool implements ScreenPool {
    Map<ScreenEnum, Screen> map;

    public ScreenHashPool(){
        this.map = new HashMap<ScreenEnum, Screen>();
    }

    @Override
    public Screen getScreen(ScreenEnum id) {
        return map.get(id);
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
