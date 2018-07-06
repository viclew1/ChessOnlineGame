package pieces;

import deplacements.Mouvement;

public class Tour extends Piece{

	public Tour(int x, int y, boolean white) {
		super(x,y,PieceName.TOUR, white);
		mvt.add(new Mouvement(1, 0, false));
		mvt.add(new Mouvement(-1, 0, false));
		mvt.add(new Mouvement(0, 1, false));
		mvt.add(new Mouvement(0, -1, false));
	}
}
