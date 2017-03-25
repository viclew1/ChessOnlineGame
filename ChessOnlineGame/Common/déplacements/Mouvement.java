package déplacements;


public class Mouvement{

	private int x,y;
	private boolean limité;
	
	public Mouvement(int x, int y, boolean limité)
	{
		this.x=x;
		this.y=y;
		this.limité=limité;
	}

	public int getX()  {
		return x;
	}

	public int getY()  {
		return y;
	}

	public boolean limité()  {
		return limité;
	}
}
