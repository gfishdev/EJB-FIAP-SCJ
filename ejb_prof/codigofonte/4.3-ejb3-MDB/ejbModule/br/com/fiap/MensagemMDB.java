package br.com.fiap;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/Fax") })
public class MensagemMDB implements MessageListener {

	@Resource
	private MessageDrivenContext context;

	public void onMessage(Message message) {
		System.out
				.println("******************************************************");
		System.out.println(" Mensagem FAX recebida.");
		System.out
				.println("******************************************************");
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("Iniciando processamento da mensagem: "
						+ text);
				Thread.sleep(2000);
				System.out.println("Processamento da mensagem [" + text
						+ "] concluido.");
			} else {
				System.err.println("Tipo inesperado de mensagem: "
						+ message.getClass().getName());
			}
			System.out
					.println("**************************************************");
			System.out.println("Finalizando MDB.");
			System.out
					.println("**************************************************");
			// System.out.println("Message:" + message.toString());

		} catch (Throwable t) {
			t.printStackTrace();
			this.context.setRollbackOnly();
		}
	}
}
