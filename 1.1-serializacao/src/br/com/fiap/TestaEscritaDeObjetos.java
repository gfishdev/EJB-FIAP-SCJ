package br.com.fiap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestaEscritaDeObjetos {

	public static void main(String[] args) throws IOException {

		//pattern DECORATOR (FileOutputStream muda o comportamento de ObjectOutputStream)
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"itens.txt"));

		Item item1 = new Item();
		item1.setNome("Doril");
		item1.setPreco(3.0);
		System.out.println(item1);

		Item item2 = new Item();
		item2.setNome("Dorflex");
		item2.setPreco(5.0);
		System.out.println(item2);

		List<Item> itens = new ArrayList<Item>();
		itens.add(item1);
		itens.add(item2);

		oos.writeObject(itens);
		oos.close();
	}

}
