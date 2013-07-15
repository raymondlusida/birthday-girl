package com.raymondlusida.birthdaygirl.model;

public class Plush extends Gift {

	@Override
	public String toString() {
		return "Plush";
	}
	
	@Override
	public Gift copy() {
		Gift copy = new Plush();
		copy.setPosition(this.getPosition());
		return copy;
	}

	@Override
	public int getPrice() {
		return 9;
	}

	@Override
	public int getValue() {
		return 9;
	}
}
