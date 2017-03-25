package pieces;

import java.util.ArrayList;
import java.util.List;

import common.Point;
import déplacements.Mouvement;

public class Piece{

	protected int x,y;
	protected PieceName name;
	protected boolean white;
	protected List<Mouvement> mvt;
	protected boolean neverMoved=true;

	public Piece(int x, int y, PieceName name, boolean white) 
	{
		this.x=x;
		this.y=y;
		this.name=name;
		this.white=white;
		mvt=new ArrayList<Mouvement>();
	}


	public List<Mouvement> mouvement() 
	{
		return mvt;
	}

	public boolean white() 
	{
		return white;
	}

	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}

	public String move(int x2, int y2) 
	{
		x=x2;
		y=y2;
		neverMoved=false;
		return "Moved " +x+","+y+" to "+x2+","+y2;
	}


	public boolean sameColor(Piece p) 
	{
		return (white()==p.white());
	}

	public boolean echec(Piece[][] pieces) 
	{
		return false;
	}

	public List<Point> getFilteredDests(Piece[][] pieces) 
	{
		List<Point> dests=getDests(pieces);
		return filter(dests,pieces);
	}

	private List<Point> filter(List<Point> dests , Piece[][] pieces) 
	{

		List<Point> fDests = new ArrayList<Point>();

		Piece roi = getRoi(pieces);

		int xx=x;
		int yy=y;
		for (int i=0;i<dests.size();i++)
		{
			pieces[xx][yy]=null;
			int _xx=(int) dests.get(i).getX();
			int _yy=(int) dests.get(i).getY();
			Piece pieceToDestroy=pieces[_xx][_yy];
			x=_xx;
			y=_yy;
			pieces[_xx][_yy]=this;
			if (!roi.echec(pieces))
				fDests.add(new Point(_xx,_yy));
			x=xx;
			y=yy;
			pieces[_xx][_yy]=pieceToDestroy;
			pieces[xx][yy]=this;
		}

		return fDests;
	}

	public List<Point> getDests(Piece[][] pieces) 
	{
		List<Point> dests = new ArrayList<Point>();
		for (int i=0;i<mouvement().size();i++)
		{
			Mouvement m=mouvement().get(i);
			int dMax=1;
			if (!m.limité())
				dMax=7;


			for (int j=1;j<=dMax;j++)
			{
				int xx=x+j*m.getX();
				int yy=y+j*m.getY();

				if (xx<0 || xx>=8 || yy<0 || yy>=8)
					break;

				if (pieces[xx][yy]!=null)
					if (pieces[xx][yy].white()==white())
						break;
					else
					{
						dests.add(new Point(xx,yy));
						break;
					}
				else
					dests.add(new Point(xx,yy));

			}
		}

		return dests;

	}

	public Piece getRoi(Piece[][] pieces)
	{
		for (int i=0;i<pieces.length;i++)
			for (int j=0;j<pieces[0].length;j++)
				if (pieces[i][j]!=null)
					if (pieces[i][j].white()==white() && pieces[i][j].getPieceName()==PieceName.ROI)
						return pieces[i][j];
		return null;
	}

	public PieceName getPieceName()  {
		return name;
	}

}
