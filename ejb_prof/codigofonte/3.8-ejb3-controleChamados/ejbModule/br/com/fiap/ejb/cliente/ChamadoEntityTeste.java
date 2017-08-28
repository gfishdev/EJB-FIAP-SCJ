package br.com.fiap.ejb.cliente;

import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.ejb.Chamado;
import br.com.fiap.ejb.ChamadoRemote;

public class ChamadoEntityTeste {

	public static void main(String[] args) {

		Context context;
		try {
			context = new InitialContext();

			ChamadoRemote chamadoRemote = (ChamadoRemote) context.lookup("ChamadoBean/remote");
			
			Chamado chamado = new Chamado();
			chamado.setDescricao("ramal " + new Random().nextInt(500) + " esta mudo.");
			
			chamadoRemote.cadastrar(chamado);
			System.out.println("Quantidade de chamados abertos: " + chamadoRemote.recuperarTodos().size());

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
