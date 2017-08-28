package br.com.fiap.ejb2.teste;

import br.com.fiap.ejb.ServiceLocator;
import br.com.fiap.ejb.aula3.session.CarrinhoCompras;
import br.com.fiap.ejb.aula3.session.CarrinhoComprasHome;

public class CarrinhoComprasComEstadoCallbackClient {

	public static void main(String[] args) throws Exception {
		new CarrinhoComprasComEstadoCallbackClient().execute();
	}

	public void execute() throws Exception {
		ServiceLocator serviceLocator = ServiceLocator.getGlobalInstance();
		int contador = 250;
		
		CarrinhoCompras carrinhos[] = new CarrinhoCompras[contador];
		

		for (int j = 0; j < contador; j++) {
			CarrinhoComprasHome carrinhoComprasHome = (CarrinhoComprasHome) serviceLocator.lookup("ejb/aula3/carrinhoCompras", CarrinhoComprasHome.class);
			CarrinhoCompras carrinhoCompras = carrinhoComprasHome.create();
			//CarrinhoCompras carrinhoCompras = carrinhoComprasHome.create(count++);
			carrinhos[j] = carrinhoCompras;
			//Thread.sleep(500);
			System.out.println("Quantidade de produtos no carrinho " + j + ": " + carrinhoCompras.verCarrinho().size());
		}
		
		for (int i = 0; i < contador; i++) {
			CarrinhoCompras carrinhoCompras = carrinhos[i];
			carrinhoCompras.adicionarProduto(i);
			//Thread.sleep(500);
			System.out.println("Quantidade de produtos no carrinho " + i + ": " + carrinhoCompras.verCarrinho().size());
		}
	}
}