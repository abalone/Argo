/**
 * 
 */
package com.dihuib.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Dihui Bao 
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/dihuib/spring/jms/appContext.xml"})
public class SpringJmsTest {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Test
	public void testSimpleSendMessage() {
		this.jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("hello queue world");
			}
			
		}) ;
	}
}
