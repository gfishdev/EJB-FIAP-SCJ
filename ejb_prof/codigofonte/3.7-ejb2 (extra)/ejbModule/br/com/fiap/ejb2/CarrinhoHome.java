package br.com.fiap.ejb2;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface CarrinhoHome extends EJBHome {

	public static final String JNDI_NAME = "aula3/ejb/Carrinho";	
	
	Carrinho create() throws RemoteException, CreateException;
	
}
