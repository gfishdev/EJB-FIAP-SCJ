package br.com.fiap.ejb.entity;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ChamadoBean implements ChamadoRemote, Serializable {

	@PersistenceContext(name="Chamado")
	private EntityManager em;
	
	public void cadastrar(Chamado chamado) {
		em.persist(chamado);
		System.out.println("Chamado [" + chamado.getId() + "] registrado com sucesso.");
	}

	public List recuperarTodos() {
		return em.createQuery("from Chamado").getResultList();
	}

	public Chamado recuperarPorDescricao(String descricao) {
		return (Chamado) em.createQuery("from Chamado ch where ch.descricao=:descricao")
		.setParameter("descricao", descricao).getSingleResult();
	}

	@Remove
	public void checkout() {
		System.out.println("Removendo instancia EJB ChamadoBean.");
	}
	
}
