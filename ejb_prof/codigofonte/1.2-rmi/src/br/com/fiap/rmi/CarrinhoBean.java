package br.com.fiap.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CarrinhoBean extends UnicastRemoteObject implements Carrinho {
	
	private List<Item> itens = new ArrayList();
	private HashMap newsletter = new HashMap();
	
	public CarrinhoBean() throws RemoteException {
	}
	
	public void cadastrarItem(Item item) throws RemoteException {
		itens.add(item);
		System.out.println("Item cadastrado com sucesso: " + item.getNome());
	}

	public List<Item> obterItens() throws RemoteException {
		
		return this.itens;
	}

	public int obterQuantidadeItens() throws RemoteException {
		return this.itens.size();
	}

	public void adicionarEmail(int matricula, String email) throws RemoteException {
		if (newsletter.containsKey(new Integer(matricula))){
			newsletter.remove(new Integer(matricula));
		}
		
		newsletter.put(new Integer(matricula), email);
		
		Iterator it = newsletter.values().iterator();
		System.out.println("\n\n");
		System.out.println("======= EMAILS CADASTRADOS =======");
		while (it.hasNext()){   
  		    System.out.println(it.next());       
		}
		System.out.println("======= TOTAL: " + newsletter.size() + " =======");
	}
}
