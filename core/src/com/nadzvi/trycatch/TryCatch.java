package com.nadzvi.TryCatch;

import com.badlogic.gdx.Game;
import com.nadzvi.Utilities.assets.AssetsAPI;
import com.nadzvi.Utilities.ScreenFactory.ScreenHashPool;
import com.nadzvi.Utilities.ScreenFactory.ScreenPool;
import com.nadzvi.Utilities.assets.TryCatchAssets;


public class TryCatch extends Game {
	@Override
	public void create() {
        AssetsAPI assets = TryCatchAssets.buildAssets();
        ScreenPool screenPool = new ScreenHashPool(assets);
   		setScreen(screenPool.getSplashScreen());
	}
	
}
