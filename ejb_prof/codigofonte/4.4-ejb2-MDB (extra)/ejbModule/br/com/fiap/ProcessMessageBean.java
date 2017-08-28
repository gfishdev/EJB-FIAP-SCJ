package br.com.fiap;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ProcessMessageBean implements MessageDrivenBean, MessageListener {

	private static final long serialVersionUID = 8215752563207725895L;

	private MessageDrivenContext context = null;

	public void setMessageDrivenContext(MessageDrivenContext context)
			throws EJBException {
		this.context = context;
	}

	public void ejbCreate() {
	}

	public void ejbRemove() {
		this.context = null;
	}

	public void onMessage(Message message) {
		System.out.println("**************************************************");
		System.out.println(" Mensagem FAX recebida.");
		System.out.println("**************************************************");
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("Iniciando processamento da mensagem: " + text);
				Thread.sleep(2000);
				System.out.println("Processamento da mensagem [" + text + "] concluido.");
			} else {
				
				System.err.println("Tipo inesperado de mensagem: "
						+ message.getClass().getName());
			}
			System.out.println("**********************************************");
			System.out.println(" Finalizando MDB.");
			System.out.println("**********************************************");
		} catch (Throwable t) {
			t.printStackTrace();
			this.context.setRollbackOnly();
		}
	}
}
