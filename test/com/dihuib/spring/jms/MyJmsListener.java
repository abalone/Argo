/**
 * 
 */
package com.dihuib.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Dihui Bao 
 *
 */
public class MyJmsListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				System.out.println(((TextMessage)message).getText());
			}
			catch (JMSException ex) {
				throw new RuntimeException(ex);
			}
		}
		
	}

}
