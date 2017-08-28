package br.com.fiap.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(ChamadoRemote.class)
public class ChamadoBean implements ChamadoRemote, Serializable {

	@PersistenceContext(unitName="Chamado")
	EntityManager em;
	
	@PersistenceContext(unitName="Chamado1")
	EntityManager em1;
	
	@Resource
	private SessionContext ctx;

	public void cadastrar(Chamado chamado, Chamado1 chamado1) throws Exception {
		
		try {
			
			em.persist(chamado);
			System.out.println("Chamado 1 [" + chamado.getId() + "] registrado com sucesso.");
			//int a = 1/0;
			em1.persist(chamado1);
			System.out.println("Chamado 2 [" + chamado1.getId() + "] registrado com sucesso.");
			
		} catch (Throwable e) {
																																																																							//throw new RuntimeException();
			throw new RuntimeException(e);
			
		}
		
		
		//************** QUANDO NAO EXISTIA HIBERNATE E JPA
		/*try {
			DataSource dataSource = (DataSource) ctx.lookup("java:/PostgresDS");
			Connection conn = dataSource.getConnection();
			String sql = "INSERT INTO chamado (descricao) VALUES (?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, chamado.getDescricao());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	public List recuperarTodos() {
		System.out.println("Retornando lista de chamados.");
		//em.createQuery("from Chamado ch where ch.descricao=:descricao")
		//.setParameter("descricao", "nonono").getResultList();
		return new ArrayList();
	}

	@Remove
	public void checkout() {
		System.out.println("Removendo instancia EJB.");
	}
	
}
