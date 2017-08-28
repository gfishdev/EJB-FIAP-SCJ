package br.com.fiap.ejb.entity;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface ChamadoRemote {
   
   void cadastrar(Chamado chamado);
   public List recuperarTodos();
   public Chamado recuperarPorDescricao(String descricao);

   @Remove 
   void checkout();
}
