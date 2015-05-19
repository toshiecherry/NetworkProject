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
	
	public int getIndex(String player){
		return participants.indexOf(player);
	}
}
