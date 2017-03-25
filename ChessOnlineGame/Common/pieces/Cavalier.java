package pieces;

import déplacements.Mouvement;

public class Cavalier extends Piece{

	public Cavalier(int x, int y, boolean white) {
		super(x,y,PieceName.CAVALIER, white);
		mvt.add(new Mouvement(2, 1, true));
		mvt.add(new Mouvement(2, -1, true));
		mvt.add(new Mouvement(-2, 1, true));
		mvt.add(new Mouvement(-2, -1, true));
		mvt.add(new Mouvement(1, 2, true));
		mvt.add(new Mouvement(1, -2, true));
		mvt.add(new Mouvement(-1, 2, true));
		mvt.add(new Mouvement(-1, -2, true));
	}

}
