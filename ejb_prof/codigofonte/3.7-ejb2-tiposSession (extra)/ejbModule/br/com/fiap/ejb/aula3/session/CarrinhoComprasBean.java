package br.com.fiap.ejb.aula3.session;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


public class CarrinhoComprasBean implements SessionBean {

	private List listaCompras = null;
	
	public void ejbActivate() throws EJBException, RemoteException {
		System.out.println("ejbActivate");
	}

	public void ejbPassivate() throws EJBException, RemoteException {
		System.out.println("ejbPassivate");
	}

	public void ejbRemove() throws EJBException, RemoteException {
		listaCompras = null;
	}

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		
	}

	public void ejbCreate() {
		System.out.println("EJB criado.");
		listaCompras = new ArrayList();
	}
	
	public void ejbCreate(int numero) {
		System.out.println("EJB " + numero + " criado.");
		listaCompras = new ArrayList();
	}


	//metodos de negocio abaixo
	
	/**
	 * adicao de compra
	 * 
	 * @param codigoProduto
	 */
	public void adicionarProduto(long codigoProduto) {
		listaCompras.add(codigoProduto);
		
	}
	
	/**
	 * ver carrinho de compras
	 * 
	 * @return lista de compras
	 */
	public List verCarrinho() {
		return listaCompras;
	}
}
