package br.com.fiap.ejb.entity;

import javax.persistence.PrePersist;

public class ChamadoListener {
	
	@PrePersist
	public void preInsert(Object object) {
		System.out.println("Inserindo " + object.getClass() + " no banco de dados.");
	}
}
