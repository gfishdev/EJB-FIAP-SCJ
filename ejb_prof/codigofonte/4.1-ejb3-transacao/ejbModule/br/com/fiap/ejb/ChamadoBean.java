package br.com.fiap.ejb;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ChamadoBean implements ChamadoRemote, Serializable {

	@PersistenceContext(unitName="Historico")
	private EntityManager em;
	
	@Resource
	private SessionContext ctx;
	
	public void cadastrar(Chamado chamado, Historico historico) throws Exception {
		try {
			em.persist(chamado);
			System.out.println("Chamado [" + chamado.getId() + "] registrado com sucesso.");
			cadastrarHistorico(historico);
		} catch (Throwable e) {
			throw new Exception("Erro no cadastro de chamado/historico");
		}
	}

	public void cadastrarHistorico(Historico historico) throws Exception {
		try {
			HistoricoRemote historicoRemote = (HistoricoRemote) ctx.lookup("HistoricoBean/remote");
			historicoRemote.cadastrar(historico);
			//System.out.println("Historico [" + historico.getId() + "] registrado com sucesso.");
		} catch (Throwable e) {
			throw new Exception("Erro ao cadastrar historico");
		}
	}
	
	@Remove
	public void checkout() {
		System.out.println("Removendo instancia do EJB ChamadoBean.");
	}
}
