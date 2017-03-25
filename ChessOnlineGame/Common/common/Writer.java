package common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Writer {

	protected OutputStream outputStream;
	private ByteArrayOutputStream baos=new ByteArrayOutputStream();
	private DataOutputStream dos=new DataOutputStream(baos);

	public Writer(OutputStream outputStream) 
	{
		this.outputStream=outputStream;
	}

	protected void writeInt(int i)
	{
		try {
			dos.writeInt(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void writeString(String s)
	{
		try {
			dos.writeUTF(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void writeBoolean(boolean b)
	{
		try {
			if (b)
				dos.writeInt(1);
			else
				dos.writeInt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send()
	{
		byte[] message=baos.toByteArray();
		try{
			outputStream.write(message);
			outputStream.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
