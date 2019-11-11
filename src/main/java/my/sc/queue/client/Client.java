package my.sc.queue.client;

import java.net.URI;
import java.util.Base64;



import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import my.sc.queue.client.receiver.MessageHandler;
import my.sc.queue.client.sender.ResponseMessageHandler;

public class Client {
	
	private int port;
	
	private String host;
	
	private String protocol;
	
	private String username;
	
	private String password;
	
	private String queueName;
	
	private ClientSocket clientSocket;
	
	private ResponseMessageHandler responseMessageHandler;
	
	private MessageHandler messageHandler;
	
	//Sender or receiver.
	private String type;
	
	private Client() {}
	
	public void connect() {
		String dest = this.protocol + "://" + this.host + " : " + this.port + "/queue";
		WebSocketClient client = new WebSocketClient();
		try {
			clientSocket = new ClientSocket();
			client.start();
			URI uri = new URI(dest);
			ClientUpgradeRequest request = new ClientUpgradeRequest();
			
			
			String auth = Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes());
			//Fill in auth string, queue name for which the client establishes the connection and the type of client.
			request.setHeader("Authorization", auth);
			request.setHeader("QueueName", this.queueName);
			request.setHeader("Type", this.type);
			client.connect(clientSocket, uri, request);
		} catch (Throwable t) {
			t.printStackTrace();
		} 
	}
	
	public void sendFile(String filePath) {
		/**
		 * Three operations needs to be done here.
		 * 1. Upload file to the file server.
		 * 2. The file server will return the file meta-data that has uploaded file id and public url of the file that was uploaded.
		 * 3. Attach the public construct the json message with the public url and generated message UUID.
		 * 4. Finally send the message via websocketclient.
		 * 5. Make entry in the SentMessages table.
		 */
		String msg = "{"
				+ "messageId : aab5d5fd-70c1-11e5-a4fb-b026b977eb28, "
				+ "fileUrl : http://localhost:8080/queuefiles/test.txt"
				+ "}";
				
		this.clientSocket.sendMessage(msg);
	}
	
	/**
	 * This should be used by the sender.
	 * @param response
	 */
	public void handleResponse(String response) {
		/**
		 * 1. Parse the json message into ResponseMessage.class.
		 * 2. Update the status in the database.
		 * 3. Delete the entry in the database which will eventually move the record into history table.
		 */
		ResponseMessage message = new ResponseMessage();
		this.responseMessageHandler.handleMessage(message);
	}
	
	/**
	 * This should be used by the receiver.
	 * @param message
	 */
	public void handleMessage(String message) {
		/**
		 * 1. Parse the message into Message.class
		 * 2. Handle the message.
		 */
		Message msg = new Message();
		this.messageHandler.handleMessage(msg);
	}
	
	/**
	 * Method to send plain txt messages
	 * @param filePath
	 */
	public void sendMessage(String str) {

		this.clientSocket.sendMessage(str);
	}
	
	public static class ClientBuilder {
		
		private int port;
		
		private String host;
		
		private String protocol;
		
		private String username;
		
		private String password;
		
		private String queueName;
		
		private String type;
		
		public ClientBuilder port(int port) {
			this.port = port;
			return this;
		}
		
		public ClientBuilder host(String host) {
			this.host = host;
			return this;
		}
		
		public ClientBuilder protocol(String protocol) {
			this.protocol = protocol;
			return this;
		}
		
		public ClientBuilder username(String username) {
			this.username = username;
			return this;
		}
		
		public ClientBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public ClientBuilder queueName(String queueName) {
			this.queueName = queueName;
			return this;
		}
		
		
		public ClientBuilder type(String type) {
			this.type = type;
			return this;
		}
		
		
		public Client build() {
			Client client = new Client();
			client.host = this.host;
			client.password = this.password;
			client.port = this.port;
			client.protocol = this.protocol;
			client.queueName = this.queueName;
			client.username = this.username;
			client.clientSocket = new ClientSocket();
			client.type = this.type;
			return client;
		}
	}
	
	public void setMessageHandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}
	
	public void setResponseMessageHandler(ResponseMessageHandler responseMessageHandler) {
		this.responseMessageHandler = responseMessageHandler;
	}
	
	
	
	public int getPort() {
		return port;
	}

	public String getHost() {
		return host;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getQueueName() {
		return queueName;
	}
	
	public ClientSocket getClientSocket() {
		return clientSocket;
	}
	
	public String getType() {
		return type;
	}
	
	public MessageHandler getMessageHandler() {
		return messageHandler;
	}
	
	public ResponseMessageHandler getResponseMessageHandler() {
		return responseMessageHandler;
	}
	
	
}
