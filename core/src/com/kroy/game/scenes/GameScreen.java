package com.kroy.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.kroy.game.MyGdxGame;

import kroy.game.map.Map;

public class GameScreen implements Screen
{
	
	final MyGdxGame game;
	Map map;
	
	public GameScreen(final MyGdxGame game)
	{
		this.game = game;
		this.map = new Map();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 0, 1, 1);
		game.batch.begin();
		for (int i = 0; i < Map.WIDTH; i++)
		{
			for (int j = 0; j < Map.HEIGHT; j++)
			{
				// Render background
				game.batch.draw(map.getBackground(i, j).getTexture(), i*32, j*32, 32, 32);
				// Render entities
				if (map.getEntity(i, j) != null)
				{
					game.batch.draw(map.getEntity(i, j).getTexture(), i*32, j*32, 32, 32);
				}
			}
		}
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
