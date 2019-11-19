package com.kroy.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.kroy.game.MyGdxGame;

public class TitleScreen implements Screen
{
	final MyGdxGame game;
	private Texture titleImage;
	
	public TitleScreen(final MyGdxGame game)
	{
		this.game = game;
		titleImage = new Texture(Gdx.files.internal("mainmenu.jpg")); 
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) 
	{
		game.batch.begin();
		game.batch.draw(titleImage, 0, 0, 512, 512);
		//game.font.setColor(1, 1, 1, 1);
		game.font.draw(game.batch, "TEST GAME PLEASE IGNORE", 128, 256);
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
