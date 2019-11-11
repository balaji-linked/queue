package my.sc.queue.client.receiver;

import my.sc.queue.client.Status;

public class ReceivedMessage {

	private Integer id;
	
	private String messageId;
	
	private String data;
	
	private Status status;
	
	private String responseMessageId;
	
	private String responseMessage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getResponseMessageId() {
		return responseMessageId;
	}

	public void setResponseMessageId(String responseMessageId) {
		this.responseMessageId = responseMessageId;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
	
}
