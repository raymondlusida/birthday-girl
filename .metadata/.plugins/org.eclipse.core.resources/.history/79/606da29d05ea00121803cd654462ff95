package com.raymondlusida.birthdaygirl.model;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.math.Vector2;

public class World {

	public static final float ROOM_WIDTH = 9f;
	public static final float ROOM_HEIGHT = 13f;
	
	public static final float MENU_HEIGHT = 3f;
	
	private Girl girl;
	private Set<Gift> optionGifts;
	
	public World() {
		girl = new Girl(new Vector2(4f, 7f));
		optionGifts = new HashSet<Gift>();
		optionGifts.add(new Flower());
		optionGifts.add(new Flower());
		optionGifts.add(new Flower());
	}
	
	public Girl getGirl() {
		return girl;
	}
	
	public Set<Gift> getOptionGifts() {
		return optionGifts;
	}

}
