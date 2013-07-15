package com.raymondlusida.birthdaygirl.model;

public class Food extends Gift {

	@Override
	public String toString() {
		return "Food";
	}
	
	@Override
	public Gift copy() {
		Gift copy = new Food();
		copy.setPosition(this.getPosition());
		return copy;
	}

	@Override
	public int getPrice() {
		return 7;
	}

	@Override
	public int getValue() {
		return 7;
	}
}