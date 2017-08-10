package br.com.fiap;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class TestaLeituraDeObjetos {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("itens.txt"));
		List<Item> itens = (List<Item>) ois.readObject();
		
		for (Item item : itens){
			System.out.println(item);
			System.out.println(item.getNome());
			System.out.println(item.getPreco());
			System.out.println("---------------------");
		}
	}
}
