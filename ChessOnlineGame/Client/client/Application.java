package client;
import java.util.List;

import client.clientdatas.*;
import pieces.Piece;


public class Application implements NetworkListener, GUIListener {

	private CommandSession command;
	private MessagesSession messages;
	private Model model;
	private ModelListener gui;

	@Override
	public void notifyConnection(String name) {
		if (model.isConnected()) {
			String n = model.getName() == null ? name : model.getName();
			command.doDisconnect(n);
			command.close();
			command = null;
			messages.close();
			messages = null;
			model.setConnected (false);
			gui.updateConnection(model.getName()+" is disconnected");
		} else {
			command = new CommandSession();
			command.open();
			if (command.doConnect (name)) {
				messages = new MessagesSession(name, this);
				messages.open();
				model.setName (name);
				model.setConnected (true);
				gui.updateConnection(model.getName()+" is connected");
			} 
			else {
				command = null;
				gui.updateConnection("could not connect");
			}
		}
	}


	@Override
	public void notifyPartie(List<Piece> blancs, List<Piece> noirs, boolean white) {
		Piece[][] pieces=new Piece[8][8];
		for (int i=0;i<blancs.size();i++)
			pieces[blancs.get(i).getX()][blancs.get(i).getY()]=blancs.get(i);
		for (int i=0;i<noirs.size();i++)
			pieces[noirs.get(i).getX()][noirs.get(i).getY()]=noirs.get(i);
		
		model.setPieces(pieces);
		model.setWhite(white);
		gui.updateChessGame("Game found !");
	}


	public void start () {
		model = new Model ();
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GUI g = new GUI(Application.this, model);
				g.setVisible(true);
				gui = g;
			}
		});
	}

	@Override
	public void notifyMovedPiece(int x, int y, int x2, int y2) {
		model.movePiece(x,y,x2,y2);
		gui.updateMove("Piece moved",x,y,x2,y2);
	}


	@Override
	public void updateConnection(Model model, String status) {
		// TODO Auto-generated method stub

	}


	@Override
	public void notifyPiecesLoad(Model model) {
		// TODO Auto-generated method stub

	}


	@Override
	public void notifyPieceMoved(Model model) {
		// TODO Auto-generated method stub

	}


	@Override
	public void notifyFinder() {
		String name=model.getName();
		if (model.isConnected())
		{
			if (model.isSearching()) {
				command.doFindGame(name,false);
				model.setSearching(false);
				gui.updateSearchingGame("Cancelled game finder");
			} else {
				command = new CommandSession();
				command.open();
				if (command.doFindGame(name,true)) {
					model.setSearching(true);
					gui.updateSearchingGame("Finding game ...");
				} 
				else {
					gui.updateSearchingGame("could not begin searching");	
				}
			}
		}
		else
			gui.updateStatus("Can't do this without being connected");

	}

	public static void main(String[] args) {
		new Application().start();
	}


	@Override
	public void requestMove(int x, int y, int x2, int y2) {
		command.doMove(model.getName(), x, y, x2, y2);
	}


}
