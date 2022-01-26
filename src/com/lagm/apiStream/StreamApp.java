package com.lagm.apiStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApp {
	private List<String> lista;
	private List<String> numeros;

	public StreamApp() {
		lista = new ArrayList<>();
		lista.add("Luis");
		lista.add("Lourdes");
		lista.add("Jorge");
		lista.add("Carmen");
		lista.add("Manuel");

		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
		numeros.add("3");
	}
	
	public void filtrar() {
		// Forma tradicional
		for (String elemento : lista) {
			if (elemento.startsWith("L")) {
				System.out.println(elemento);
			}
		}
		
		// Api Stream
		// List<String> listaFiltrada = lista.stream().filter(elemento -> elemento.startsWith("L")).collect(Collectors.toList());
		//listaFiltrada.forEach(elemento -> System.out.println(elemento));
		
		// lista.stream().filter(x -> x.startsWith("L")).forEach(x -> System.out.println(x));
		lista.stream().filter(x -> x.startsWith("L")).forEach(System.out::println);
	}
	
	public void ordenarAscendente() {
		lista.stream().sorted().forEach(System.out::println);
	}
	
	public void ordenarDescendente() {
		// También es válido usar el método sort de Collections, pasandole una expresión lambda a Comparator
		lista.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
	}
	
	public void transformar() {
		lista.stream().map(x -> x.toUpperCase()).forEach(System.out::println);
		
		// Transforma a mayúsculas
		// Recuperando el arreglo transformado
		List<String> listaMayusculas = lista.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
		List<String> listaMinusculas = lista.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
		System.out.println("Mayusculas: " + listaMayusculas);
		System.out.println("Minusculas: " + listaMinusculas);
		
		numeros.stream().map(x -> Integer.parseInt(x) * 2).forEach(System.out::println);
		
		// Recuperando el array
		System.out.println(numeros);
		List<Integer> enteros = numeros.stream().map(x -> (Integer.parseInt(x) + 5)).collect(Collectors.toList());
		System.out.println(enteros);
	}
	
	public void limitar() {
		// Se limita a los dos primeros elementos
		System.out.println("Limitar");
		lista.stream().limit(2).forEach(System.out::println);
	}
	
	public void contar() {
		// Cuenta todos los elementos
		System.out.println("Cantidad: lista.stream().count()");
		long countL = lista.stream().filter(x -> x.startsWith("L")).count();
		System.out.println("Cantidad de nombres que empiezan con L: " + countL);
	}
	
	public static void main(String[] args) {
		StreamApp app = new StreamApp();
		app.filtrar();
		app.ordenarAscendente();
		app.ordenarDescendente();
		app.transformar();
		app.limitar();
		app.contar();
	}

}
