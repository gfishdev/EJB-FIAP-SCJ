package br.com.fiap.ejb;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface HistoricoRemote {
   
   public void cadastrar(Historico historico) throws Exception;

   @Remove 
   void checkout();
}
