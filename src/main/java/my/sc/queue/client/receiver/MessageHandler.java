package my.sc.queue.client.receiver;

import my.sc.queue.client.Client;
import my.sc.queue.client.Message;

public interface MessageHandler {

	void handleMessage(Message message);
	
	Client getClient();
	
}
