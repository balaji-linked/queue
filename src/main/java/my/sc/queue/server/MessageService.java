package my.sc.queue.server;


import java.util.List;
import java.util.Map;


import org.eclipse.jetty.websocket.api.Session;

public class MessageService {
	
	//Maintain sender and receiver sessions based on queue name.
	private Map<String, List<Session>> senderSessions;
	private Map<String, List<Session>> receiverSessions;
	private ProcessMessages processMessages = new ProcessMessages(receiverSessions);
	public MessageService(Map<String, List<Session>> senderSessions, Map<String, List<Session>> receiverSessions) {
		this.senderSessions = senderSessions;
		this.receiverSessions = receiverSessions;
		startProcessingMessages(receiverSessions);
		
	}
	
	public void saveMessage(String queue, String data) {
		/**
		 * 1. Retrieve queue from the Database.
		 * 2. Form Message object with queue and data.
		 * 3. Save Message to Message table.
		 */
	}
	
	public void startProcessingMessages(Map<String, List<Session>> receiverSessions) {
		/**
		 * Just start processing the messages as a separate thread so that it runs independently.
		 */
		
		if(!processMessages.isRunning()) {
			Thread messageProcessorThread = new Thread(processMessages);
			messageProcessorThread.start();
		}
	}
	
	public void stopProcessingMessages() {
		processMessages.stopProcessing();
	}
	
	
	
	
	
}
