package server;

import server.serverdatas.Partie;
import server.serverdatas.Player;

public class Application implements NetworkListener {


	private CommandServer commands = null;
	private MessageServer message = null;
	private Model model;

	public static void main(String[] args) {
		Application m = new Application ();
		m.start();
	}

	public void start () {
		commands = new CommandServer(this);
		message = new MessageServer(this);
		model=new Model();
		commands.start();
		message.start();
	}

	@Override
	public boolean findGame(String name) {
		Player p=model.getPlayer(name);
		if (p==null)
			return false;
		if (!p.isConnected())
			return false;
		for (int i=0;i<model.getPlayers().size();i++)
			if (model.getPlayers().get(i).getWaiting())
			{
				createGame(p,model.getPlayers().get(i));
				return true;
			}
		p.setWaiting(true);
		return true;
	}

	@Override
	public boolean cancelFinder(String name){
		Player p=model.getPlayer(name);
		if (p==null)
			return false;
		if (!p.isConnected())
			return false;
		p.setWaiting(false);
		return true;
	}

	@Override
	public boolean connectCommandUser(String name, CommandSession session) {
		Player player = model.getPlayer(name);
		if (player == null)
		{
			player=new Player(name);
			model.getPlayers().add(player);
		}
		if (player.isConnected()) return false;
		player.setCommandSession(session);
		return true;
	}

	@Override
	public boolean connectMessagesUser(String name, MessageSession session) {
		Player player = model.getPlayer(name);
		if (player == null)
		{
			player=new Player(name);
			model.getPlayers().add(player);
		}
		if (!player.isConnected()) return false;
		player.setMessageSession(session);
		return true;

	}

	public void createGame(Player p1, Player p2) {
		p1.setWaiting(false);
		p2.setWaiting(false);

		int rdm=(int)(Math.random()*100);
		p1.setWhite(rdm%2==0);
		p2.setWhite(!p1.isWhite());

		Partie partie=new Partie(p1,p2);
		model.getParties().add(partie);
		processPieces(partie);
	}

	@Override
	public boolean move(String name, int x, int y, int x2, int y2) {
		Partie partie=null;
		for (int i=0;i<model.getParties().size();i++)
			if (model.getParties().get(i).getP1().getName().equals(name) || model.getParties().get(i).getP2().getName().equals(name))
				partie=model.getParties().get(i);
		if (partie.getPlayer(name).isWhite()!=partie.getPieces()[x][y].white())
			return false;
		if (partie.whiteTurn()!=partie.getPlayer(name).isWhite())
			return false;
		boolean canMoveHere=false;
		for (int i=0;i<partie.getPieces()[x][y].getFilteredDests(partie.getPieces()).size();i++)
			if (partie.getPieces()[x][y].getFilteredDests(partie.getPieces()).get(i).x==x2 && partie.getPieces()[x][y].getFilteredDests(partie.getPieces()).get(i).y==y2)
				canMoveHere=true;
		if (!canMoveHere)
			return false;

		partie.movePiece(x, y, x2, y2);
		processMove(partie,x,y,x2,y2);
		return true;

	}

	@Override
	public void processMove(Partie partie, int x, int y, int x2, int y2) {
		try{
			partie.getP1().getMessageSession().dispatchMovedPiece(x,y,x2,y2);
		}
		catch(Exception e)
		{
			
		}
		try{
			partie.getP2().getMessageSession().dispatchMovedPiece(x,y,x2,y2);
		}
		catch(Exception e)
		{

		}
	}

	@Override
	public void processPieces(Partie partie) {
		partie.getP1().getMessageSession().dispatchPieces(partie.blancs().getPieces(),partie.noirs().getPieces(),partie.getP1().isWhite());
		partie.getP2().getMessageSession().dispatchPieces(partie.blancs().getPieces(),partie.noirs().getPieces(),partie.getP2().isWhite());
	}

	@Override
	public boolean disconnectUser(String name) {
		Player player = model.getPlayer(name);
		if (player == null) return false;
		if (! player .isConnected()) return false;
		player.setCommandSession(null);
		player.setMessageSession(null);
		return true;
	}




}
