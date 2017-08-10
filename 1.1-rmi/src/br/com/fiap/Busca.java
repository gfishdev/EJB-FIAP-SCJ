package br.com.fiap;

import java.rmi.Naming;

public class Busca {

	public static void main(String[] args) throws Exception {
		Carrinho pequisa = (Carrinho) Naming.lookup("rmi://10.20.74.41:1099/farmacia/carrinho");
		Item item = new Item();
		item.setNome("Palmeiras não tem mundial");
		item.setPreco(120.50);
		pequisa.cadastrarItem(item);
	}

}
