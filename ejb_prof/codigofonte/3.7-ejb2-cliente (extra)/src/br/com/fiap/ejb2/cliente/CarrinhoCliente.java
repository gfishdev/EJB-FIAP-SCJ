package br.com.fiap.ejb2.cliente;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import br.com.fiap.ejb2.Carrinho;
import br.com.fiap.ejb2.CarrinhoHome;
import br.com.fiap.ejb2.Item;

public class CarrinhoCliente {

	public static void main(String[] args) throws NamingException,
			CreateException, RemoteException, RemoveException {

		Context context = new InitialContext();

		// Lembram do slide? passagem por referencia !
		Object objref = context.lookup("aula3/ejb/Carrinho");
		//Object objref = context.lookup(CarrinhoHome.JNDI_NAME);

		// obtém a referência para CarrinhoHome através do JNDI
		CarrinhoHome home = (CarrinhoHome) PortableRemoteObject.narrow(objref,
				javax.ejb.EJBHome.class);

		// cria uma referência para Carrinho session atraves de CarrinhoHome.
		Carrinho carrinho = home.create();

		
		
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
