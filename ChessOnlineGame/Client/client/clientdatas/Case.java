package client.clientdatas;

import pieces.Piece;

public class Case{

	private int x,y;
	//private Piece piece;
	private boolean blanc;

	public Case(int x, int y, boolean blanc)
	{
		this.x=x;
		this.y=y;
		this.blanc=blanc;
	}

	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}
	
	public boolean getWhite() 
	{
		return blanc;
	}
}
