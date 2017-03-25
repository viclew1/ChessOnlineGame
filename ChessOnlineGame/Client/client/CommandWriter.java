package client;

import java.io.OutputStream;

import common.Protocol;
import common.Writer;

public class CommandWriter extends Writer {

	public CommandWriter(OutputStream outputStream) {
		super (outputStream);
	}

	public void connect(String name) {
		writeInt(Protocol.RQ_CONNECT);
		writeString(name);
	}
	
	public void disconnect(String name) {
		writeInt(Protocol.RQ_DISCONNECT);
		writeString(name);
	}

	public void move(String name, int x1, int y1, int x2, int y2)
	{
		writeInt(Protocol.RQ_MOVE);
		writeString(name);
		writeInt(x1);
		writeInt(y1);
		writeInt(x2);
		writeInt(y2);
	}
	
	public void getPieces()
	{
		writeInt(Protocol.RQ_PIECES);
	}

	public void findGame(String name, boolean start) {
		writeInt(Protocol.RQ_FIND_GAME);
		writeString(name);
		writeBoolean(start);
	}

}
