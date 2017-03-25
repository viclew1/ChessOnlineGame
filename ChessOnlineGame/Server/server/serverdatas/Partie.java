package server.serverdatas;

import pieces.Equipe;
import pieces.EquipeBlanche;
import pieces.EquipeNoire;
import pieces.Piece;

public class Partie{
	private Equipe blancs, noirs;
	private Piece[][] pieces;
	private boolean whiteTurn=true;
	private boolean waiting;
	private Player p1,p2;

	public Partie(Player p1, Player p2) {
		this.p1=p1;
		this.p2=p2;
		pieces=new Piece[8][8];
		blancs=new EquipeBlanche(pieces);
		noirs=new EquipeNoire(pieces);
		waiting=true;
	}
	
	public Partie(Equipe e1, Equipe e2) {
		blancs=e1;
		noirs=e2;
	}

	public Player getPlayer(String name) {
		if (p1.getName().equals(name))
			return p1;
		else if (p2.getName().equals(name))
			return p2;
		return null;
	}

	public Player getP1() {
		return p1;
	}

	public Player getP2() {
		return p2;
	}

	public String movePiece(int x, int y, int x2, int y2) 
	{
		String moveInfos="";
		
		pieces[x][y].move(x2,y2);
		pieces[x2][y2]=pieces[x][y];
		pieces[x][y]=null;
		
		whiteTurn=!whiteTurn;
		
		return moveInfos;
	}

	public Equipe blancs()  {
		return blancs;
	}

	public Equipe noirs()  {
		return noirs;
	}

	public boolean waiting() {
		return waiting;
	}

	public Piece[][] getPieces() {
		return pieces;
	}
	
	public boolean whiteTurn() {
		return whiteTurn;
	}
}
