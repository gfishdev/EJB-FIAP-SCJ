package br.com.fiap.ejb.cmp.escola;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.NamingException;

import org.apache.log4j.Category;

/**
 * SBSF GerenciadorCurso
 * 
 * @ejb.bean	name="GerenciadorCurso"
 *				type="Stateless"
 * 				view-type="remote"
 * 				jndi-name="GerenciadorCurso"
 * 
 * @ejb.ejb-ref		ejb-name="Estudante"
 * 					view-type="local"
 * 					ref-name="Estudante"
 * 
 * @ejb.ejb-ref		ejb-name="Professor"
 * 					view-type="local"
 * 					ref-name="Professor"
 * 
 * @ejb.ejb-ref		ejb-name="Curso"
 * 					view-type="local"
 * 					ref-name="Curso"
 * 
 * @ejb.util generate = "physical"
 * 
 * @ejb.remote-facade 
 * 
 * @jboss.container-configuration	name="Standard Stateless SessionBean"
 * 
 * Created on Apr 12, 2003
 *
 */
public class GerenciadorCursoBean implements SessionBean {
	
	private Category log = Category.getInstance(GerenciadorCursoBean.class);

	private SessionContext ctx;

	public void ejbActivate() {}

	public void ejbPassivate() {}

	public void ejbRemove() {}

	public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
	}
	
	/**
	 * @ejb.create-method
	 */		
	public void ejbCreate() throws CreateException { }

	/**
	 * Cadastra um novo curso.
	 * 	
	 * @ejb.interface-method
	 * @ejb.facade-method 
	 * @ejb.transaction	type="Supports"	
	 */    		
	public void cadastrarProfessor(String nomeProfessor) {
		try {
			ProfessorUtil.getLocalHome().create(nomeProfessor);
		} catch (NamingException ex) {
			throw new EJBException(ex);
		} catch (CreateException ex) {
			throw new EJBException(ex);			
		}
		this.log.info("Professor "+nomeProfessor+" criado.");
	}
	
	/**
	 * Cadastra um novo curso.
	 * 	
	 * @ejb.interface-method
	 * @ejb.facade-method 
	 * @ejb.transaction	type="Supports"	
	 */    		
	public void cadastrarCurso(String nomeCurso, String nomeProfessor) {
		try {
			ProfessorLocal professor = 
				ProfessorUtil.getLocalHome().findByPrimaryKey( new ProfessorPK(nomeProfessor) );
			
			CursoUtil.getLocalHome().create(nomeCurso, professor);			
		} catch (NamingException ex) {
			throw new EJBException(ex);
		} catch (CreateException ex) {
			throw new EJBException(ex);			
		} catch (FinderException ex) {
			this.log.error("Professor "+nomeProfessor+" nao encontrado.");
			throw new EJBException(ex);			
		}
		
		this.log.info("Curso "+nomeCurso+" criado.");
		this.log.info("O curso serah ministrado por "+nomeProfessor);	
	}	
	
	/**
	 * Cadastra um novo aluno para um determinado curso.
	 * 	
	 * @ejb.interface-method
	 * @ejb.facade-method 
	 * @ejb.transaction	type="Required"	
	 */    		
	public void cadastrarEstudante(String nomeEstudante, String nomeCurso) {
		try {
			EstudanteLocal estudante = 
				EstudanteUtil.getLocalHome().create(nomeEstudante);

			CursoLocal curso = 
				CursoUtil.getLocalHome().findByPrimaryKey(new CursoPK(nomeCurso));
						
			curso.getEstudantes().add( estudante );
					
		} catch (NamingException ex) {
			throw new EJBException(ex);
		} catch (CreateException ex) {
			throw new EJBException(ex);			
		} catch (FinderException ex) {
			this.log.error("Curso "+nomeCurso+" nao encontrado.");
			throw new EJBException(ex);			
		}
		
		this.log.info("Estudante "+nomeEstudante+" criado.");
	}

	/**
	 * Retorna uma coleção de alunos relacionados com um curso.
	 * 	
	 * @ejb.interface-method
	 * @ejb.facade-method 
	 * @ejb.transaction	type="Supports"	
	 */    		
	public Collection nomeProfessoresDadoAluno(String nomeAluno) {
		try {
			
			EstudanteLocal estudante = 
				EstudanteUtil.getLocalHome().findByPrimaryKey(new EstudantePK(nomeAluno));					
			return estudante.getNomeProfessores();

		} catch (NamingException ex) {
			throw new EJBException(ex);
		} catch (FinderException ex) {
			this.log.error("Aluno "+nomeAluno+" nao encontrado.");
			throw new EJBException(ex);			
		}		
	}
}
