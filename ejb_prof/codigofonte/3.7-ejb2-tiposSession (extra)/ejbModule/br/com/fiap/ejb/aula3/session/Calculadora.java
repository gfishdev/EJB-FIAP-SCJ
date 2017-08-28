package br.com.fiap.ejb.aula3.session;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface Calculadora extends EJBObject{
	
	public long somar(long numero1, long numero2) throws RemoteException;
	
}
