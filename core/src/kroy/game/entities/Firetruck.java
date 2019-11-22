package kroy.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Firetruck extends Entity
{
	private boolean movedThisTurn;
	
	public Firetruck()
	{
		this.texture = new Texture(Gdx.files.internal("Firetruck2.png"));
		this.id = entityID.FIRETRUCK;
	}
	
	public boolean hasMoved()
	{
		return movedThisTurn;
	}
	
	public void setMoved()
	{
		this.movedThisTurn = true;
	}
	
	public void resetMoved()
	{
		this.movedThisTurn = false;
	}
}
