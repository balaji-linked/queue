package my.sc.queue.client.sender;

import my.sc.queue.client.Client;
import my.sc.queue.client.ResponseMessage;

public interface ResponseMessageHandler {

	void handleMessage(ResponseMessage message);
	
	Client getClient();
	
}
