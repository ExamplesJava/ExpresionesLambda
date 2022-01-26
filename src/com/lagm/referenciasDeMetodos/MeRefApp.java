package com.lagm.referenciasDeMetodos;

import java.util.Arrays;

public class MeRefApp {
	
	public static void referenciarMetodoStatic() {
		System.out.println("Método referido static");
	}
	
	public void referenciarMetodoInstanciaObjectoArbitrario() {
		String nombres[] = {"Luis", "Jorge", "Lourdes", "James", "Jasmin", "Angelo", "Felix"};
		// Manera tradicional: Usando clases anónimas
		/*Arrays.sort(nombres, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
			
		});*/
		
		// Usando expresiones lambda		
		// Arrays.sort(nombres, (s1, s2) -> s1.compareTo(s2));
		// System.out.println(Arrays.toString(nombres));
		
		// Usando referencias a métodos
		Arrays.sort(nombres, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(nombres));
	}
	
	public void referenciarMetodoInstanciaObjectoParticular() {
		System.out.println("Método referido instancia de un objeto en particular");
	}
	
	public void referenciarConstructor() {
		// Método tradicional
		IPersona iper = new IPersona() {
			@Override
			public Persona crear(int id, String nombre) {
				return new Persona(id, nombre);
			}
		};
		Persona persona1 = iper.crear(1, "Luis");
		System.out.println(persona1);
		
		// Usando expresiones lambda
		// IPersona iper2 = (int id, String nombre) -> new Persona(id, nombre);
		IPersona iper2 = (x, y) -> new Persona(x, y);
		Persona persona2 = iper2.crear(2, "Lourdes");
		System.out.println(persona2);
		
		// Usando referencias a Constructor
		IPersona iper3 = Persona::new;
		Persona persona3 = iper3.crear(3, "James");
		System.out.println(persona3);
	}
	
	public void operar() {
		Operacion operacion = () -> MeRefApp.referenciarMetodoStatic();
		operacion.saludar();
		
		// Usando referencia de métodos (o métodos referenciados)
		Operacion operacion2 = MeRefApp::referenciarMetodoStatic;
		operacion2.saludar();
	}
	
	public static void main(String[] args) {
		MeRefApp app = new MeRefApp();
		app.operar();
		app.referenciarMetodoInstanciaObjectoArbitrario();
		Operacion op = app::referenciarMetodoInstanciaObjectoParticular;
		op.saludar();
		app.referenciarConstructor();
	}
}
