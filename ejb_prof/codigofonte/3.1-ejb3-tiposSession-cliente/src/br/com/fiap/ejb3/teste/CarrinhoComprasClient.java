package br.com.fiap.ejb3.teste;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.fiap.ejb3.session.CarrinhoCompras;

public class CarrinhoComprasClient {

	public static void main(String[] args) throws Exception {

		Context context = new InitialContext();

		CarrinhoCompras carrinhoCompras = (CarrinhoCompras) context.lookup("CarrinhoComprasBean/remote");

		carrinhoCompras.adicionarProduto(12);
		carrinhoCompras.adicionarProduto(18);

		System.out.println("Quantidade de produtos: " + carrinhoCompras.verCarrinho().size());

		carrinhoCompras.remove();
	}
}