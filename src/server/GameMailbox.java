package server;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class GameMailbox {
	private String message;
	private ArrayList<String> playerList;

	public GameMailbox() {
		playerList = new ArrayList<String>();
		message = " ";
	}
	
	public void addPlayer(String playerName, InetAddress address){
		playerList.add(playerName + " " + address.toString());
	}
	
	
	public void run(){
		try{
			while(true){
//				String state = gamestate.getGameState();
//				System.out.println("State:\t" + state);
				for(int i = 0; i< playerList.size(); i++){
					
//					writeCmds(players);
				}
				
			}

		}catch(Exception e){
			
		}
	}

	public synchronized void setMessage(String newMessage) {
		while (message != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		message = newMessage;
		notifyAll();
	}

	public synchronized String getMessage() {
		while (message == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String m = message;
		message = null;
		notifyAll();
		return m;
	}

}
