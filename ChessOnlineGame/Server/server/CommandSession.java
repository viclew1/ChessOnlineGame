package server;

import java.io.IOException;
import java.net.Socket;

import common.Protocol;

public class CommandSession extends Thread{

	private Socket connection;
	private NetworkListener listener;

	public CommandSession(Socket connection, NetworkListener listener) {
		this.connection = connection;
		this.listener = listener;
		if( listener == null) throw new RuntimeException("listener cannot be null");
	}

	public boolean operate() {
		try {
			CommandWriter writer = new CommandWriter (connection.getOutputStream());
			CommandReader reader = new CommandReader (connection.getInputStream());
			reader.receive ();

			switch (reader.getType ()) {
			case 0 : return false; // socket closed
			case Protocol.RQ_CONNECT:
				if (listener.connectCommandUser(reader.getName(), this))
					writer.ok();
				else writer.ko();
				break;
			case Protocol.RQ_DISCONNECT:
				if (listener.disconnectUser(reader.getName()))
					writer.ok();
				else writer.ko();
				break;
			case Protocol.RQ_MOVE:
				if (listener.move(reader.getName(), reader.x1(), reader.y1(), reader.x2(), reader.y2()))
					writer.ok();
				else writer.ko();
				break;
			case Protocol.RQ_FIND_GAME:
				if (reader.getStartResearch())
					if (listener.findGame(reader.getName()))
						writer.ok();
					else writer.ko();
				else
					if (listener.cancelFinder(reader.getName()))
						writer.ok();
					else writer.ko();
				break;
			case -1 : break;
			default: return false; // connection jammed
			}
			writer.send ();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public void run() {
		while (true) {
			if (! operate())
				break;
		}
		try {
			if (connection != null) connection.close();
		} catch (IOException e) {
		}
	}

	public void close () {
		this.interrupt();
		try {
			if (connection != null)
				connection.close();
		} catch (IOException e) {
		}
		connection = null;
	}

}
