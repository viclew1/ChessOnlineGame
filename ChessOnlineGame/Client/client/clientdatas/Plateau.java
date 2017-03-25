package client.clientdatas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import common.Point;
import pieces.Piece;

public class Plateau extends JPanel implements MouseListener{

	private ModelListener listener;
	private Case[][] cases;
	private Piece selectedPiece;
	private List<Case> dests=new ArrayList<Case>();
	private Piece[][] pieces=new Piece[8][8];
	private boolean white;

	private int taille;

	public Plateau(ModelListener listener, int tailleCase)
	{
		this.listener=listener;
		cases=new Case[8][8];
		for (int i=0;i<8;i++)
			for (int j=0;j<8;j++)
				cases[i][j]=new Case(i, j, (i+j)%2==0);
		this.addMouseListener(this);
		
		this.taille=tailleCase;
		setPreferredSize(new Dimension(taille*8+1, taille*8+1));
	}

	public Rectangle getRect(Case c) 
	{
		return new Rectangle(c.getX()*taille, c.getY()*taille, taille, taille);
	}
	
	public Piece getPiece(Case c)
	{
		return pieces[c.getX()][c.getY()];
	}

	public Color caseColor(Case c) 
	{
		if (getPiece(c) !=null && getPiece(c).echec(pieces))
			return new Color(219, 32, 32);
		else if (selectedPiece!=null && selectedPiece==getPiece(c))
			return new Color(71, 191, 38);
		else if (dests.contains(c))
			return new Color(89, 182, 229);
		else if (c.getWhite()) 
			return new Color(218, 215, 226);
		else
			return new Color(84, 81, 96);
	}


	public void drawPiece(Graphics g,Case c) throws IOException
	{
		String url = "images/"+getPiece(c).getPieceName();
		if (getPiece(c).white())
			url+="B.png";
		else
			url+="N.png";
		g.drawImage(ImageIO.read(new File(url)), c.getX()*taille, c.getY()*taille, taille, taille, null);
	}

	public void paintCase(Graphics g, Case c) throws IOException
	{
		Graphics2D g2= (Graphics2D) g;
		g2.setColor(caseColor(c));
		g2.fill(getRect(c));
		g2.setColor(Color.black);
		g2.draw(getRect(c));
		if (getPiece(c)!=null)
			drawPiece(g2, c);
	}


	public void paint(Graphics g)
	{
		for (int i=0;i<cases.length;i++)
			for (int j=0;j<cases[0].length;j++)
				try {
					paintCase(g,cases[i][j]);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

	public void setPieces(Model model) {
		pieces=model.getPieces();
		white=model.isWhite();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		try{
			Case c=getCase(e.getPoint());

			if (c!=null && dests.contains(c))
				listener.requestMove(selectedPiece.getX(),selectedPiece.getY(),c.getX(),c.getY());
				//movePiece(selectedPiece.getX(),selectedPiece.getY(),c.getX(),c.getY());

			unselectAll();

			if (c!=null)
				selectPiece(c);

			updatePlateau();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

	public Case getCase(java.awt.Point loc) 
	{
		for (int i=0;i<cases.length;i++)
			for (int j=0;j<cases[0].length;j++)
				if (getRect(cases[i][j]).contains(loc))
					return cases[i][j];
		return null;
	}

	public void updatePlateau()
	{
		revalidate();
		repaint();
	}

	public void selectPiece(Case c) 
	{
		if (getPiece(c)!=null && getPiece(c).white()==white)
		{			
			selectedPiece=getPiece(c);
			setDests(selectedPiece);
		}
	}


	public void setDests(Piece p)
	{
		List<Point> destsP=p.getFilteredDests(pieces);
		for (int i=0;i<destsP.size();i++)
			dests.add(cases[destsP.get(i).x][destsP.get(i).y]);

	}

	public void unselectAll() 
	{
		selectedPiece=null;
		this.dests=new ArrayList<Case>();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
