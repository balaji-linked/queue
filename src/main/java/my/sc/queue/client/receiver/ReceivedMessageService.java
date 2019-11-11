package my.sc.queue.client.receiver;

public interface ReceivedMessageService {

	ReceivedMessage saveReceivedMessage(ReceivedMessage receivedMessage);
	
	ReceivedMessage getReceivedMessage(int recordId);
	
	void updateReceivedMessage(ReceivedMessage updatedReceivedMessage);
	
	void deleteReceivedMessage(int recordId);
	
}
