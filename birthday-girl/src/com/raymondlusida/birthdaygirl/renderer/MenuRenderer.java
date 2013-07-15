package com.raymondlusida.birthdaygirl.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuRenderer {

	private float width;
	private float height;
	
	private SpriteBatch spriteBatch;
	private Texture background;
	
	public MenuRenderer() {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
				
		spriteBatch = new SpriteBatch();
		loadTexture();
	}
	
	private void loadTexture() {
		background = new Texture(Gdx.files.internal("images/menu-background.png"));
	}
	
	public void render() {
		spriteBatch.begin();
		
		spriteBatch.draw(background, 0, 0, width, height);
		
		spriteBatch.end();
	}
	
}
