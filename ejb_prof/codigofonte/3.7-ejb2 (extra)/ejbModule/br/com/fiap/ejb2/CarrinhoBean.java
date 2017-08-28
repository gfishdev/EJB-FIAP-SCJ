package br.com.fiap.ejb2;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class CarrinhoBean implements SessionBean {

	private List<Item> itens = new ArrayList();

	// metodos de callback
	public void ejbActivate() throws EJBException, RemoteException {

	}

	public void ejbPassivate() throws EJBException, RemoteException {

	}

	public void ejbRemove() throws EJBException, RemoteException {

	}

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {

	}

	public void ejbCreate() {

	}

	
	
	
	// metodos de negocio

	public void cadastrarItem(Item item) {
		itens.add(item);
		System.out.println("Item cadastrado com sucesso: " + item.getNome());
	}

	public List<Item> obterItens() {
		return this.itens;
	}

	public int obterQuantidadeItens() {
		return this.itens.size();
	}

	public void removerCadastro(int matricula) {
		// remove usuario do banco de dados
	}

}