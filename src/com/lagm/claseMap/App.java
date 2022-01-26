package com.lagm.claseMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class App {
	private Map<Integer, String> map;
	
	public void poblar() {
		map = new HashMap<>();
		map.put(1, "Luis");
		map.put(2, "Alberto");
		map.put(3, "Guisado");
	}
	
	public void imprimirV7() {
		for (Entry<Integer, String> e: map.entrySet()) {
			System.out.println("Llave: " + e.getKey() + " Valor: " + e.getValue());
		}
		
	}
	
	public void imprimirV8() {
		// Forma 1
		// map.forEach((k, v) -> System.out.println("Llave: " + k + " Valor: " + v));
		
		// Forma 2
		map.entrySet().stream().forEach(System.out::println);
		map.entrySet().stream().forEach(x -> System.out.println("Llave: " + x.getKey() + " Valor: " + x.getValue()));
	}
	
	public void recolectar() {
		System.out.println("Recolectar...");
		// Se reconstruye un nuevo mapa
		Map<Integer, String> mapaRecolectado = map.entrySet()
				.stream()
				.filter(e -> e.getValue().contains("uis"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
		mapaRecolectado.forEach((k, v) -> System.out.println("Llave: " + k + " Valor: " + v));
	}
	
	public void insertarSiAusente() {
		// putIfAbsent: Agregar un valor si no se encuentra el key
		map.putIfAbsent(2, "Mena");
	}
	
	public void operarSiPresente() {
		map.computeIfPresent(3, (k, v) -> k + v); // Se le pasa el key
		System.out.println(map.get(3));
	}
	
	public void obtenerOrPredeterminado() {
		String valor = map.getOrDefault(5, "Valor por defecto"); // Si el key no existe en el mapa se le asigna un valor por defecto
		System.out.println(valor);
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.poblar();
		app.imprimirV7();
		app.insertarSiAusente();
		app.operarSiPresente();
		app.imprimirV8();
		app.obtenerOrPredeterminado();
		app.recolectar();
	}
}

