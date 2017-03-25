package client;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import common.Protocol;
import common.Reader;
import pieces.Piece;
import pieces.PieceFactory;

public class MessagesReader extends Reader {

	public MessagesReader(InputStream inputStream) {
		super(inputStream);
	}


	private int x1,y1,x2,y2;
	private List<Piece> blancs,noirs;
	private Piece piece;
	private boolean white;

	public void receive() {
		type = readInt ();
		switch (type)
		{
		case Protocol.RP_PIECES:
			blancs=new ArrayList<Piece>();
			noirs=new ArrayList<Piece>();
			white=readBoolean();
			int nbPiecesB=readInt();
			for (int i=0;i<nbPiecesB;i++)
			{
				blancs.add(readPiece());
			}
			int nbPiecesN=readInt();
			for (int i=0;i<nbPiecesN;i++)
			{
				noirs.add(readPiece());
			}
			break;
		case Protocol.RP_MOVED_PIECE:
			x1=readInt();
			y1=readInt();
			x2=readInt();
			y2=readInt();
			break;
		default:
			break;
		}

	}
	
	public int x1()
	{
		return x1;
	}
	
	public int y1()
	{
		return y1;
	}
	
	public int x2()
	{
		return x2;
	}
	
	public int y2()
	{
		return y2;
	}
	
	protected Piece readPiece()
	{
		return PieceFactory.createPiece(readInt(), readInt(), readString(), readBoolean());
	}

	public List<Piece> getBlancs() {
		return blancs;
	}
	
	public List<Piece> getNoirs() {
		return noirs;
	}
	
	public Piece getPiece(){
		return piece;
	}
	
	public boolean getWhite(){
		return white;
	}

}
