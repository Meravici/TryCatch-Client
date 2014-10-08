package com.nadzvi.Game.GravityTest;



import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class GravityTestInputProcessor implements InputProcessor {
	private World world;
	
	public GravityTestInputProcessor(World world){
		this.world = world;
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
