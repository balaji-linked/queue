package my.sc.queue.server;

import java.util.List;
import java.util.Map;

import org.eclipse.jetty.websocket.api.Session;

public class ProcessMessages implements Runnable {
	private Map<String, List<Session>> receiverSessions;
	private boolean running = false;
	public ProcessMessages(Map<String, List<Session>> receiverSessions) {
		this.receiverSessions = receiverSessions;
		
	}
	
	
	
	@Override
	public void run() {
		running = true;
		while(true) {
			/**
			 * 1. Continuously look for records in the Message table.
			 * 2. Retrieve them in batches.
			 * 3. process each message.
			 * 4. If no records found, sleep for sometime and check again.
			 * 5. This thread should stopped be if interrupted.
			 */
			
			if(!running) {
				break;
			}

		}
		
		

	}
	
	public boolean isRunning() {
		return running;
	}
	
	public void stopProcessing() {
		this.running = false;
	}
	
	private void processMessage(Message message) {
		
		/**
		 * 1. From the message, get the queue.
		 * 2. Get the receiver from the queue.
		 * 3. Get the list of sessions of the receiver from the map above.
		 * 4. Pick a random session and write data to that session.
		 */
		
	}

}
