package my.sc.queue.client;

public class ResponseMessage {

	private String messageId;
	
	private String responseMessageId;
	
	private boolean success;
	
	private String message;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getResponseMessageId() {
		return responseMessageId;
	}

	public void setResponseMessageId(String responseMessageId) {
		this.responseMessageId = responseMessageId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
