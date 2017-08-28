package br.com.fiap.ejb2;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;

public interface Carrinho extends EJBObject {
	
	void cadastrarItem(Item item) throws RemoteException;
	List<Item> obterItens() throws RemoteException;
	int obterQuantidadeItens() throws RemoteException;
	void removerCadastro(int matricula) throws RemoteException;
}
