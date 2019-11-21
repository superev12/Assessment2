package map;

public class Map
{
	public final static int HEIGHT = 16;
	public final static int WIDTH = 16;
	
	public enum Tile
	{
		THING
	}
	
	private Tile background[][] = new Tile[WIDTH][HEIGHT];
	
	public Map()
	{
		for (int i = 0; i < HEIGHT; i++)
		{
			for (int j = 0; j < WIDTH; j++)
			{
				background[j][i] = Tile.THING;
			}
		}
	}
	
	public Tile getBackground(int x, int y)
	{
		return background[x][y];
	}
	
}
