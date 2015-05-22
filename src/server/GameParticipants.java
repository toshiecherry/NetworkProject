package server;

import java.util.ArrayList;

/* 
 * Lista med namn på deltagarna. Beroende på vart i listan namnet på en deltagare ligger får de ett index.
 */
public class GameParticipants {
	private ArrayList<String> participants;

	public GameParticipants() {
		participants = new ArrayList<String>();
	}

	public boolean add(String name) {
		if (participants.size() < 4) {
			participants.add(name);
			return true;
		}
		return false;
	}

	public int getIndex(String playerName) {
		return participants.indexOf(playerName);
	}

	public void removePlayer(String playerName) {
		if (participants.contains(playerName)) {
			participants.remove(playerName);
		}
	}

	public int size() {
		return participants.size();
	}
}
