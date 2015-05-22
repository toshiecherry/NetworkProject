package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.Socket;

public class ClientSender {
	private Socket connection;
	private OutputStreamWriter out;
	private BufferedReader in;
	private boolean gameStarted;

	public ClientSender(Socket socket, ClientHandler handler) {
		connection = socket;
		gameStarted = false;
		try {
			out = new OutputStreamWriter(connection.getOutputStream());
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			out.write(handler.getPlayerName() + "\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String sendCommand(String command) {
		try {
			out.write(command);
			out.flush();
			String read = in.readLine();
			return read;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String[] startGame() {
		if (!gameStarted) {
			try {
				out.write("StartGame \n");
				out.flush();
				String[] read = new String[4];
				for (int i = 0; i < 4; i++) {
					read[i] = in.readLine();
				}
				gameStarted = true;
				return read;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;

	}

	public void leaveGame() {
		gameStarted = false;
	}

}
