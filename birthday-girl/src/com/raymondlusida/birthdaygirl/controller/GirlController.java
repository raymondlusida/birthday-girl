package com.raymondlusida.birthdaygirl.controller;

import com.raymondlusida.birthdaygirl.model.Gift;
import com.raymondlusida.birthdaygirl.model.Girl;
import com.raymondlusida.birthdaygirl.model.Girl.Direction;
import com.raymondlusida.birthdaygirl.model.World;

public class GirlController {

	private World world;
	private Girl girl;
	
	public GirlController(World world) {
		this.world = world;
		this.girl = world.getGirl();
	}
	
	public void update(float delta) {
		moveGirlToGoal();
		world.update(delta);
	}
	
	private void moveGirlToGoal() {
		Gift giftGoal = getNextGiftInQueue();
		
		if(giftGoal == null)
			return;
		
		float deltaX = giftGoal.getPosition().x - girl.getPosition().x;
		float deltaY = giftGoal.getPosition().y - girl.getPosition().y;
		if(Math.abs(deltaX) > 0.2) {
			if(deltaX > 0)
				girl.move(Direction.RIGHT);
			else
				girl.move(Direction.LEFT);
		} else if(Math.abs(deltaY) > 0.2) {
			if(deltaY > 0)
				girl.move(Direction.UP);
			else
				girl.move(Direction.DOWN);
		} else {
			girl.stop();
			girl.receiveGift(giftGoal);
			removeGift(giftGoal);
		}
	}

	public void addGift(Gift gift) {
		world.addGift(gift);
		world.purchase(gift);
	}
	
	public void removeGift(Gift gift) {
		world.removeGift(gift);
	}
	
	public Gift getNextGiftInQueue() {
		if(world.getPlacedGifts().isEmpty())
			return null;
		
		return world.getPlacedGifts().get(0);
	}
}
