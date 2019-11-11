package my.sc.queue.client.sender;

import my.sc.queue.client.Client;
import my.sc.queue.client.ResponseMessage;

public class ResponseMessageHandlerImpl implements ResponseMessageHandler {

	private Client client;
	
	public ResponseMessageHandlerImpl(Client client) {
		this.client = client;
	}
	
	@Override
	public void handleMessage(ResponseMessage message) {
		/**
		 * 1. Parse the json message into ResponseMessage.class
		 * 2. Update the status in the database.
		 * 3. Delete the entry in the database which will eventually move the record into history table.
		 */
	}
	
	@Override
	public Client getClient() {
		
		return client;
	}
	
}
