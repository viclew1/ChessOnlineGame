package client.clientdatas;

import java.util.ArrayList;
import java.util.List;

import pieces.Equipe;
import pieces.Piece;

public class Model {

    private String name;
    private boolean connected;
    private boolean searching;
    private boolean white;
    private Piece[][] pieces;
    private List<Case> cases;

    public String getName() {
        return name == null ? "" : name;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setPieces(Piece[][] pieces)
    {
    	this.pieces=pieces;
    }

    public Piece[][] getPieces()
    {
    	return pieces;
    }
    
    public void movePiece(int x, int y, int x2, int y2)
	{
		pieces[x][y].move(x2, y2);
		pieces[x2][y2]=pieces[x][y];
		pieces[x][y]=null;
	}
    
	public List<Case> getCases() {
        if (cases == null) cases = new ArrayList<Case>();
        return cases;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

	public boolean isSearching() {
		return searching;
	}

	public void setSearching(boolean searching) {
		this.searching = searching;
	}

	public void setWhite(boolean white) {
		this.white=white;
	}
	
	public boolean isWhite() {
		return white;
	}

}