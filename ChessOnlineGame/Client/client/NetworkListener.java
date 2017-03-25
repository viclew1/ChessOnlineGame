package client;

import java.util.List;

import pieces.Piece;

public interface NetworkListener {

	void notifyConnection(String name);
	void notifyPartie(List<Piece> blancs, List<Piece> noirs, boolean white);
	void notifyMovedPiece(int x, int y, int x2, int y2);

}
