package pieces;

import déplacements.Mouvement;

public class Reine extends Piece{

	public Reine(int x, int y, boolean white) {
		super(x,y,PieceName.REINE, white);
		mvt.add(new Mouvement(-1, -1, false));
		mvt.add(new Mouvement(-1, 1, false));
		mvt.add(new Mouvement(1, -1, false));
		mvt.add(new Mouvement(1, 1, false));
		mvt.add(new Mouvement(1, 0, false));
		mvt.add(new Mouvement(-1, 0, false));
		mvt.add(new Mouvement(0, 1, false));
		mvt.add(new Mouvement(0, -1, false));
	}

}
