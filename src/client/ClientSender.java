package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ClientSender {
	private Socket connection;

	public ClientSender(Socket socket) {
		connection = socket;

	}

	public void sendCommand(String command) {
		try {
			Writer out = new OutputStreamWriter(connection.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			out.write(command);
			out.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
