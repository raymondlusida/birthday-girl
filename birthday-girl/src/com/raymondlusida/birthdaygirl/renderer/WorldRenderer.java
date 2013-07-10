package com.raymondlusida.birthdaygirl.renderer;

import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.raymondlusida.birthdaygirl.model.Gift;
import com.raymondlusida.birthdaygirl.model.Girl;
import com.raymondlusida.birthdaygirl.model.World;

public class WorldRenderer {

	public static final float CAMERA_WIDTH = 9f;
	public static final float CAMERA_HEIGHT = 16f;
	
	private World room;
	private OrthographicCamera cam;

	/** debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();

	/** Textures **/
	private Texture girlTexture;
	private Texture giftTexture;
	
	private SpriteBatch spriteBatch;
	private boolean debug = false;
	
	public float ppuX; //pixels per unit on X axis
	public float ppuY; // pixels per unit on Y axis
	
	public WorldRenderer(World room, boolean debug) {
		this.room = room;
		
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		
		this.ppuX = Gdx.graphics.getWidth() / CAMERA_WIDTH;
		this.ppuY = Gdx.graphics.getHeight() / CAMERA_HEIGHT;
		
		this.debug = debug;
		
		spriteBatch = new SpriteBatch();
		loadTextures();
	}
	
	private void loadTextures() {
		girlTexture = new Texture(Gdx.files.internal("images/girl.png"));
		giftTexture = girlTexture;
	}

	public void render() {
		spriteBatch.begin();
		drawOptions();
		drawGirl();
		spriteBatch.end();
		if(debug)
			drawDebug();
	}

	private void drawOptions() {
		Set<Gift> optionGifts = room.getOptionGifts();
		int giftCounter = 0;
		for(Gift optionGift : optionGifts) {
			spriteBatch.draw(	
					giftTexture, 
					giftCounter * Gift.WIDTH * ppuX,
					0 * ppuY, 
					Gift.WIDTH * ppuX,
					Gift.HEIGHT * ppuY
			);
			giftCounter++;
		}
	}
	
	private void drawGirl() {
		Girl girl = room.getGirl();
		Sprite girlSprite = new Sprite(girlTexture);
		switch(girl.getDirection()) {
		case RIGHT:
			girlSprite.flip(true, false);
			break;
		case UP:
			girlSprite.flip(false, true);
			break;
		default:
		}
		spriteBatch.draw(	
					girlSprite, 
					(girl.getPosition().x - Girl.WIDTH / 2) * ppuX,
					(girl.getPosition().y - Girl.HEIGHT / 2 + World.MENU_HEIGHT) * ppuY, 
					Girl.WIDTH * ppuX,
					Girl.HEIGHT * ppuY
		);
	}
	
	private void drawDebug() {
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Rectangle);

		//render room
		for(int w = 0; w < World.ROOM_WIDTH; w++) {
			for(int h  = 0; h < World.ROOM_HEIGHT; h++) {
				Rectangle rect = new Rectangle();
				rect.width = 1f;
				rect.height = 1f;
				debugRenderer.setColor(new Color(1, 0, 0, 1));
				debugRenderer.rect(w, h + World.MENU_HEIGHT, rect.width, rect.height);
			}
		}
		
		// render Bob
		Girl girl = room.getGirl();
		Rectangle rect = girl.getBounds();

		float x1 = girl.getPosition().x - Girl.WIDTH / 2;
		float y1 = girl.getPosition().y - Girl.HEIGHT / 2 + World.MENU_HEIGHT;
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();
	}
}