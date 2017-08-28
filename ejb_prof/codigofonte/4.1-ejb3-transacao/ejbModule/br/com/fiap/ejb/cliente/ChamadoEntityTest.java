package br.com.fiap.ejb.cliente;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.ejb.Chamado;
import br.com.fiap.ejb.ChamadoRemote;
import br.com.fiap.ejb.Historico;

public class ChamadoEntityTest {

	public static void main(String[] args) {

		Context context;
		try {
			context = new InitialContext();

			ChamadoRemote chamadoRemote = (ChamadoRemote) context.lookup("ChamadoBean/remote");
			
			Chamado chamado = new Chamado();
			chamado.setDescricao("problema no ramal 6855.");
			
			Historico historico = new Historico();
			historico.setDescricao("ruído excessivo");
			
			chamadoRemote.cadastrar(chamado, historico);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
