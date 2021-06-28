package org.sticker.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/WebSocket/WebSocket.html
 *
 */
@ServerEndpoint(value = "/story/notifications", encoders = { StickerEncoder.class }, decoders = {
		StickerDecoder.class })
public class StoryWebSocket {

	private static final List<Sticker> stickers = Collections.synchronizedList(new LinkedList<Sticker>());
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	public StoryWebSocket() {
		// TODO Auto-generated constructor stub
	}

	@OnMessage
	public void onMessage(Session session, Sticker sticker) {
		System.out.println("onMessage : "+sticker.getImage());
		stickers.add(sticker);
		for (Session openSession : sessions) {
			try {
				openSession.getBasicRemote().sendObject(sticker);
			} catch (Exception e) {
				e.printStackTrace(System.out);
				sessions.remove(session);
			}
		}
	}

	@OnOpen
	public void onOpen(Session session) throws IOException, EncodeException {
		System.out.println("onOpen : "+session.getId());
		sessions.add(session);
		for (Sticker sticker : stickers) {
			session.getBasicRemote().sendObject(sticker);
		}
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
