package br.com.fiap.ejb3.teste;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.fiap.ejb3.session.Calculadora;

public class CalculadoraClient {

	public static void main(String[] args) throws Exception {
		
		Context context = new InitialContext();
		Calculadora calculadora = (Calculadora) context.lookup("CalculadoraBean/remote");
		System.out.println(calculadora.somar(2, 5));

		calculadora.remove();
	}
}