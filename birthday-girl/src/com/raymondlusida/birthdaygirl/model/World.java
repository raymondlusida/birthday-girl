package com.raymondlusida.birthdaygirl.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class World {

	public static final float ROOM_WIDTH = 9f;
	public static final float ROOM_HEIGHT = 13f;
	
	public static final float MENU_HEIGHT = 3f;
	
	public static final float TIME_LIMIT = 10;
	
	private Girl girl;
	private Collection<Gift> optionGifts;
	private List<Gift> placedGifts;
	
	private int moneySpent;
	private float timePassed;
	
	public World() {
		girl = new Girl(new Vector2(4f, 7f));
		
		optionGifts = new LinkedList<Gift>();
		optionGifts.add(new Flower());
		optionGifts.add(new Food());
		optionGifts.add(new Plush());
		
		this.placedGifts = new LinkedList<Gift>();
		this.moneySpent = 0;
		this.timePassed = 0;
	}
	
	public void update(float delta) {
		timePassed += delta;
		
		if(! isOver())		
			girl.update(delta);
	}
	
	public Girl getGirl() {
		return girl;
	}
	
	public boolean isOver() {
		return timePassed >= TIME_LIMIT;
	}
	
	public Collection<Gift> getOptionGifts() {
		return optionGifts;
	}
	
	public void addGift(Gift gift) {
		placedGifts.add(gift);
	}
	
	public void removeGift(Gift gift) {
		placedGifts.remove(gift);
	}
	
	public List<Gift> getPlacedGifts() {
		return placedGifts;
	}
	
	public void purchase(Gift gift) {
		moneySpent += gift.getPrice();
	}
	
	public int getMoneySpent() {
		return moneySpent;
	}
	
	public float getTimePassed() {
		return timePassed;
	}
	
	public int getScore() {
		return (int) girl.getHappiness() * 10 - moneySpent * 5;
	}

}
