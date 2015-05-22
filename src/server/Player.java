package server;

import java.net.Socket;

public class Player {
	private String playerName;
	private Socket connection;

	public Player(String playerName, Socket connection) {
		this.playerName = playerName;
		this.connection = connection;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Socket getConnection() {
		return connection;
	}

}
