package pieces;

import déplacements.Mouvement;

public class Fou extends Piece{

	public Fou(int x, int y, boolean white) {
		super(x,y,PieceName.FOU, white);
		mvt.add(new Mouvement(-1, 1, false));
		mvt.add(new Mouvement(-1, -1, false));
		mvt.add(new Mouvement(1, 1, false));
		mvt.add(new Mouvement(1, -1, false));
	}

}
