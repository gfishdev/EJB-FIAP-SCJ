package br.com.fiap.cliente;

import java.rmi.Naming;

import br.com.fiap.rmi.Carrinho;
import br.com.fiap.rmi.Item;

public class ClienteCarrinho {
public static void main(String[] args) throws Exception {
		
		Carrinho carrinho = (Carrinho) Naming.lookup("rmi://localhost:1099/farmacia/carrinho");
		//System.out.println(carrinho.getClass());
		//System.out.println(carrinho.toString());
		
		Item item1 = new Item();
		item1.setNome("Doril");
		item1.setPreco(3.0);

		Item item2 = new Item();
		item2.setNome("Dorflex");
		item2.setPreco(5.0);
		
		carrinho.cadastrarItem(item1);
		carrinho.cadastrarItem(item2);
		
		System.out.println(carrinho.obterQuantidadeItens());
		
		carrinho.adicionarEmail(12245, "albert.xavier@gmail.com");
	}
}
