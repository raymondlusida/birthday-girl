package com.raymondlusida.birthdaygirl.controller;

import com.badlogic.gdx.math.Vector2;
import com.raymondlusida.birthdaygirl.model.Girl;
import com.raymondlusida.birthdaygirl.model.Room;

public class RoomController {

	private Room room;
	private Girl girl;
	
	private float accumulatedDelta;
	private int directionCounter = 0;
	
	public RoomController(Room room) {
		this.room = room;
		this.girl = room.getGirl();
		this.accumulatedDelta = 0;
	}
	
	public void update(float delta) {
		accumulatedDelta += delta;
		if(accumulatedDelta >= 2) {
			Vector2 goalPosition = new Vector2();
			
			if(directionCounter == 0) {
				goalPosition.x = girl.getPosition().x - 2;
				goalPosition.y = girl.getPosition().y;
			} else if(directionCounter == 1) {
				goalPosition.x = girl.getPosition().x;
				goalPosition.y = girl.getPosition().y - 2;
			} else if(directionCounter == 2) {
				goalPosition.x = girl.getPosition().x + 2;
				goalPosition.y = girl.getPosition().y;
			} else if(directionCounter == 3) {
				goalPosition.x = girl.getPosition().x;
				goalPosition.y = girl.getPosition().y + 2;
			}
			
			
			girl.goTo(goalPosition);
			System.out.println(girl.getDirection());
			accumulatedDelta = 0;
			directionCounter = (directionCounter + 1);
			if(directionCounter > 3)
				directionCounter = 0;
		}
	}
}
