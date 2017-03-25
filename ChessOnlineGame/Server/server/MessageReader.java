package server;

import java.io.InputStream;

import common.Protocol;
import common.Reader;

public class MessageReader extends Reader {

	private String userName;

	public MessageReader(InputStream inputStream) {
		super (inputStream);
	}

	public void receive() {
		type = readInt ();
		switch (type) {
		case Protocol.RQ_CONNECT:
			userName=readString();
			break;	
		default:
			break;
		}
	}

	public String getUserName() {
		return userName;
	}
	
}
