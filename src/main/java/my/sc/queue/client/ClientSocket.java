package my.sc.queue.client;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ClientSocket {

	private Session session;
	
	@OnWebSocketMessage
	public void onText(Session session, String message) throws IOException {
		System.out.println("Message received from server:" + message);
	}

	@OnWebSocketConnect
	public void onConnect(Session session) {
		System.out.println("Connected to server");
		this.session=session;
	}
	
	public void sendMessage(String str) {
			try {
				session.getRemote().sendString(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	

}
