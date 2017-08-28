package br.com.fiap.ejb.cmp.produto;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

import org.apache.log4j.Logger;

/**
 * @ejb.bean	name="Produto"
 *      		display-name="Produto" 
 * 				type="CMP"
 *      		jndi-name="Produto"
 * 				primkey-field = "id"
 *      		cmp-version="2.x" 
 * 				schema="Produto" 
 * 				view-type="remote"
 * 
 * @jboss.table-name	table-name="PRODUTO"
 * @jboss.create-table	create="true"
 * @jboss.remove-table	remove="true"
 * 
 * @jboss.container-configuration    name="Standard CMP 2.x EntityBean"
 * 
 * 
 * @ejb.util generate = "physical"
 * @ejb.value-object match = "*"
 * 
 */
public abstract class ProdutoBean implements EntityBean {
	
	private Logger log = Logger.getLogger(getClass());
	
	private EntityContext ctx;
	
	/**
	 * @ejb.create-method
	 * 
	 * @ejb.transaction type="Required"	
	 */	
	public Long ejbCreate(long id) throws CreateException {
		this.setId(new Long(id));
		return new Long(id);
	}
	
	public void ejbPostCreate(long id) throws CreateException {
		log.info("Criado "+this.ctx.getPrimaryKey());
	} 

	/**
	 * @ejb.create-method
	 * 
	 * @ejb.transaction type="Required"	
	 */	
	public Long ejbCreate(long id, String nome, String descricao, float preco) throws CreateException {
		
		this.setId(new Long(id));
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setPreco(preco);
		return new Long(id);
	}
	
	public void ejbPostCreate(long id, String nome, String descricao, float preco) throws CreateException {
	} 
	
	/**
	 * @ejb.transaction type="Required"
	 */	
	public abstract void setId(Long id);

	/**
	 * @ejb.persistent-field
	 * @ejb.interface-method
	 * 
	 * @jboss.column-name name="ID"
	 * @ejb.transaction type="Supports"
	 */	
	public abstract Long getId();

	/**
	 * @ejb.interface-method
	 * @ejb.transaction type="Supports"	
	 */	
	public abstract ProdutoValue getProdutoValue();
	
	/**
	 * @ejb.interface-method
	 * @ejb.transaction type="Required"	
	 */	
	public abstract void setProdutoValue(ProdutoValue p);	
	
	/**
	 * @ejb.interface-method
	 * @ejb.transaction type="Required"	
	 */	
	public abstract void setNome(String nome);
	
	/**
	 * @ejb.persistent-field
	 * @ejb.interface-method
	 * 
	 * @jboss.column-name name="NOME"
	 * @ejb.transaction type="Supports"
	 */		
	public abstract String getNome();
	
	/**
	 * @ejb.interface-method
	 * @ejb.transaction type="Required"	
	 */		
	public abstract void setPreco(float preco);
	
	/**
	 * @ejb.persistent-field
	 * @ejb.interface-method
	 * 
	 * @jboss.column-name name="PRECO"
	 * @ejb.transaction type="Supports"
	 */		
	public abstract float getPreco();	
	
	/**
	 * @ejb.interface-method
	 * @ejb.transaction type="Required"	
	 */		
	public abstract void setDescricao(String desc);
	
	/**
	 * @ejb.persistent-field
	 * @ejb.interface-method
	 * 
	 * @jboss.column-name name="DESCRICAO"
	 * @ejb.transaction type="Supports"
	 */		
	public abstract String getDescricao();
	
	/**
	 * @see javax.ejb.EntityBean#ejbActivate()
	 */
	public void ejbActivate() {
		log = Logger.getLogger(getClass());
		log.info("Ativando: "+hashCode()+" Entity: "+ctx.getPrimaryKey());
	}

	/**
	 * @see javax.ejb.EntityBean#ejbPassivate()
	 */
	public void ejbPassivate() {
		log.info("Desativando: "+hashCode()+" Entity: "+ctx.getPrimaryKey());
		log = null;
				
	}

	/**
	 * @see javax.ejb.EntityBean#ejbRemove()
	 */
	public void ejbRemove() throws RemoveException {
		log.info("Removendo: "+hashCode()+" Entity: "+ctx.getPrimaryKey());
	}

	/**
	 * @see javax.ejb.EntityBean#ejbStore()
	 */
	public void ejbStore() {
	}

	/**
	 * @see javax.ejb.EntityBean#ejbLoad()
	 */
	public void ejbLoad() {
	}
	
	/**
	 * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
	 */
	public void setEntityContext(EntityContext ctx) {
		this.ctx = ctx;
		//ctx.getPrimaryKey();
		//ctx.getCallerIdentity();
	}

	/**
	 * @see javax.ejb.EntityBean#unsetEntityContext()
	 */
	public void unsetEntityContext() {
		this.ctx = null;
	}

}
