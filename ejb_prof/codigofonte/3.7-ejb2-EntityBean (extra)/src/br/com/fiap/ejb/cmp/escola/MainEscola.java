package br.com.fiap.ejb.cmp.escola;

import java.util.Properties;


/**
 * Simples main...
 * 
 * Created on Apr 13, 2003
 *
 */
public class MainEscola {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		
		/*
		 * Pode-se utilizar o remote facade...
		 * Exercício a cargo do leitor...
		 */
		GerenciadorCurso gerenciador = GerenciadorCursoUtil.getHome(props).create();
		
		System.out.println("Cadastrando professores...");
		gerenciador.cadastrarProfessor("Jose");
		gerenciador.cadastrarProfessor("Luiz");
		gerenciador.cadastrarProfessor("Maria");
		
		System.out.println("Cadastrando cursos...");
		gerenciador.cadastrarCurso("Matematica", "Jose");
		gerenciador.cadastrarCurso("Fisica", "Jose");
		gerenciador.cadastrarCurso("Portugues", "Maria");
		gerenciador.cadastrarCurso("Historia", "Luiz");
		gerenciador.cadastrarCurso("Geografia", "Luiz");
		
		System.out.println("Cadastrando Estudante...");
		gerenciador.cadastrarEstudante("Carlos", "Matematica");
		gerenciador.cadastrarEstudante("Roberto", "Historia");
		gerenciador.cadastrarEstudante("Pedro", "Portugues");
		
		System.out.println("Professores do Carlos: ");
		System.out.println( gerenciador.nomeProfessoresDadoAluno("Carlos") );
	}
}
