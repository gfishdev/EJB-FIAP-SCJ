package br.com.fiap.rmi;

import javax.naming.InitialContext;

public class RegistraCarrinhoJBoss {

	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		context.rebind("carrinho", new CarrinhoBean());
		System.out.println("Carrinho registrado no JBoss");
	}
}
