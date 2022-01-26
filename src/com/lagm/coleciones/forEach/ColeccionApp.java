package com.lagm.coleciones.forEach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ColeccionApp {
	private List<String> lista;
	
	public void llenarLista() {
		lista = new ArrayList<>();
		lista.add("a");
		lista.add("b");
		lista.add("c");
		lista.add("d");
		lista.add("e");
		lista.add("f");
	}
	
	public void usarForEach() {
		// Forma tradicional
		/*System.out.println("Forma 1");
		for (String elemento : lista) {
			System.out.println(elemento);
		}*/
		
		// expresión lambda
		/*System.out.println("Forma 2");
		lista.forEach(x -> System.out.println(x));*/
		
		// Método de referencias
		System.out.println("Forma 3");
		lista.forEach(System.out::println);
	}
	
	public void userRemoveIf() {
		// Forma tradicinal
		/*System.out.println("Remove forma tradicional");
		Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			if (it.next().equalsIgnoreCase("c")) {
				it.remove();
			}	
		}*/
		
		// Paradigma funcional
		lista.removeIf(elemento -> elemento.equalsIgnoreCase("a"));
	}
	
	public void usarSortAscendente() {
		// Forma tradicional
		// Collections.sort(lista);
		
		// Usando expresión lambda
		lista.sort((x, y) -> x.compareTo(y));
	}
	
	public void usarSortDescendente() {
		// Forma tradicional
		/*Collections.sort(lista, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});*/
		
		// Usando expresión lambda
		lista.sort((x, y) -> y.compareTo(x));
	}
	
	public static void main(String[] args) {
		ColeccionApp app = new ColeccionApp();
		app.llenarLista();
		app.usarForEach();
		app.userRemoveIf();
		app.usarForEach();
		app.usarSortAscendente();
		app.usarForEach();
		app.usarSortDescendente();
		app.usarForEach();
	}
}
