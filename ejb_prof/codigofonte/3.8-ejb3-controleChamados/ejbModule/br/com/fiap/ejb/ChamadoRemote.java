package br.com.fiap.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface ChamadoRemote {
   
   void cadastrar(Chamado chamado);
   public List recuperarTodos();

   @Remove 
   void checkout();
}
