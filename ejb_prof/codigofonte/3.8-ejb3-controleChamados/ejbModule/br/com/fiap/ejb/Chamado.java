package br.com.fiap.ejb;

import java.io.Serializable;

public class Chamado implements Serializable {

	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
