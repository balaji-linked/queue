package my.sc.queue.client.sender;



public interface SentMessageService {

	SentMessage saveSentMessage(SentMessage SentMessage);
	
	SentMessage getSentMessage(int recordId);
	
	SentMessage getSentMessageByMessageId(String messageId);
	
	void updateSentMessage(SentMessage updatedSentMessage);
	
	void deleteSentMessage(int recordId);
	
}
