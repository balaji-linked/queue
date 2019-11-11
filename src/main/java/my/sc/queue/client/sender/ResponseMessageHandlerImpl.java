package my.sc.queue.client.sender;

import my.sc.queue.client.Client;
import my.sc.queue.client.ResponseMessage;
import my.sc.queue.client.Status;

public class ResponseMessageHandlerImpl implements ResponseMessageHandler {

	private Client client;
	
	private SentMessageService sentMessageService;
	
	public ResponseMessageHandlerImpl(Client client, SentMessageService sentMessageService) {
		this.client = client;
		this.sentMessageService = sentMessageService;
	}
	
	@Override
	public void handleMessage(ResponseMessage message) {
		/**
		 * 
		 * 1. Update the status in the database.
		 * 2. Delete the entry in the database which will eventually move the record into history table.
		 */
		
		//retrieve the old message
		SentMessage sentMessage = sentMessageService.getSentMessageByMessageId(message.getMessageId());
		
		//update the message
		sentMessage.setStatus(Status.RECEIVED);
		this.sentMessageService.updateSentMessage(sentMessage);
		
		sentMessage.setResponseData(message.toString());
		sentMessage.setResponseMessageId(message.getResponseMessageId());
		
		//handle error condition.
		if(message.getErrorCode() == null)
			sentMessage.setStatus(Status.SUCCESS);
		else {
			sentMessage.setStatus(Status.ERROR);
		}
		this.sentMessageService.updateSentMessage(sentMessage);
		//Delete with the last and final state so that the record can go into history.
		this.sentMessageService.deleteSentMessage(sentMessage.getId());
			
		
	}
	
	@Override
	public Client getClient() {
		
		return client;
	}
	
}
