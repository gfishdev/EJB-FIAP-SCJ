package br.com.fiap.ejb2.teste;

import br.com.fiap.ejb.ServiceLocator;
import br.com.fiap.ejb.aula3.session.Calculadora;
import br.com.fiap.ejb.aula3.session.CalculadoraHome;

public class CalculadoraClient {

	public static void main(String[] args) throws Exception {
		new CalculadoraClient().execute();
	}

	public void execute() throws Exception {
		ServiceLocator serviceLocator = ServiceLocator.getGlobalInstance();

		CalculadoraHome calculadoraHome = (CalculadoraHome) serviceLocator
				.lookup("ejb/aula3/calculadora", CalculadoraHome.class);
		Calculadora calculadora = calculadoraHome.create();

		System.out.println(calculadora.somar(2, 5));

		calculadora.remove();
	}
}