package br.com.fiap.ejb.aula3.session;
import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;


public interface CarrinhoCompras extends EJBObject{
	
	public void adicionarProduto(long codigoProduto) throws RemoteException;
	public List verCarrinho() throws RemoteException;
	
}
