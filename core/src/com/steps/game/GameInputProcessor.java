package com.steps.game;



import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.steps.utils.Utils;

public class GameInputProcessor implements InputProcessor {
	private Stage stage;
	private World world;
	private AssetManager assetManager;
	private float height; // 6.4 meters
	
	public GameInputProcessor(Stage stage, World world, AssetManager assetManager, float width, float height){
		this.height = height;
		this.stage = stage;
		this.world = world;
		this.assetManager = assetManager;
	}
	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	private float startX;
	private float startY;
	
	@Override
	public boolean touchDown(int x, int y, int arg2, int arg3) {
//		System.out.println("Clicked at +"+x+";"+y);
		stage.addActor(new Ball(world, assetManager, Utils.pixelToMetes(x), height - Utils.pixelToMetes(y)));
		startX = x;
		startY = y;
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int arg2) {
//		world.setGravity(new Vector2(x, y));
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int arg2, int arg3) {
		world.setGravity(new Vector2((x-startX)/10, (-y+startY)/10));
		return false;
	}

}
