package br.com.fiap.ejb;

import java.io.Serializable;

import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HistoricoBean implements HistoricoRemote, Serializable {

	@PersistenceContext(unitName="Historico")
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void cadastrar(Historico historico) throws Exception {
		try {
			em.persist(historico);
			System.out.println("Historico [" + historico.getId() + "] registrado com sucesso.");
		} catch (Throwable e) {
			throw new Exception("Erro no cadastro de chamado/historico");
		}
	}

	@Remove
	public void checkout() {
		System.out.println("Removendo instancia deste EJB.");
	}
	
}
