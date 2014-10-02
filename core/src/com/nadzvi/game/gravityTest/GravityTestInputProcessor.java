package com.nadzvi.game.gravityTest;



import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nadzvi.game.BallFactory;
import com.nadzvi.utils.Utils;

public class GravityTestInputProcessor implements InputProcessor {
	private Stage stage;
	private World world;
	private float height; // 6.4 meters
	private BallFactory ballFactory;
	
	public GravityTestInputProcessor(Stage stage, World world, float width, float height, BallFactory balLFactory){
		this.height = height;
		this.stage = stage;
		this.world = world;
		this.ballFactory = balLFactory;
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
		stage.addActor(ballFactory.create(Utils.pixelToMetes(x), height - Utils.pixelToMetes(y)));
		startX = x;
		startY = y;
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int arg2) {
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int arg2, int arg3) {
		world.setGravity(new Vector2((x-startX)/10, (-y+startY)/10));
		return false;
	}

}
