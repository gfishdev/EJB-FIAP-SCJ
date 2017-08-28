package br.com.fiap.ejb2.cliente;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;

import br.com.fiap.ejb.ServiceLocator;
import br.com.fiap.ejb2.Carrinho;
import br.com.fiap.ejb2.CarrinhoHome;
import br.com.fiap.ejb2.Item;

public class CarrinhoCliente {

	public static void main(String[] args) throws NamingException,
			CreateException, RemoteException, RemoveException {

		ServiceLocator serviceLocator = ServiceLocator.getGlobalInstance();

		CarrinhoHome carrinhohome = (CarrinhoHome) serviceLocator.lookup(
				"aula3/ejb/Carrinho", CarrinhoHome.class);
		Carrinho carrinho = carrinhohome.create();

		
		// executa metodos de negocio
		Item item1 = new Item();
		item1.setNome("Doril");
		item1.setPreco(3.0);

		carrinho.cadastrarItem(item1);
		System.out.println("Quantidade de produtos no carrinho: "
				+ carrinho.obterQuantidadeItens());

		// remove Carrinho Session após uso
		carrinho.remove();
	}

}
