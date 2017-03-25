package common;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Reader {
	
	protected DataInputStream inputStream;
	protected int type;

	public Reader(InputStream inputStream) 
	{
		this.inputStream=new DataInputStream(inputStream);
	}
	
	public int getType()
	{
		return type;
	}
	
	protected boolean readBoolean()
	{
		try{
			int i=inputStream.readInt();
			if (i!=0)
				return true;
			return false;
		}
		catch(IOException e)
		{
			return false;
		}
	}
	
	protected int readInt()
	{
		try {
			return inputStream.readInt();
		} catch (IOException e) {
			return 0;
		}
	}
	
	protected String readString()
	{
		try {
			return inputStream.readUTF();
		} catch (IOException e) {
			return "";
		}
	}
}
