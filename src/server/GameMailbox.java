package server;

public class GameMailbox {
	private String message;

	public GameMailbox() {
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
