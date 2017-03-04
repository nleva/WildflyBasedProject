package ru.spec.java.ejb.WildflyProject.websocket;

import java.util.Date;
import java.util.Set;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.websocket.CloseReason;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.Path;

class MyDecoder implements Decoder.Text<Date>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date decode(String arg0) throws DecodeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean willDecode(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

class MyEncoder implements Encoder.Text<Date>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(Date arg0) throws EncodeException {
		return arg0.toString();
	}
	
}

@Singleton
@ServerEndpoint(value="/sock" , 
			decoders={},
			encoders={})
public class MyWebsocket {
	
	@Inject Event<Object> bus;
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig endpointConfig) {
		Set<Session> openSessions = session.getOpenSessions();
		
	}
	

	@OnMessage
	public String echo(String message) {
		
		//o = objectMapper.parse(message);
		//
//		bus.fire(o);
		return "re: " + message;
	}
	@OnMessage
	public Date echo(Date message) {
		return new Date();
	}
	
	@OnMessage
	public void onMessage(byte[] message) {
		// TODO Auto-generated method stub
	}
	
	@OnMessage
	public void onMessage(PongMessage message) {
		// TODO Auto-generated method stub
	}
	
	
	
	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		
	}
	
	

}
