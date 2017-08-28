package br.com.fiap.ejb3;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateless;

//@CacheConfig(maxSize=50, idleTimeoutSeconds=60, removalTimeoutSeconds=360)
@Stateless
public class CarrinhoBean implements Carrinho {

	private List<Item> itens = new ArrayList<Item>();

	public void cadastrarItem(Item item) {
		itens.add(item);
		System.out.println("Item cadastrado com sucesso: " + item.getNome());
	}

	public List<Item> obterItens() {
		return this.itens;
	}
	
	public int obterQuantidadeItens() {
		return this.itens.size();
	}

	public void removerCadastro(int matricula) {
		//remove usuario
	}
	
	
	
	
	//metodos de callback
	@PostConstruct
	public void inicializa(){
		System.out.println("Criando instancia do EJB Carrinho");
	}
	
	@Remove
	public void remove() {
		System.out.println("Removendo instancia do EJB Carrinho");
	}
	
	@PrePassivate
	public void passiva() {
		System.out.println("Passivate");
	}
	
	@PostActivate
	public void ativa() {
		System.out.println("Activate");
	}
	
}
