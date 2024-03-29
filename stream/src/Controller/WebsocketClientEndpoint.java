package Controller;

import java.net.URI;
import javax.websocket.*;

/**
 * @author Ahmednasser
 *
 */
@ClientEndpoint
public class WebsocketClientEndpoint {
	Session userSession = null;
	private MessageHandler messageHandler;

	public WebsocketClientEndpoint(URI endpointURI) {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(this, endpointURI);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@OnOpen
	public void onOpen(Session userSession) {
		System.err.println("opening websocket");
		this.userSession = userSession;
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		System.err.println("closing websocket");
		this.userSession = null;
	}

	@OnMessage
	public void onMessage(String message) {
		if (this.messageHandler != null) {
			this.messageHandler.handleMessage(message);
		}
	}

	public void addMessageHandler(MessageHandler msgHandler) {
		this.messageHandler = msgHandler;
	}

	public void sendMessage(String message) {
		this.userSession.getAsyncRemote().sendText(message);
	}

	public static interface MessageHandler {

		public void handleMessage(String message);
	}
}