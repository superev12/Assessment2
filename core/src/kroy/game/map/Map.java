package kroy.game.map;

import kroy.game.entities.Entity;
import kroy.game.entities.Firetruck;
import kroy.game.map.tiles.Grass;

public class Map
{
	public final static int HEIGHT = 16;
	public final static int WIDTH = 16;
	
	private Tile backgroundLayer[][] = new Tile[WIDTH][HEIGHT];
	private Entity entityLayer[][] = new Entity[WIDTH][HEIGHT];
	
	public Map()
	{
		for (int i = 0; i < HEIGHT; i++)
		{
			for (int j = 0; j < WIDTH; j++)
			{
				backgroundLayer[j][i] = new Grass();
				entityLayer[i][j] = null;
			}
		}
		entityLayer[2][3] = new Firetruck();
	}
	
	public Tile getBackground(int x, int y)
	{
		return backgroundLayer[x][y];
	}
	
	public Entity getEntity(int x, int y)
	{
		return entityLayer[x][y];
	}
	
}
