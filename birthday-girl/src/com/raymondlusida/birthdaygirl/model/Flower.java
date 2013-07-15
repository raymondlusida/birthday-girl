package com.raymondlusida.birthdaygirl.model;

public class Flower extends Gift {

	@Override
	public String toString() {
		return "Flower";
	}

	@Override
	public Gift copy() {
		Gift copy = new Flower();
		copy.setPosition(this.getPosition());
		return copy;
	}

	@Override
	public int getPrice() {
		return 5;
	}

	@Override
	public int getValue() {
		return 5;
	}
}
