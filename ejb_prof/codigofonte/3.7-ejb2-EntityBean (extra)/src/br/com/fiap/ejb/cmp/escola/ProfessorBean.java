package br.com.fiap.ejb.cmp.escola;


import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

/**
 * Entity Bean CMP Professor
 * 
 * @ejb.bean	name="Professor"
 *      		display-name="Professor" type="CMP"
 *      		local-jndi-name="local/Professor"
 *      		cmp-version="2.x" schema="Professor" view-type="local"
 *
 * @ejb.ejb-ref		ejb-name="Curso"
 * 					view-type="local"
 * 					ref-name="Curso"
 * 
 * @jboss.table-name	table-name="PROFESSOR"
 * @jboss.create-table	create="true"
 * @jboss.remove-table	remove="true"
 * 
 * @jboss.container-configuration    name="Standard CMP 2.x EntityBean"
 * 
 * @ejb.resource-ref 	res-name="jdbc/DefaultDS"
 *      				res-type="javax.sql.DataSource" 
 * 						res-auth="Container"
 * 
 * Created on Apr 12, 2003
 * 
 * @ejb.util generate = "physical"
 *
 */
public abstract class ProfessorBean implements EntityBean {
	
	protected EntityContext ctx;

	/**
	 * Retorna os cursos ministrados por este professor.
	 * 
	 * @ejb.interface-method
	 * 
	 * @ejb.relation	name="professor-cursos"
	 * 					role-name="professor-tem-cursos"
	 */	
	public abstract Collection getCursos();

	/**
	 * Retorna o nome do professor.
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
	 * Seta os cursos ministrados por este professor.
	 * 
	 * @ejb.interface-method
	 * @ejb.transaction type="Required"	
	 */	
	public abstract void setCursos(Collection collection);

	/**
	 * Seta o nome deste curso.
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
	public ProfessorPK ejbCreate(String nome) throws CreateException {
		this.setNome( nome );
		return new ProfessorPK(nome);
	}
	
	//
	public void ejbPostCreate(String nome) throws CreateException {}
	
	public void setEntityContext(EntityContext ctx) {
		this.ctx = ctx;
	}

	public void unsetEntityContext() {
		this.ctx = null;
	}
}