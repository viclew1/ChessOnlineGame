package pieces;

import déplacements.Mouvement;

public class Roi extends Piece{

	public Roi(int x, int y, boolean white)  {
		super(x,y,PieceName.ROI, white);
		mvt.add(new Mouvement(-1, -1, true));
		mvt.add(new Mouvement(-1, 1, true));
		mvt.add(new Mouvement(1, -1, true));
		mvt.add(new Mouvement(1, 1, true));
		mvt.add(new Mouvement(1, 0, true));
		mvt.add(new Mouvement(-1, 0, true));
		mvt.add(new Mouvement(0, 1, true));
		mvt.add(new Mouvement(0, -1, true));
	}


	@Override
	public boolean echec(Piece[][] pieces)  
	{
		for (int i=0;i<pieces.length;i++)
			for (int j=0;j<pieces[0].length;j++)
				if (pieces[i][j]!=null)
					for(int k=0;k<pieces[i][j].getDests(pieces).size();k++)
						if (pieces[i][j].white()!=white() && pieces[i][j].getDests(pieces).get(k).x==getX() && pieces[i][j].getDests(pieces).get(k).y==getY())
							return true;
		return false;

	}

	/*@Override
	public List<Case> getDests(Case[][] cases) 
	{
		List<Case> dests = new ArrayList<Case>();
		for (int i=0;i<mouvement().size();i++)
		{
			Mouvement m=mouvement().get(i);
			int i1=getY()+m.getX();
			int j1=getX()+m.getY();

			if (i1 < cases.length && i1 >=0 && j1<cases[0].length && j1>=0)
				if (!sameColor(cases[i1][j1]))
					dests.add(cases[i1][j1]);
		}
		return dests;

	}*/
}
