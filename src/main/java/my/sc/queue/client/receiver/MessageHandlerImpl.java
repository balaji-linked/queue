package my.sc.queue.client.receiver;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import my.sc.queue.client.Client;
import my.sc.queue.client.Message;

public class MessageHandlerImpl implements MessageHandler {

	private Client client;
	
	ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
	
	private ReceivedMessageService receivedMessageService;
	
	public MessageHandlerImpl(Client client, ReceivedMessageService receivedMessageService) {
		this.client = client;
		this.receivedMessageService = receivedMessageService;
	}
	
	@Override
	public void handleMessage(Message message) {
		MessageProcessor processor = new MessageProcessor(message, client, receivedMessageService);
		executor.submit(processor);
	}
	
	public Client getClient() {
		return client;
	}

}
