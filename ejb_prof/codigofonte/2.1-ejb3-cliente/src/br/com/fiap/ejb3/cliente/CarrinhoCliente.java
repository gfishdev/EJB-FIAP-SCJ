package br.com.fiap.ejb3.cliente;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.ejb3.Carrinho;
import br.com.fiap.ejb3.Item;

public class CarrinhoCliente {

	public static void main(String[] args) throws NamingException {
		
		//propriedades necessarias para acessar o JNDI
		Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        props.setProperty("java.naming.provider.url", "localhost:1099");
		
		//se nao for passado o parametro props abaixo a classe InitialContext procura pelo
        //arquivo 'jndi.properties' e carrega as suas configuracoes
        Context context = new InitialContext(props);

		Carrinho carrinho = (Carrinho) context.lookup("CarrinhoBean/remote");
		
		Item item1 = new Item();
		item1.setNome("Anador");
		item1.setPreco(3.0);
		
		carrinho.cadastrarItem(item1);
		System.out.println("Quantidade de produtos no carrinho: " + carrinho.obterQuantidadeItens());

	}

}
