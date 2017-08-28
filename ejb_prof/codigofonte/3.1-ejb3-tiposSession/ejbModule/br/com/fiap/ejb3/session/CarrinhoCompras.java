package br.com.fiap.ejb3.session;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CarrinhoCompras {
	public void inicializa();
	public void adicionarProduto(long codigoProduto);
	public List verCarrinho();
	public void remove();
}
