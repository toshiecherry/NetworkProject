package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MessageThread extends Thread {
	private GameParticipants players;
	private GameMailbox box;

	public MessageThread(GameParticipants players, GameMailbox box) {
		this.players = players;
	}

	@Override
	public void run() {

		while (true) {
			String s = box.getMessage();
			for (int i = 0; i < players.size(); i++) {
				try {
					BufferedWriter out = new BufferedWriter(
							new OutputStreamWriter(players.getPlayerConnection(i).getOutputStream()));
					out.write(s);
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
