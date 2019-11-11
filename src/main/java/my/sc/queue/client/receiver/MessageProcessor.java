package my.sc.queue.client.receiver;

import java.io.File;
import java.util.concurrent.Callable;

import my.sc.queue.client.Client;
import my.sc.queue.client.Message;
import my.sc.queue.client.Status;

public class MessageProcessor implements Callable<Void> {

	private Message message;
	private Client client;
	private ReceivedMessageService receivedMessageService;
	
	public MessageProcessor(Message message, Client client, ReceivedMessageService receivedMessageService) {
		this.message = message;
		this.client = client;
		this.receivedMessageService = receivedMessageService;
	}
	
	@Override
	public Void call() throws Exception {
		
		String url = "";//Extract file url from the json data.
		String fileName = "";//Extract file name from the url;
		
		//TODO - Download file from url and write it to local disk with the fileName.
		 
		File file = null;//The written file.
		
		// Create ReceivedMessageService from message.
		
		ReceivedMessage receivedMessage = new ReceivedMessage(); //dummy.
		
		//save received message to db.
		receivedMessageService.saveReceivedMessage(receivedMessage);
		
		//Chose the right file processor.
		FileProcessor fileProcessor = FileProcessorFactory.createFileProcessor(fileName);
		fileProcessor.processFile(file);
		String responseMessage = "{"
				+ "responsemessageid : XXX ,"
				+ "messageid : " + message.getMessageId()
				+ "status : success"
				+ "}";
		
		//send response via client
		
		client.sendMessage(responseMessage);
		
		
		//update ReceivedMessageService status and message.
		receivedMessage.setStatus(Status.SENT);
		receivedMessageService.updateReceivedMessage(receivedMessage);
		
		//delete ReceivedMessageService so that it moves to history.
		receivedMessageService.deleteReceivedMessage(receivedMessage.getId());
		return null;
	}
	
}
