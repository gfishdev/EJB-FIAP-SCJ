package br.com.fiap.ejb3.session;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateless;

@Stateless
@Remote(Calculadora.class)
public class CalculadoraBean {

	@PostConstruct
	public void inicializa(){
		System.out.println("Criando EJB Calculadora");
	}
	
	@Remove
	public void remove() {
		System.out.println("Removendo EJB Calculadora");
	}
	
	/**
	 * soma de 2 numeros inteiros
	 * 
	 * @param numero1
	 * @param numero2
	 */
	public long somar(long numero1, long numero2) {
		return numero1 + numero2;
	}

}
