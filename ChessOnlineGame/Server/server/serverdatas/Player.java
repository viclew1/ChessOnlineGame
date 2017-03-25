package server.serverdatas;

import server.CommandSession;
import server.MessageSession;

public class Player {
	
	private String name;
	private boolean waiting;
	private CommandSession commandSession;
	private MessageSession messageSession;
	private boolean white;
	
	public Player(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public CommandSession getCommandSession()
	{
		return commandSession;
	}
	
	public void setCommandSession(CommandSession cs)
	{
		if (commandSession!=null) commandSession.close();
		this.commandSession=cs;
	}

	public void setWaiting(boolean waiting) {
		this.waiting=waiting;
	}

	public boolean getWaiting() {
		return waiting;
	}

	public MessageSession getMessageSession() {
		return messageSession;
	}

	public void setMessageSession(MessageSession message) {
		if (messageSession!=null) messageSession.close();
		this.messageSession = message;
	}
	
	public boolean isConnected() {
		return commandSession != null;
	}

	public boolean isWhite() {
		return white;
	}
	
	public void setWhite(boolean white){
		this.white=white;
	}
}
