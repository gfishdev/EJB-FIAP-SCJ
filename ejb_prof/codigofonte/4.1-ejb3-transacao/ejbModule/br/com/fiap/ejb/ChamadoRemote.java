package br.com.fiap.ejb;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface ChamadoRemote {
   
   public void cadastrar(Chamado chamado, Historico historico) throws Exception;

   @Remove 
   void checkout();
}
