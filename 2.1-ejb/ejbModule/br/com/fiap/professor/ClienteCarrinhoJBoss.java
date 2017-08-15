package br.com.fiap.professor;

import javax.naming.InitialContext;

public class ClienteCarrinhoJBoss {

	public static void main(String[] args) throws Exception {

		InitialContext context = new InitialContext();
//		Carrinho carrinho = (Carrinho) context.lookup("CarrinhoBean/remote");
		Carrinho carrinho = (Carrinho) context.lookup("carrinho/remote");

		Item item1 = new Item();
		item1.setNome("Doril");
		item1.setPreco(3.0);

		Item item2 = new Item();
		item2.setNome("Dorflex");
		item2.setPreco(5.0);

		carrinho.cadastrarItem(item1);
		carrinho.cadastrarItem(item2);

		System.out.println(carrinho.obterQuantidadeItens());

		carrinho.adicionarEmail(41122, "albert.xavier@gmail.com");
	}

}
