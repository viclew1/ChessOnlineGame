package server;

import server.serverdatas.Partie;

public interface NetworkListener {
	
	boolean findGame(String name);
	boolean cancelFinder(String name);
	boolean move(String name, int x, int y, int x2, int y2);
	boolean connectMessagesUser(String userName, MessageSession messageSession);
	boolean connectCommandUser(String name, CommandSession session);
	void processPieces(Partie partie);
	boolean disconnectUser(String name);
	void processMove(Partie partie, int x, int y, int x2, int y2);
}
