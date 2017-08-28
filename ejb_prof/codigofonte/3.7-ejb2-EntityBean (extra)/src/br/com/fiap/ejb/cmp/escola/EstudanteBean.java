package br.com.fiap.ejb.cmp.escola;


import java.util.Collection;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

/**
 * Entity Bean CMP Estudante
 * 
 * @ejb.bean	name="Estudante"
 *      		display-name="Estudante" type="CMP"
 *      		local-jndi-name="local/Estudante"
 *      		cmp-version="2.x" schema="Estudante" view-type="local"
 *
 * @ejb.ejb-ref		ejb-name="Curso"
 * 					view-type="local"
 * 					ref-name="Curso"
 * 
 * @jboss.table-name	table-name="ESTUDANTE"
 * @jboss.create-table	create="true"
 * @jboss.remove-table	remove="true"
 * 
 * @jboss.container-configuration    name="Standard CMP 2.x EntityBean"
 * 
 * @ejb.resource-ref 	res-name="jdbc/DefaultDS"
 *      				res-type="javax.sql.DataSource" 
 * 						res-auth="Container"
 * 
 * @ejb.util generate = "physical"
 * Created on Apr 12, 2003
 *
 */
public abstract class EstudanteBean implements EntityBean {
	
	protected EntityContext ctx;
	
	/**
	 * Retorna a coleção de estudantes ligados a este curso.
	 * 
	 * @ejb.interface-method
	 * 
	 * @ejb.transaction	type="Supports"
	 * 
	 * @ejb.relation	name="curso-estudante"
	 *    				role-name="estudante-tem-cursos"
	 *
	 * @jboss.relation	fk-column="FK_CURSO"
	 *					related-pk-field="nome"
	 * 
	 * @jboss.relation-table	table-name="CURSO_ESTUDANTE"
	 * @return Collection
	 */	
	public abstract Collection getCursos();

	/**
	 * Retorna o nome deste Estudante.
	 * O nome do estudante é campo chave primária.
	 * 
	 * @ejb.persistent-field
	 * @ejb.interface-method
	 * @ejb.pk-field 
	 * 
	 * @jboss.column-name name="NOME"
	 * 
	 * @ejb.transaction type="Supports"
	 * 
	 */	
	public abstract String getNome();

	/**
	 * Seta os cursos deste estudante.
	 * 
	 * @ejb.interface-method
	 * @ejb.transaction type="Required"	
	 */
	public abstract void setCursos(Collection cursos);

	/**
	 * Seta o nome do estudante.
	 * 
	 * @ejb.transaction type="Required"	
	 */
	public abstract void setNome(String string);

	public void ejbActivate() {}

	public void ejbPassivate() {}

	//
	public void ejbLoad() {}

	//
	public void ejbStore() {}

	//
	public void ejbRemove() throws RemoveException {}

	/**
	 * @ejb.create-method
	 * 
	 * @ejb.transaction type="Required"	
	 */
	public EstudantePK ejbCreate(String nome) throws CreateException {
		this.setNome( nome );
		return new EstudantePK(nome);
	}
	
	//
	public void ejbPostCreate(String nome) throws CreateException {}
	
	/**
	 * Retorna o nome de todos os professores associados com este Estudante.
	 * 
	 * @ejb.interface-method	
	 * 
	 * @ejb.transaction type="Supports"
	 */		
	public Set getNomeProfessores() {
		try {
			
			return this.ejbSelectNomeProfessoresDadoEstudante( this.getNome() );
			            
		} catch (FinderException e) {
			throw new EJBException(e);
		}
	}
	
	/**
	 * @ejb.select query="SELECT p.nome FROM Professor AS p, IN (p.cursos) AS c, IN (c.estudantes) AS e WHERE e.nome = ?1"
	 * 
	 * @param nomeEstudante
	 * @return
	 * @throws FinderException
	 */
	public abstract Set ejbSelectNomeProfessoresDadoEstudante(String nomeEstudante) throws FinderException;	
	
	
	public void setEntityContext(EntityContext ctx) {
		this.ctx = ctx;
	}

	public void unsetEntityContext() {
		this.ctx = null;
	}
}