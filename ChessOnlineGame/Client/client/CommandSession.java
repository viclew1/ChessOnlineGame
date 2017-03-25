package client;

import java.net.InetAddress;
import java.net.Socket;
import common.Protocol;


public class CommandSession {

	private Socket connection;
	
	public CommandSession () {
	}

	public boolean close () {
		try {
			if (connection != null) connection.close();
			connection = null;
		} catch (Exception e) {
		}
		return true;
	}
	
	public boolean open () {
		this.close();
		try {
			connection = new Socket(InetAddress.getLocalHost().getHostAddress(), Protocol.COMMAND_PORT);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean doDisconnect(String name) {
		try {
			CommandWriter w = new CommandWriter(connection.getOutputStream());
			w.disconnect(name);
			w.send();
			CommandReader r = new CommandReader(connection.getInputStream());
			r.receive();
			return r.getDone();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean doConnect (String name) {
		try {
			CommandWriter w = new CommandWriter(connection.getOutputStream());
			w.connect(name);
			w.send();
			CommandReader r = new CommandReader(connection.getInputStream());
			r.receive();
			return r.getDone();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean doMove (String name, int x1, int y1, int x2, int y2) {
		try {
			CommandWriter w = new CommandWriter(connection.getOutputStream());
			w.move(name,x1,y1,x2,y2);
			w.send();
			CommandReader r = new CommandReader(connection.getInputStream());
			r.receive();
			return r.getDone();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean doFindGame(String name, boolean start) {
		try {
			CommandWriter w = new CommandWriter(connection.getOutputStream());
			w.findGame(name,start);
			w.send();
			CommandReader r = new CommandReader(connection.getInputStream());
			r.receive();
			return r.getDone();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
