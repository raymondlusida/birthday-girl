package com.raymondlusida.birthdaygirl.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.raymondlusida.birthdaygirl.controller.RoomController;
import com.raymondlusida.birthdaygirl.model.Room;
import com.raymondlusida.birthdaygirl.renderer.RoomRenderer;

public class GameScreen implements Screen {

	private Room room;
	private RoomRenderer renderer;
	private RoomController controller;
	
	@Override
	public void show() {
		room = new Room();
		renderer = new RoomRenderer(room, true);
		renderer.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		controller = new RoomController(room);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		controller.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
