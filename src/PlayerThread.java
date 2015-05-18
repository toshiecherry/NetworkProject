import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

import cards.CardPiles;

public class PlayerThread extends Thread {
	private Socket connection;
	private boolean moreRequests;
	private CardPiles piles;

	public PlayerThread(Socket connection, CardPiles piles) {
		this.connection = connection;
	}

	@Override
	public void run() {
		try {
			System.out.println(connection.getInetAddress());
			Writer out = new OutputStreamWriter(connection.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			moreRequests = true;
			while (moreRequests) {
				String input = in.readLine();

				if (input.charAt(0) == 'Q') {
					moreRequests = false;
				} else if (input.charAt(0) == 'M') {
					String message = input.substring(2);
					System.out.println(message);
					Scanner scan = new Scanner(System.in);
					String s = scan.nextLine();
					out.write(s.toString() + "\r\n");
					out.flush();
				} else if (input.charAt(0) == 'E') {
					out.write(input + "\r\n");
					out.flush();
				} else if (input != null) {
					out.write("command not found: " + input + "\r\n");
					out.flush();
				}
			}
			connection.close();

		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
