package br.com.fiap.ejb2.teste;

import br.com.fiap.ejb.ServiceLocator;
import br.com.fiap.ejb.aula3.session.CarrinhoCompras;
import br.com.fiap.ejb.aula3.session.CarrinhoComprasHome;

public class CarrinhoComprasSemEstadoClient {

	public static void main(String[] args) throws Exception {
		new CarrinhoComprasSemEstadoClient().execute();
	}

	public void execute() throws Exception {
		ServiceLocator serviceLocator = ServiceLocator.getGlobalInstance();

		CarrinhoComprasHome carrinhoComprasHome = (CarrinhoComprasHome) serviceLocator
				.lookup("ejb/aula3/carrinhoCompras1", CarrinhoComprasHome.class);
		CarrinhoCompras carrinhoCompras = carrinhoComprasHome.create();

		for (int i = 1; i < 101; i++) {
			carrinhoCompras.adicionarProduto(i);
		}

		System.out.println(carrinhoCompras.verCarrinho().size());
		carrinhoCompras.remove();
	}
}