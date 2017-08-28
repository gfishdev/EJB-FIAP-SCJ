package br.com.fiap.ejb2.teste;

import br.com.fiap.ejb.ServiceLocator;
import br.com.fiap.ejb.aula3.session.CarrinhoCompras;
import br.com.fiap.ejb.aula3.session.CarrinhoComprasHome;

public class CarrinhoComprasClient {

	public static void main(String[] args) throws Exception {
		new CarrinhoComprasClient().execute();
	}

	public void execute() throws Exception {
		ServiceLocator serviceLocator = ServiceLocator.getGlobalInstance();

		CarrinhoComprasHome carrinhoComprasHome = (CarrinhoComprasHome) serviceLocator
				.lookup("ejb/aula3/carrinhoCompras", CarrinhoComprasHome.class);
		CarrinhoCompras carrinhoCompras = carrinhoComprasHome.create();

		carrinhoCompras.adicionarProduto(12);
		carrinhoCompras.adicionarProduto(18);

		System.out.println(carrinhoCompras.verCarrinho().size());

		carrinhoCompras.remove();
	}
}