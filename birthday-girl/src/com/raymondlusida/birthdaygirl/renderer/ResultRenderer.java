package com.raymondlusida.birthdaygirl.renderer;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.raymondlusida.birthdaygirl.model.World;

public class ResultRenderer {

	private World world;
	
	private SpriteBatch spriteBatch;
	private BitmapFont font;
	
	public ResultRenderer(World world) {
		this.world = world;
		spriteBatch = new SpriteBatch();
		this.font = new BitmapFont();
	}
	
	public void render() {
		spriteBatch.begin();
		
		CharSequence moneySpent = "You've spent $" + Integer.toString(world.getMoneySpent());
		font.draw(spriteBatch, moneySpent, 50, 70);
		
		CharSequence avgHappiness = "Happiness is " + Float.toString(world.getGirl().getHappiness());
		font.draw(spriteBatch, avgHappiness, 50, 50);
		
		CharSequence score = "Total Score is " + Integer.toString(world.getScore());
		font.draw(spriteBatch, score, 50, 30);
		
		spriteBatch.end();
	}
}
