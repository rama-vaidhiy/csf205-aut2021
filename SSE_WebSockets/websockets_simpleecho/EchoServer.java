import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoServer {

	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	public EchoServer() {
	}
	
	@OnMessage
	public void onMessage(Session session, String incomingMessage)
	{
		System.out.println("onMessage " +session.getId()+" with message : "+incomingMessage);
		if(null!=sessions && !(sessions.isEmpty()))
		{
			for (Session openSession : sessions) {
				try {
					openSession.getBasicRemote().sendText("Echoed : "+incomingMessage+"\n");
				} catch (Exception e) {
					e.printStackTrace(System.out);
					sessions.remove(session);
				}
			}
		}
		
	}

	
	@OnOpen
	public void onOpen(Session session) throws IOException, EncodeException {
		System.out.println("onOpen : "+session.getId());
		sessions.add(session);
		session.getBasicRemote().sendText("Welcome to Echo WebSocket Server\n");
		
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose : "+session.getId());
		sessions.remove(session);
	}

	
	@OnError
	public void onError(Session session, Throwable thr) {
		System.out.println(thr.getLocalizedMessage()+" on session "+session);
	}
	
	
}
