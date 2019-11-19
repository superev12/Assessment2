package com.kroy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;;

public class MyGdxGame extends ApplicationAdapter {
	
	public enum mapTiles
	{
		GRASS,
		NOTGRASS
	}
	
	SpriteBatch batch;
	Texture img;
	Texture iFiretruck;
	Texture iGrass;
	Texture iAlien;
	Boolean firetruckPlaces[][] = new Boolean[16][16];
	Boolean alienPlaces[][] = new Boolean[16][16];
	mapTiles map[][] = new mapTiles[16][16];
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		iFiretruck = new Texture("Firetruck.png");
		iGrass = new Texture("Grass.png");
		iAlien = new Texture("Alien.png");
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				firetruckPlaces[i][j] = false;
				alienPlaces[i][j] = false;
			}
		}
		
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				map[i][j] = mapTiles.NOTGRASS;
			}
		}
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				if (Math.sqrt(Math.pow(i-8, 2)+Math.pow(j-8, 2)) < 5)
				{
					map[i][j] = mapTiles.GRASS;
				}
			}
		}

		firetruckPlaces[2][2] = true;
		firetruckPlaces[5][10] = true;
		alienPlaces[8][9] = true;
		img = new Texture("badlogic.jpg");
		
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				if (map[i][j] == mapTiles.GRASS)
				{
					batch.draw(iGrass, i*32, j*32, 32, 32);
				}
				if (firetruckPlaces[i][j])
				{
					batch.draw(iFiretruck, i*32, j*32, 32, 32);
				}
				if (alienPlaces[i][j])
				{
					batch.draw(iAlien, i*32, j*32, 32, 32);
				}
			}
		}
		
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		iFiretruck.dispose();
	}
}
