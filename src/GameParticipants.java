import java.util.ArrayList;

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
}
