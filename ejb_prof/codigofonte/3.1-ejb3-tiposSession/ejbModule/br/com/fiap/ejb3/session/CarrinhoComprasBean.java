package br.com.fiap.ejb3.session;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.CacheConfig;

@Stateful
//@CacheConfig(maxSize=20, idleTimeoutSeconds=60, removalTimeoutSeconds=360)
public class CarrinhoComprasBean implements CarrinhoCompras {

	private List listaCompras = null;
	
	public CarrinhoComprasBean() {
		this.listaCompras = new ArrayList();
	}
	
	@PostConstruct
	public void inicializa(){
		System.out.println("Criando EJB Carrinho Compras");
		this.listaCompras = new ArrayList();
	}
	
	@Remove
	public void remove() {
		System.out.println("Removendo EJB Carrinho Compras");
	}
	

	@PrePassivate
	public void passiva() {
		System.out.println("Passivate - EJB Carrinho Compras");
	}
	
	@PostActivate
	public void ativa() {
		System.out.println("Activate - EJB Carrinho Compras");
	}
	
	/**
	 * adicao de compra
	 * 
	 * @param codigoProduto
	 */
	public void adicionarProduto(long codigoProduto) {
		listaCompras.add(codigoProduto);
		
	}
	
	/**
	 * ver carrinho de compras
	 * 
	 * @return lista de compras
	 */
	public List verCarrinho() {
		return listaCompras;
	}

}
