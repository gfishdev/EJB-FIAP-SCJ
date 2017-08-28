package br.com.fiap;

import java.util.Date;

import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class Teste {

	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
        QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("java:/ConnectionFactory");
        QueueConnection connection = factory.createQueueConnection();
        QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE); 
        Queue queue = (Queue) context.lookup("queue/Fax");
        
        //MapMessage message = session.createMapMessage();
        //message.setString("nome", "Albert");
        //message.setLong("codigo", 355L);
        //QueueSender sender = session.createSender(queue);
        //sender.send(message);
        
        TextMessage msg = session.createTextMessage();
        msg.setText("mensagem " + new Date());
        MessageProducer producer = session.createProducer(queue);
        
        //coloca mensagem na fila
        producer.send(msg);
        
        System.out.println("Fax enviado");
	}
}
