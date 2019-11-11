package my.sc.queue.client.sender;



public interface SentMessageService {

	SentMessage saveSentMessage(SentMessage SentMessage);
	
	SentMessage getSentMessage(int recordId);
	
	void updateSentMessage(SentMessage updatedSentMessage);
	
	void deleteSentMessage(int recordId);
	
}
