package br.com.fiap.professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name="carrinho")
@Remote(value = Carrinho.class)
public class CarrinhoBean implements Carrinho {

	private List<Item> itens = new ArrayList();
	private HashMap newsletter = new HashMap();

	public CarrinhoBean() {
	}

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

	public void adicionarEmail(int matricula, String email) {
		if (newsletter.containsKey(new Integer(matricula))) {
			newsletter.remove(new Integer(matricula));
		}

		newsletter.put(new Integer(matricula), email);

		Iterator it = newsletter.values().iterator();
		System.out.println("\n\n");
		System.out.println("======= EMAILS CADASTRADOS =======");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("======= TOTAL: " + newsletter.size() + " =======");
	}
}
