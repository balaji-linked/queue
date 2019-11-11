package my.sc.queue.client.sender;

import java.util.Date;

import my.sc.queue.client.Status;

public class SentMessage {

	private Integer id;
	
	private String messageId;
	
	private int fileId;
	
	private String data;
	
	private Status status;
	
	private String responseMessageId;
	
	private String responseData;
	
	private Date responseReceivedOn;

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

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
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

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public Date getResponseReceivedOn() {
		return responseReceivedOn;
	}

	public void setResponseReceivedOn(Date responseReceivedOn) {
		this.responseReceivedOn = responseReceivedOn;
	}
	
	
	
}
