/**
 * 
 */
package com.dihuib.mina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dihui Bao 
 *
 */
public class ChatClientHandler extends IoHandlerAdapter {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	
	private final String values;
	
	public ChatClientHandler(String values) {
		this.values = values;
	}
	
	@Override
	public void sessionOpened(IoSession session)
	{
		System.out.println("session open");
		session.write(values);
	}

	@Override
	public void messageReceived(IoSession session, Object message)
	{
		logger.info("Message received in the client..");
		logger.info("Message is: " + message.toString());
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
	{
	session.close();
	}
}
