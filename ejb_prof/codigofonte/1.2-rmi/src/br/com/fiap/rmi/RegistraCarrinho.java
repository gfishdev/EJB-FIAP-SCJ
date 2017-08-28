package br.com.fiap.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RegistraCarrinho {

	public static void main(String[] args) throws Exception {
		System.setProperty("java.rmi.server.hostname","10.20.74.41");
		
		//Executando o servico de nomes programaticamente
		//Voce tambem pode chamar o rmiregistry via linha de comando
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("farmacia/carrinho", new CarrinhoBean());
		System.out.println("carrinho registrado no RMIRegistry");
	}
}
