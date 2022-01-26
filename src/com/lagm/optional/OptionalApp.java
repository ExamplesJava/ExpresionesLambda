package com.lagm.optional;

import java.util.Optional;

public class OptionalApp {
	/* Permite lidiar con los errores de NullPointerException */
	// No usar en aplicaciones críticas en rendimiento ya que es un poco costoso
	public void probar1(String valor) {
		System.out.println("\nMetodo combinado");
		Optional<String> optionalValor = Optional.ofNullable(valor);
		
		if (optionalValor.isPresent()) {
			optionalValor.get().contains("luis");
		} else {
			System.out.println("Asigne un valor al parámetro");
		}
		
		
		//System.out.println(valor.contains("luis"));
	}
	
	public void probar2(String valor) {
		System.out.println("\nMetodo 2");
		try {
			Optional op = Optional.empty();
			op.get();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void orElse(String valor) {
		System.out.println("\nMetodo orElse");
		Optional<String> optional = Optional.ofNullable(valor);		
		// orElse: Asigna un valor predeterminado en caso éste venga con nulo
		String x = optional.orElse("predeterminado");
		System.out.println(x);
	}

	public void orElseThrow(String valor) {
		System.out.println("\nMetodo orElseThrow");
		// orElseThrow: Si el valor es nulo se puede lanzar una excepción de cualquier tipo
		Optional<String> optional = Optional.ofNullable(valor);
		optional.orElseThrow(NumberFormatException::new); // Usando a través de un método referencia al constructor de la clase NumberFormatException
	}
	
	public void isPresent(String valor) {
		// isPresent: Para verificar que el valor ha sido inicializado o no
		Optional<String> optional = Optional.ofNullable(valor);
		System.out.println(optional.isPresent());
	}
	
	public static void main(String[] args) {
		OptionalApp app = new OptionalApp();
		// app.probar1(null);
		// app.probar2(null);
		// app.orElse(null);
		// app.orElseThrow(null);
		app.isPresent(null);
	}

}
