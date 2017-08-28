package br.com.fiap.ejb3.teste;

import br.com.fiap.ejb.ServiceLocator;
import br.com.fiap.ejb3.session.CarrinhoCompras;

public class CarrinhoComprasCallbackClient {

	public static void main(String[] args) throws Exception {
		new CarrinhoComprasCallbackClient().execute();
	}

	public void execute() throws Exception {
		ServiceLocator serviceLocator = ServiceLocator.getGlobalInstance();
		int contador = 10;

		CarrinhoCompras carrinhos[] = new CarrinhoCompras[contador];
		
		for (int j = 0; j < contador; j++) {
			CarrinhoCompras carrinhoCompras = (CarrinhoCompras) serviceLocator.lookup("CarrinhoComprasBean/remote");
			carrinhos[j] = carrinhoCompras;
			//System.out.println("Quantidade de produtos no carrinho " + j + ": " + carrinhoCompras.verCarrinho().size());
		}
		
		System.out.println("Conferindo produtos adicionados");
		for (int i = 0; i < contador; i++) {
			CarrinhoCompras carrinhoCompras = carrinhos[i];
			carrinhoCompras.adicionarProduto(i);
			Thread.sleep(200);
		}
		System.out.println("Conferencia finalizada");
	}
}