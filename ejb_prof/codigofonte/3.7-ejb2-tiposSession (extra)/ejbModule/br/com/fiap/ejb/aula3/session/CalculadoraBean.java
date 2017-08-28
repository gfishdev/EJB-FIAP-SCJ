package br.com.fiap.ejb.aula3.session;
import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


public class CalculadoraBean implements SessionBean {


	public void ejbActivate() throws EJBException, RemoteException {
		
	}

	public void ejbPassivate() throws EJBException, RemoteException {
		
	}

	public void ejbRemove() throws EJBException, RemoteException {
		
	}


	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		
	}

	public void ejbCreate() {
	}
	
		
	
	//metodos de negocio abaixo
	
	/**
	 * soma de 2 numeros
	 * 
	 * @param numero1
	 * @param numero2
	 */
	public long somar(long numero1, long numero2) {
		return numero1 + numero2;
	}
}
