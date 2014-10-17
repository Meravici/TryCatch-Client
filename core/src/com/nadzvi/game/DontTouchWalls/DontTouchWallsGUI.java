package com.nadzvi.Game.DontTouchWalls;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nadzvi.Utilities.assets.AssetsAPI;

public class DontTouchWallsGUI extends Stage {

	public DontTouchWallsGUI(Viewport viewPort, AssetsAPI assets) {
		super(viewPort);
		// add GUI actors to stage, labels, meters, buttons etc.
		Label labelStatus = new Label("TOUCH TO START", assets.getMenuSkin());
		float x = this.getWidth() / 2 - labelStatus.getWidth()/ 2;
		float y = this.getHeight() / 2 - labelStatus.getHeight() / 2;
		labelStatus.setPosition(x, y);

		this.addActor(labelStatus);
		// TODO add other GUI elements here
	}

}
