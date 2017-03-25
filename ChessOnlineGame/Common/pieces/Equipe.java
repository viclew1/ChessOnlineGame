package pieces;

import java.util.ArrayList;
import java.util.List;


public class Equipe {


	private List<Piece> pieces=new ArrayList<Piece>();
	private boolean white;
	public Piece roi;

	protected Equipe(boolean white, Piece[][] piecesToFill)
	{
		this.white=white;
		int y;
		if (white)
			y=0;
		else y=1;
		for (int i=0;i<8;i++)
		{
			Piece pB=new Pion(i,1+5*y, white);
			pieces.add(pB);
			piecesToFill[i][1+5*y]=pB;
		}
		for (int i=0;i<2;i++)
		{
			Piece pB=new Tour(i*7,7*y, white);
			pieces.add(pB);
			piecesToFill[i*7][7*y]=pB;
		}
		for (int i=0;i<2;i++)
		{
			Piece pB=new Cavalier(1+i*5,7*y, white);
			pieces.add(pB);
			piecesToFill[1+i*5][7*y]=pB;
		}
		for (int i=0;i<2;i++)
		{
			Piece pB=new Fou(2+i*3,7*y, white);
			pieces.add(pB);
			piecesToFill[2+i*3][7*y]=pB;
		}
		Piece reine=new Reine(3,7*y, white);
		roi=new Roi(4,7*y, white);
		pieces.add(reine);
		piecesToFill[3][7*y]=reine;
		pieces.add(roi);
		piecesToFill[4][7*y]=roi;

	}


	public Equipe(List<Piece> pieces) {
		this.pieces=pieces;
	}


	public boolean white()
	{
		return white;
	}


	public List<Piece> getPieces()
	{
		return pieces;
	}


	public Piece find(int x, int y) {
		for (int i=0;i<pieces.size();i++)
			if (pieces.get(i).getX()==x && pieces.get(i).getY()==y)
				return pieces.get(i);
		return null;
	}


}
