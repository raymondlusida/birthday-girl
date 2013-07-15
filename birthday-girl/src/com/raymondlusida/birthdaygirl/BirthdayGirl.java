package com.raymondlusida.birthdaygirl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.raymondlusida.birthdaygirl.screen.GameScreen;
import com.raymondlusida.birthdaygirl.screen.MenuScreen;
import com.raymondlusida.birthdaygirl.screen.ResultScreen;

public class BirthdayGirl extends Game {

	public GameScreen gameScreen;
	public MenuScreen menuScreen;
	public ResultScreen resultScreen;
	
	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		resultScreen = new ResultScreen(this);
		setScreen(menuScreen);
	}
}
