package server;

import java.io.InputStream;

import common.Protocol;
import common.Reader;

public class CommandReader extends Reader{

	private String name;
	private int x1,y1,x2,y2;
	private boolean startResearch;

	public CommandReader(InputStream inputStream) {
		super(inputStream);
	}

	public void receive()
	{
		type=readInt();
		switch(type)
		{
		case Protocol.RQ_CONNECT:
			name=readString();
			break;
		case Protocol.RQ_DISCONNECT:
			name=readString();
			break;
		case Protocol.RQ_FIND_GAME:
			name=readString();
			startResearch=readBoolean();
			break;
		case Protocol.RQ_MOVE:
			name=readString();
			x1=readInt();
			y1=readInt();
			x2=readInt();
			y2=readInt();
			
			break;
		default:
			break;

		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public int x1()
	{
		return x1;
	}
	
	public int y1()
	{
		return y1;
	}
	
	public int x2()
	{
		return x2;
	}
	
	public int y2()
	{
		return y2;
	}

	public boolean getStartResearch() {
		return startResearch;
	}

}
