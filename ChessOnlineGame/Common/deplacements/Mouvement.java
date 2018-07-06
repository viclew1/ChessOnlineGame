package deplacements;


public class Mouvement{

	private int x,y;
	private boolean limite;
	
	public Mouvement(int x, int y, boolean limite)
	{
		this.x=x;
		this.y=y;
		this.limite=limite;
	}

	public int getX()  {
		return x;
	}

	public int getY()  {
		return y;
	}

	public boolean isLimite()  {
		return limite;
	}
}
