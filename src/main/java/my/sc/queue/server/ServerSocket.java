package my.sc.queue.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ServerSocket {

	//Maintain sender and receiver sessions based on queue name.
	private Map<String, List<Session>> senderSessions = new HashMap<>();
	private Map<String, List<Session>> receiverSessions = new HashMap<>();
	private MessageService messageService = new MessageService(senderSessions, receiverSessions);
	
	@OnWebSocketMessage
	public void onText(Session session, String message) throws IOException {
		String queue = session.getUpgradeRequest().getHeader("QueueName");
		messageService.saveMessage(queue, message);
	}

	@OnWebSocketConnect
	public void onConnect(Session session) throws IOException {
		System.out.println(session.getRemoteAddress().getHostString() + " connected!");
		String auth = session.getUpgradeRequest().getHeader("Authorization");
		//Validate authorization and proceed.
		String type = session.getUpgradeRequest().getHeader("Type");
		//validate type and proceed.
		String queue = session.getUpgradeRequest().getHeader("QueueName");
		
		if(type.equalsIgnoreCase("sender")) {
			if(senderSessions.get(queue) == null)
				senderSessions.put(queue, new ArrayList<Session>());
			senderSessions.get(queue).add(session);
		} else if(type.equalsIgnoreCase("receiver")) {
			if(receiverSessions.get(queue) == null)
				receiverSessions.put(queue, new ArrayList<Session>());
			receiverSessions.get(queue).add(session);			
		}
		
	}

	@OnWebSocketClose
	public void onClose(Session session, int status, String reason) {
		System.out.println(session.getRemoteAddress().getHostString() + " closed!");
	}

}
