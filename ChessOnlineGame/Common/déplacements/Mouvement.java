package d�placements;


public class Mouvement{

	private int x,y;
	private boolean limit�;
	
	public Mouvement(int x, int y, boolean limit�)
	{
		this.x=x;
		this.y=y;
		this.limit�=limit�;
	}

	public int getX()  {
		return x;
	}

	public int getY()  {
		return y;
	}

	public boolean limit�()  {
		return limit�;
	}
}
