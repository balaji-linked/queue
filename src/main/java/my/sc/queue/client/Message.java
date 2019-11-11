package my.sc.queue.client;

public class Message {

	private String messageId;
	
	private String fileUrl;
	
	public Message(String messageId, String fileUrl) {
		this.messageId = messageId;
		this.fileUrl = fileUrl;
	}
	
	/**
	 * Dummy constructor.
	 */
	public Message() {}
	
	public String getMessageId() {
		return messageId;
	}
	
	public String getFileUrl() {
		return fileUrl;
	}
	
}
