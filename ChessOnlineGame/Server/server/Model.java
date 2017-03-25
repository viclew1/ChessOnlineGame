package server;

import java.util.ArrayList;
import java.util.List;

import server.serverdatas.Partie;
import server.serverdatas.Player;

public class Model {

	private List<Partie> parties=new ArrayList<Partie>(); 
	private List<Player> players=new ArrayList<Player>();
	
	public List<Partie> getParties() {
		return parties;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public Player getPlayer(String name) {
    	for (Player p : getPlayers()) {
    		if (name.equals(p.getName()))
    			return p;
    	}
    	return null;
    }
}
