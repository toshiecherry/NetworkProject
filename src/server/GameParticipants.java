package server;

import java.net.Socket;
import java.util.ArrayList;

/* 
 * Lista med namn på deltagarna. Beroende på vart i listan namnet på en deltagare ligger får de ett index.
 */
public class GameParticipants {
	private ArrayList<Player> participants;

	public GameParticipants() {
		participants = new ArrayList<Player>();
	}

	public synchronized boolean add(Player name) {
		if (participants.size() < 4) {
			participants.add(name);
			notifyAll();
			return true;
		}
		return false;
	}

	public int getIndex(Player playerName) {
		return participants.indexOf(playerName);
	}

	public void removePlayer(Player playerName) {
		if (participants.contains(playerName)) {
			participants.remove(playerName);
		}
	}
	
	public Socket getPlayerConnection(int index){
		return participants.get(index).getConnection();
	}

	public int size() {
		return participants.size();
	}
}
