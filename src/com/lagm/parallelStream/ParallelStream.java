package com.lagm.parallelStream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
	/* Puede mejorar/rendimiento de algunas aplicaciones. 
	 * Abuscar del ParallelStream no es recomendable especialmente al trabajar en aplicaciones con Java EE container */
	
	// Caso de estudio: https://www.overops.com/blog/benchmark-how-java-8-lambdas-and-streams-can-make-your-code-5-times-slower/
	List<Integer> numeros;

	public void llenar() {
		numeros = new ArrayList<>();
		for (int i = 0; i < 10; ++i) {
			numeros.add(i);
		}
	}

	public void probarStream() {
		numeros.stream().forEach(System.out::println);
		// El uso de stream es secuencial
	}

	public void probarParalelo() {
		// Nos apoyamos con hilos. Procesamiento asíncrono
		numeros.parallelStream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		ParallelStream app = new ParallelStream();
		app.llenar();
		// app.probarStream();
		app.probarParalelo();
	}
}
