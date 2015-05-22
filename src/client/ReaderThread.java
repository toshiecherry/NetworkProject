package client;

import gui.GameMonitor;

public class ReaderThread extends Thread {
	private GameMonitor monitor;
	
	public ReaderThread(GameMonitor gameMonitor){
		monitor = gameMonitor;
	}

	@Override
	public void run() {
		monitor.errorMessage("");
	}
}
