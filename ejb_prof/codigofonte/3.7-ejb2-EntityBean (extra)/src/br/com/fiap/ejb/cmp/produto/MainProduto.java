package br.com.fiap.ejb.cmp.produto;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.NamingException;

public class MainProduto {
	public static void main(String[] args) throws NamingException, NumberFormatException, RemoteException, CreateException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		
		/*
		 * Pode-se utilizar o remote facade...
		 * Exercício a cargo do leitor...
		 */
		ProdutoHome home = 
			ProdutoUtil.getHome(props);
		
		Produto p = home.create( Long.parseLong(args[0]));
		p.setNome(args[1]);
		System.out.println(p.getNome());
	}
}
