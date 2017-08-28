package br.com.fiap.ejb3.teste;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.fiap.ejb3.session.CarrinhoCompras;

public class CarrinhoComprasStatefulClient2 {

	public static void main(String[] args) throws Exception {

		Context context = new InitialContext();
		
		int contador = 10;

		CarrinhoCompras carrinhos[] = new CarrinhoCompras[contador];
		
		for (int j = 0; j < contador; j++) {
			CarrinhoCompras carrinhoCompras = (CarrinhoCompras) context.lookup("CarrinhoComprasBean/remote");
			carrinhos[j] = carrinhoCompras;
			System.out.println("Quantidade de produtos no carrinho " + j + ": " + carrinhoCompras.verCarrinho().size());
		}
		
		System.out.println("Conferindo produtos adicionados");
		for (int i = 0; i < contador; i++) {
			CarrinhoCompras carrinhoCompras = carrinhos[i];
			carrinhoCompras.adicionarProduto(i);
			Thread.sleep(200); //em milisegundos
		}
		System.out.println("Conferencia finalizada");
		
		
		for (int j = 0; j < contador; j++) {
			System.out.println("Quantidade de produtos no carrinho " + j + ": " + carrinhos[j].verCarrinho().size());
		}
	}
}