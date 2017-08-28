package br.com.fiap.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class ChamadoBean implements ChamadoRemote {

	private List<Chamado> chamados;
	
	public ChamadoBean() {
		chamados = new ArrayList<Chamado>();
	}
	
	@Resource
	private SessionContext ctx;

	public void cadastrar(Chamado chamado) {
		chamados.add(chamado);
		System.out.println("Chamado [" + chamado.getDescricao() + "] registrado com sucesso.");
	}

	public List recuperarTodos() {
		return chamados;
	}

	@Remove
	public void checkout() {
		System.out.println("Removendo instancia deste EJB.");
	}
	
}
