package com.steps.gui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HUDStage extends Stage {

	public HUDStage(Viewport viewPort, AssetManager assetManager) {
		super(viewPort);
		// add GUI actors to stage, labels, meters, buttons etc.
		Label labelStatus = new Label("TOUCH TO START", assetManager.get(
				"uiskin.json", Skin.class));
		labelStatus.setPosition(this.getWidth() / 2 - labelStatus.getWidth()
				/ 2, this.getHeight() / 2 - labelStatus.getHeight() / 2);

		this.addActor(labelStatus);
		// add other GUI elements here
	}

}
