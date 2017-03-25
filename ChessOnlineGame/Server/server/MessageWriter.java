package server;

import java.io.OutputStream;
import java.util.List;

import common.Protocol;
import common.Writer;
import pieces.Piece;

public class MessageWriter extends Writer{

	public MessageWriter(OutputStream outputStream) {
		super (outputStream);
	}
	
	
	public void writePiecesList(List<Piece> pieces)
	{
		writeInt(pieces.size());
		for (int i=0;i<pieces.size();i++)
			writePiece(pieces.get(i));
	}
	
	public void writePiece(Piece p)
	{
		writeInt(p.getX());
		writeInt(p.getY());
		writeString(p.getPieceName().name());
		writeBoolean(p.white());
	}


	public void doDispatchPieces(List<Piece> blancs, List<Piece> noirs, boolean white) {
		writeInt(Protocol.RP_PIECES);
		writeBoolean(white);
		writePiecesList(blancs);
		writePiecesList(noirs);
	}


	public void doDispatchMovedPiece(int x, int y, int x2, int y2) {
		writeInt(Protocol.RP_MOVED_PIECE);
		writeInt(x);
		writeInt(y);
		writeInt(x2);
		writeInt(y2);
	}
	
}