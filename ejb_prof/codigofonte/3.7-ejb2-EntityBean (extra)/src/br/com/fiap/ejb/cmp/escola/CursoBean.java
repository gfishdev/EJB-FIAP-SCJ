package br.com.fiap.ejb.cmp.escola;


import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

/**
 * Entity Bean CMP Curso
 * 
 * @ejb.bean	name="Curso"
 *      		display-name="Curso" type="CMP"
 *      		local-jndi-name="local/Curso"
 *      		cmp-version="2.x" schema="Curso" view-type="local"
 *
 * @ejb.ejb-ref		ejb-name="Estudante"
 * 					view-type="local"
 * 					ref-name="Estudante"
 * 
 * @ejb.ejb-ref		ejb-name="Professor"
 * 					view-type="local"
 * 					ref-name="Professor"
 * 
 * @jboss.table-name	table-name="CURSO"
 * @jboss.create-table	create="true"
 * @jboss.remove-table	remove="true"
 * 
 * @jboss.container-configuration    name="Standard CMP 2.x EntityBean"
 * 
 * @ejb.resource-ref 	res-name="jdbc/DefaultDS"
 *      				res-type="javax.sql.DataSource" 
 * 						res-auth="Container"
 * 
 * @jboss.resource-manager	res-man-class="javax.sql.DataSource"
 *      					res-man-name="jdbc/DefaultDS" 
 * 							res-man-jndi-name="java:/DefaultDS"
 * 
 * @ejb.finder	method-intf="LocalHome"
 *				query="SELECT DISTINCT OBJECT(c) FROM Curso as c WHERE c.professor.nome = ?1"
 *				result-type-mapping="Local"
 *				signature="java.util.Collection findCursosDadoNomeProfessor(java.lang.String nomeProfessor)"
 * 
 * @ejb.util generate = "physical"
 * 
 * Created on Apr 12, 2003
 *
 */
public abstract class CursoBean implements EntityBean {
	
	protected EntityContext ctx;

	/**
	 * Retorna a coleção de estudantes ligados a este curso.
	 * 
	 * @ejb.interface-method
	 * 
	 * @ejb.transaction	type="Supports"
	 * 
	 * @ejb.relation	name="curso-estudante"
	 *    				role-name="curso-tem-estudantes"
	 *
	 * @jboss.relation	fk-column="FK_ESTUDANTE"
	 *					related-pk-field="nome"
	 * 
	 * @jboss.relation-table	table-name="CURSO_ESTUDANTE"
	 * @return Collection
	 */
	public abstract Collection getEstudantes();

	/**
	 * Retorna o nome deste curso.
	 * O nome do curso é campo chave primária.
	 * 
	 * @ejb.persistent-field
	 * @ejb.interface-method
	 * @ejb.pk-field 
	 * 
	 * @jboss.column-name name="NOME"
	 * 
	 * @ejb.transaction type="Supports"
	 */	
	public abstract String getNome();
	
	/**
	 * Retorna o professor associado com este curso.
	 * 
	 * @ejb.interface-method
	 * 
	 * @ejb.relation	name="professor-cursos"
	 * 					role-name="curso-tem-professor"
	 * 
	 * @jboss.relation 	
	 *  				fk-column="PROFESSOR_FK"
	 *   				related-pk-field="nome"
	 */		
	public abstract ProfessorLocal getProfessor();	

	/**
	 * Seta a coleção de estudantes deste curso.
	 * 
	 * @ejb.interface-method
	 * @ejb.transaction type="Required"	
	 */
	public abstract void setEstudantes(Collection collection);

	/**
	 * Seta o nome deste curso.
	 * 
	 * @ejb.transaction type="Required"	
	 */
	public abstract void setNome(String string);
	
	/**
	 * Seta o professor que irá ministrar este curso.
	 * 
	 * @ejb.interface-method
	 * @ejb.transaction type="Required"	
	 */
	public abstract void setProfessor(ProfessorLocal professor);

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
	public CursoPK ejbCreate(String nome, ProfessorLocal professor) throws CreateException {
		this.setNome( nome );
		return new CursoPK(nome);
	}
	
	//
	public void ejbPostCreate(String nome, ProfessorLocal professor) throws CreateException {
		this.setProfessor( professor );
	}
	
	public void setEntityContext(EntityContext ctx) {
		this.ctx = ctx;
	}

	public void unsetEntityContext() {
		this.ctx = null;
	}
}