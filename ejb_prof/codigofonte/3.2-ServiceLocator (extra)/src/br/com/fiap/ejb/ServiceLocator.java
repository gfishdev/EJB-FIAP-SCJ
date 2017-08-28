package br.com.fiap.ejb;

import javax.ejb.EJBHome;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class ServiceLocator {

	private static ServiceLocator globalInstance = new ServiceLocator();

	/**
	 * Retorna uma instância única de ServiceLocator.
	 * 
	 * @return uma instância única de ServiceLocator.
	 */
	public static ServiceLocator getGlobalInstance() {
		return globalInstance;
	}

	/**
	 * executa lookup de objetos remotos
	 * 
	 * @param jndiName
	 * @param objClass
	 * @return referencia para objeto remoto
	 * @throws NamingException
	 */
	public Object lookup(String jndiName, Class objClass)
			throws NamingException {

		Object obj = null;

		Context context = new InitialContext();

		// obtem referencia do objeto
		EJBHome objref = (EJBHome) context.lookup(jndiName);

		// executa o lookup
		// este trecho de código abaixo é muito custoso!!
		if (EJBHome.class.isAssignableFrom(objClass)) {
			try {
				obj = PortableRemoteObject.narrow(objref, objClass);
			} catch (ClassCastException e1) {
				System.err.println("Erro ao efetuar lookup.");
			}
		}

		return obj;
	}

	/**
	 * executa lookup de objetos remotos
	 * 
	 * @param jndiName
	 * @return referencia para objeto local
	 * @throws NamingException
	 */
	public Object lookup(String jndiName) throws NamingException {

		// EJBLocalHome obj = null;
		Object obj = null;

		Context context = new InitialContext();
		// obtem referencia do objeto
		// obj = (EJBLocalHome) context.lookup(jndiName);
		obj = context.lookup(jndiName);
		return obj;
	}
}
