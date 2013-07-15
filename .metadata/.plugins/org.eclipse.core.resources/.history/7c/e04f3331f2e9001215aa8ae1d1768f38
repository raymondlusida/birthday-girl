package com.raymondlusida.birthdaygirl.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Girl {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	public static final float HEIGHT = 3f;
	public static final float WIDTH = 3f;
	public static final float SPEED = 2f;
	
	private Vector2 position;
	private Vector2 velocity;
	private Rectangle bounds;
	private Direction direction;
	
	public Girl(Vector2 position) {
		this.position = position;
		this.velocity = new Vector2(0, 0);
		this.bounds = new Rectangle();
		this.bounds.height = HEIGHT;
		this.bounds.width = WIDTH;
		this.direction = Direction.LEFT;
	}

	public void update(float delta) {
		position.add(velocity.cpy().mul(delta));
	}
	
	public void move(Direction direction) {
		this.direction = direction;
		switch(direction) {
		case DOWN:
			velocity.x = 0;
			velocity.y = - SPEED;
			break;
		case LEFT:
			velocity.x = - SPEED;
			velocity.y = 0;
			break;
		case RIGHT:
			velocity.x = SPEED;
			velocity.y = 0;
			break;
		case UP:
			velocity.x = 0;
			velocity.y = SPEED;
			break;
		}
	}
	
	public void stop() {
		velocity.x = 0;
		velocity.y = 0;
	}
	
	public void goTo(Vector2 goalPosition) {
		float deltaX = goalPosition.x - position.x;
		float deltaY = goalPosition.y - position.y;
		float angle = (float) (Math.atan2(deltaY, deltaX) * 180f / Math.PI);
		if(angle < 0)
			angle += 360;
		System.out.println(angle);
		setDirection(angle);
	}
	
	private void setDirection(float angle) {
		if(angle > 45 && angle < 135)
			direction = Direction.UP;
		else if(angle >= 135 && angle <= 225)
			direction = Direction.LEFT;
		else if(angle > 225 && angle < 315)
			direction = Direction.DOWN;
		else
			direction = Direction.RIGHT;
	}
	
	private void setDirection(Direction newDirection) {
		this.direction = newDirection;
	}
	
	/** GETTERS AND SETTERS **/
	
	public Direction getDirection() {
		return direction;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
}
