package com.raymondlusida.birthdaygirl.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.raymondlusida.birthdaygirl.model.Girl;
import com.raymondlusida.birthdaygirl.model.Room;

public class RoomRenderer {

	private static final float CAMERA_WIDTH = 9f;
	private static final float CAMERA_HEIGHT = 16f;
	
	private Room room;
	private OrthographicCamera cam;

	/** debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();

	/** Textures **/
	private Texture girlTexture;
	
	private SpriteBatch spriteBatch;
	private boolean debug = false;
	private int width;
	private int height;
	private float ppuX; //pixels per unit on X axis
	private float ppuY; // pixels per unit on Y axis
	
	public RoomRenderer(Room room, boolean debug) {
		this.room = room;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		loadTextures();
	}
	
	public void setSize(int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float)width / CAMERA_WIDTH;
		ppuY = (float)height / CAMERA_HEIGHT;
	}
	
	private void loadTextures() {
		girlTexture = new Texture(Gdx.files.internal("images/girl.png"));
	}

	public void render() {
		spriteBatch.begin();
		drawGirl();
		spriteBatch.end();
		if(debug)
			drawDebug();
	}

	private void drawGirl() {
		Girl girl = room.getGirl();
		Sprite girlSprite = new Sprite(girlTexture);
		switch(girl.getDirection()) {
		case DOWN:

			break;
		case LEFT:
			
			break;
		case RIGHT:
			girlSprite.flip(true, false);
			break;
		case UP:
			girlSprite.flip(false, true);
			break;
		}
		spriteBatch.draw(	
					girlSprite, 
					girl.getPosition().x * ppuX,
					girl.getPosition().y * ppuY, 
					Girl.WIDTH * ppuX,
					Girl.HEIGHT * ppuY
		);
	}
	
	private void drawDebug() {
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Rectangle);

		//render matrix
		for(int w = 0; w < CAMERA_WIDTH; w++) {
			for(int h  = 0; h < CAMERA_HEIGHT; h++) {
				Rectangle rect = new Rectangle();
				rect.width = 1f;
				rect.height = 1f;
				debugRenderer.setColor(new Color(1, 0, 0, 1));
				debugRenderer.rect(w, h, rect.width, rect.height);
			}
		}
		
		// render Bob
		Girl girl = room.getGirl();
		Rectangle rect = girl.getBounds();

		float x1 = girl.getPosition().x;
		float y1 = girl.getPosition().y;
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();
	}
}