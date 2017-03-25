package server;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import common.Protocol;
import pieces.Piece;

public class MessageSession {

	private Socket connection;
	private NetworkListener listener;
	
	public MessageSession(Socket connection, NetworkListener listener) {
		this.connection = connection;
		this.listener = listener;
		if( listener == null) throw new RuntimeException("listener cannot be null");
	}

	public void close () {
		try {
			if (connection != null)
				connection.close();
		} catch (IOException e) {
		}
		connection = null;
	}

	public boolean processConnection () {
		try {
			MessageReader reader = new MessageReader(connection.getInputStream());
			reader.receive();
			switch (reader.getType()) {
			case Protocol.RQ_CONNECT:
				listener.connectMessagesUser(reader.getUserName(), this);
				break;

			default:
				break;
			}
			return false;
		}
		catch (Exception e) {
		}
		return false;
	}

	public boolean dispatchPieces (List<Piece> blancs, List<Piece> noirs, boolean white) {
		try {
			MessageWriter w = new MessageWriter(connection.getOutputStream());
			w.doDispatchPieces(blancs,noirs,white);
			w.send();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	public boolean dispatchMovedPiece(int x, int y, int x2, int y2) {
		try {
			MessageWriter w = new MessageWriter(connection.getOutputStream());
			w.doDispatchMovedPiece(x,y,x2,y2);
			w.send();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

}
