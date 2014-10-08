package com.nadzvi.TryCatch;

import com.badlogic.gdx.Game;
import com.nadzvi.Utilities.AssetsAPI;
import com.nadzvi.Utilities.AssetsBuilder;
import com.nadzvi.Utilities.ScreenPool;
import com.nadzvi.Utilities.ScreenPoolBuilder;


public class TryCatch extends Game {
	@Override
	public void create() {
        AssetsAPI assets = AssetsBuilder.buildAssets();
        ScreenPool screenPool = ScreenPoolBuilder.buildStagePool(assets);
   		setScreen(screenPool.getScreen(ScreenPool.ScreenEnum.SPLASH));
	}
	
}
