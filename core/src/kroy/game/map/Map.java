package kroy.game.map;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.ui.List;

import kroy.game.entities.Entity;
import kroy.game.entities.Entity.entityID;
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
	}
	
	public Tile getBackground(int x, int y)
	{
		return backgroundLayer[x][y];
	}
	
	public Entity getEntity(int x, int y)
	{
		return entityLayer[x][y];
	}
	
	public void moveEntity(int x1, int y1, int x2, int y2)
	{
	/* Moves entity on the map from (x1, y1) to (x2, y2) provided the entity can move
	 * and there is nothing in the way */
		
		Entity e = entityLayer[x1][y1];
		
		if(e.id == entityID.FIRETRUCK && ((Firetruck)e).hasMoved())
		{
			return;
		}
		
		entityLayer[x2][y2] = e;
		entityLayer[x1][y1] = null;
		
		if(e.id == entityID.FIRETRUCK)
		{
			((Firetruck)e).setMoved();
		}
	}
	
	public void debugMakeFiretruck(int x, int y)
	{
		entityLayer[x][y] = new Firetruck();
	}
	
	public ArrayList<Firetruck> getFiretrucks()
	{
		/* Gives an arraylist of every firetruck in the map */
		ArrayList<Firetruck> arr = new ArrayList<Firetruck>();
		for (int i = 0; i < HEIGHT; i++)
		{
			for (int j = 0; j < WIDTH; j++)
			{
				if (entityLayer[i][j].id != null && entityLayer[i][j].id == entityID.FIRETRUCK)
				{
					arr.add((Firetruck) entityLayer[i][j]);
				}
			}
		}
		
		return arr;
	}
	
	public void resetActions()
	{
		for (Firetruck t:this.getFiretrucks())
		{
			t.resetMoved();
		}
	}
	
}
