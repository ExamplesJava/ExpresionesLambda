package com.lagm.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaApp {

	private static List<String> lista = new ArrayList<>();

	static {
		lista.add("Mitocode");
		lista.add("Code");
		lista.add("Mito");
	}

	public static void main(String[] args) {

		LambdaApp app = new LambdaApp();

		app.recorrer(lista);
		app.ordenar1(); // Paradigma imperativo
		app.ordenar2(); // Paradigma funcional (declarativo)
		
		app.calcular1(); // Paradigma imperativo
		app.calcular2(); // Usando expresiones lambda, enfoque declarativo
	}
	
	public void calcular1() {
		/* Las interfaces no se pueden instanciar
		 * Hacemos uso de una clase anónima que sobrescriba el método de la interfaz */
		Operacion operacion = new Operacion() {
			@Override
			public double calcularPromedio(double n1, double n2) {
				return (n1 + n2) / 2;
			}
		};
		
		System.out.println(operacion.calcularPromedio(2, 3));
	}
	
	public void calcular2() {
		// Todo aquello que se hace con clases anónimas se puede implementar con expresiones lambda
		Operacion operacion = (double x, double y) -> (x + y) / 2;
		operacion.calcularPromedio(2, 3);
		
		System.out.println(operacion.calcularPromedio(2, 3));
	}

	public void ordenar1() {
		Collections.sort(lista, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		recorrer(lista);
	}

	public void ordenar2() {
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
		recorrer(lista);

		Collections.sort(lista, (String p1, String p2) -> p2.compareTo(p1));
		recorrer(lista);
	}

	public void recorrer(List<String> lista) {
		System.out.println("\n");
		for (String elemento : lista) {
			System.out.println(elemento);
		}
	}
}
