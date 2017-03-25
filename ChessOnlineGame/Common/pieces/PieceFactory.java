package pieces;

public class PieceFactory {


	public static Piece createPiece(int x, int y, String pieceName, boolean white)
	{
		switch (pieceName)
		{
		case "ROI":
			return createRoi(x,y,white);
		case "REINE":
			return createReine(x,y,white);
		case "PION":
			return createPion(x,y,white);
		case "FOU":
			return createFou(x,y,white);
		case "TOUR":
			return createTour(x,y,white);
		case "CAVALIER":
			return createCavalier(x,y,white);
		default:
			return null;
		}
	}

	protected static Piece createRoi(int x, int y, boolean white)
	{
		return new Roi(x,y,white);
	}

	protected static Piece createReine(int x, int y, boolean white)
	{
		return new Reine(x,y,white);
	}

	protected static Piece createPion(int x, int y, boolean white)
	{
		return new Pion(x,y,white);
	}

	protected static Piece createCavalier(int x, int y, boolean white)
	{
		return new Cavalier(x,y,white);
	}

	protected static Piece createTour(int x, int y, boolean white)
	{
		return new Tour(x,y,white);
	}

	protected static Piece createFou(int x, int y, boolean white)
	{
		return new Fou(x,y,white);
	}
}
