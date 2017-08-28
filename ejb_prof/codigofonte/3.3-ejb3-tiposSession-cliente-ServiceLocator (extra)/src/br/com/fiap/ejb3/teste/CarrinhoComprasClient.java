package br.com.fiap.ejb3.teste;

import br.com.fiap.ejb.ServiceLocator;
import br.com.fiap.ejb3.session.CarrinhoCompras;

public class CarrinhoComprasClient {

	public static void main(String[] args) throws Exception {
		new CarrinhoComprasClient().execute();
	}

	public void execute() throws Exception {
		ServiceLocator serviceLocator = ServiceLocator.getGlobalInstance();

		CarrinhoCompras carrinhoCompras = (CarrinhoCompras) serviceLocator.lookup("CarrinhoComprasBean/remote");

		carrinhoCompras.adicionarProduto(12);
		carrinhoCompras.adicionarProduto(18);

		System.out.println("Quantidade de produtos: " + carrinhoCompras.verCarrinho().size());

		carrinhoCompras.remove();
	}
}