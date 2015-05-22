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

	public ClientSender(Socket socket, String name) {
		connection = socket;
		gameStarted = false;
		try {
			out = new OutputStreamWriter(connection.getOutputStream());
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			out.write(name + "\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String drawCard() {
		try {
			out.write("DrawCard \n");
			out.flush();
			String read = in.readLine();
			return read;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void throwCard(String card) {
		try {
			out.write("TrowCard \n" + card + "\n");
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
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
		try {
			out.write("LeaveGame \n");
			out.flush();
			gameStarted = false;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean gotBubblan() {
		try {
			out.write("GotBubblan");
			out.flush();
			String s = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

}
