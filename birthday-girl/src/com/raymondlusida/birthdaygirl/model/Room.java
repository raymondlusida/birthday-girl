package com.raymondlusida.birthdaygirl.model;

import com.badlogic.gdx.math.Vector2;

public class Room {

	Girl girl;
	
	public Room() {
		girl = new Girl(new Vector2(4f, 8f));
	}
	
	public Girl getGirl() {
		return girl;
	}
}
