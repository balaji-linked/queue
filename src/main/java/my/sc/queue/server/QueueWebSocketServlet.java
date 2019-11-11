package my.sc.queue.server;

import javax.servlet.annotation.WebServlet;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

@WebServlet(urlPatterns="/queue")
public class QueueWebSocketServlet  extends WebSocketServlet{

	@Override
	public void configure(WebSocketServletFactory factory) {
	    factory.register(ServerSocket.class);
	}

}
