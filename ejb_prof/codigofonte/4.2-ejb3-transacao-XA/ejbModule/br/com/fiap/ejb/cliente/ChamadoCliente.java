package br.com.fiap.ejb.cliente;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.fiap.ejb.Chamado;
import br.com.fiap.ejb.Chamado1;
import br.com.fiap.ejb.ChamadoRemote;

public class ChamadoCliente {

	public static void main(String[] args) {

		try {
			Context context = new InitialContext();
			ChamadoRemote chamadoRemote = (ChamadoRemote) context.lookup("ChamadoBean/remote");
			
			Chamado chamado = new Chamado();
			chamado.setDescricao("ramal 001 ficou mudo.");
			
			Chamado1 chamado1 = new Chamado1();
			chamado1.setDescricao("ramal 002 ficou mudo.");
			
			chamadoRemote.cadastrar(chamado, chamado1);
			
			System.out.println("Cadastro ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
	}
}
