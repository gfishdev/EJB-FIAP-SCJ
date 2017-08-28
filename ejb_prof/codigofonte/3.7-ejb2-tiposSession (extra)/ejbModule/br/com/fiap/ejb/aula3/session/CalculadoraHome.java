package br.com.fiap.ejb.aula3.session;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface CalculadoraHome extends EJBHome {

	Calculadora create() throws RemoteException, CreateException;
}
