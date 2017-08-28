package br.com.fiap.ejb.aula3.session;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface CarrinhoComprasHome extends EJBHome {

	CarrinhoCompras create() throws RemoteException, CreateException;
	//CarrinhoCompras create(int numero) throws RemoteException, CreateException;
}
