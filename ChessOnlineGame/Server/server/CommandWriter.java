package server;

import java.io.OutputStream;

import common.Protocol;
import common.Writer;

public class CommandWriter extends Writer{

	public CommandWriter(OutputStream outputStream) {
		super(outputStream);
	}

	public void ok()
	{
		writeInt(Protocol.RP_OK);
	}
	
	public void ko()
	{
		writeInt(Protocol.RP_KO);
	}

}
