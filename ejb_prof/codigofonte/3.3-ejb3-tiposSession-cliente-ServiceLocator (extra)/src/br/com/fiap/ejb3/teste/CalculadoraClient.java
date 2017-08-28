package br.com.fiap.ejb3.teste;

import br.com.fiap.ejb.ServiceLocator;
import br.com.fiap.ejb3.session.Calculadora;


public class CalculadoraClient {


	public static void main(String[] args) throws Exception {
		new CalculadoraClient().execute();
	}
	
	
	public void execute() throws Exception	{
		ServiceLocator serviceLocator = ServiceLocator.getGlobalInstance();

		Calculadora calculadora = (Calculadora)serviceLocator.lookup("CalculadoraBean/remote");
		System.out.println(calculadora.somar(2, 5));
		
		calculadora.remove();
	}
}