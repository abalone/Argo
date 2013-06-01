/**
 * 
 */
package com.dihuib.mina.client;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * @author Dihui Bao 
 *
 */
public class ChatClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IoConnector clientConnector = new NioSocketConnector();
		
		clientConnector.setConnectTimeoutMillis(10000);
		
		clientConnector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
		clientConnector.getFilterChain().addLast("logger", new LoggingFilter());
		
		clientConnector.setHandler(new ChatClientHandler("BROADCAST"));
		
		ConnectFuture future = clientConnector.connect(new InetSocketAddress("127.0.0.1",1234));
		
		future.awaitUninterruptibly();
		
		if(!future.isConnected()) {
			return;
		}

		IoSession session = future.getSession();

		session.getConfig().setUseReadOperation(true);
		session.getCloseFuture().awaitUninterruptibly();
		clientConnector.dispose();

	}

}
