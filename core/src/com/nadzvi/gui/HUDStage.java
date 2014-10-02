package com.nadzvi.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nadzvi.data.Assets;

public class HUDStage extends Stage {

	public HUDStage(Viewport viewPort) {
		super(viewPort);
		// add GUI actors to stage, labels, meters, buttons etc.
		Label labelStatus = new Label("TOUCH TO START", Assets.getMenuSkin());
		labelStatus.setPosition(this.getWidth() / 2 - labelStatus.getWidth()
				/ 2, this.getHeight() / 2 - labelStatus.getHeight() / 2);

		this.addActor(labelStatus);
		// add other GUI elements here
	}

}
