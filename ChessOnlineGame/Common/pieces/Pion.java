package pieces;

import java.util.ArrayList;
import java.util.List;

import common.Point;
import deplacements.Mouvement;

public class Pion extends Piece {

	public Pion(int x, int y, boolean white)  
	{
		super(x,y,PieceName.PION, white);
	}

	@Override
	public List<Mouvement> mouvement() 
	{
		List<Mouvement> m=new ArrayList<Mouvement>();
		if (white)
			m.add(new Mouvement(0, 1, true));
		else
			m.add(new Mouvement(0, -1, true));
		return m;
	}


	@Override
	public List<Point> getDests(Piece[][] pieces) 
	{
		List<Point> dests=new ArrayList<Point>();

		if (white)
		{
			if (y<=6 && pieces[x][y+1]==null)
				dests.add(new Point(x, y+1));
			if (y<=5 && neverMoved && pieces[x][y+2]==null)
				dests.add(new Point(x, y+2));
			if (y<=6 && x<=6 && pieces[x+1][y+1]!=null && pieces[x+1][y+1].white()!=white())
				dests.add(new Point(x+1, y+1));
			if (y<=6 && x>=1 && pieces[x-1][y+1]!=null && pieces[x-1][y+1].white()!=white())
				dests.add(new Point(x-1, y+1));
		}

		if (!white)
		{
			if (y>0 && pieces[x][y-1]==null)
				dests.add(new Point(x, y-1));
			if (y>1 && neverMoved && pieces[x][y-2]==null)
				dests.add(new Point(x, y-2));
			if (y>0 && x<=6 && pieces[x+1][y-1]!=null && pieces[x+1][y-1].white()!=white())
				dests.add(new Point(x+1, y-1));
			if (x>0 && y>0 && pieces[x-1][y-1]!=null && pieces[x-1][y-1].white()!=white())
				dests.add(new Point(x-1, y-1));
		}


		return dests;

	}
}
