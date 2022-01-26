package com.lagm.lambda.sintaxis;

public class Sintaxis {
	
	public double probarSintaxis0() {
		Operacion operacion = (x, y) -> (x + y) / 2;
		return operacion.calcularPromedio(2, 3);
	}
	
	public double probarSintaxis() {
		Operacion operacion = (double x, double y) -> (x + y) / 2;
		return operacion.calcularPromedio(2, 3);
	}
	
	public double probarSintaxis2() {
		Operacion operacion = (double x, double y) -> { return (x + y) / 2; };
		return operacion.calcularPromedio(2, 3);
	}
	
	// Expresiones lambda con más de una línea: usar llaves para el bloque del cuerpo
	public double probarSintaxis3() {
		Operacion operacion = (double x, double y) -> { 
			double a = 2.0;
			System.out.println(a);
			return (x + y) / 2;
		};
		return operacion.calcularPromedio(2, 3);
	}
	
	// Expresión lambda sin parámetros
	public double probarSintaxis4() {
		Operacion2 operacion = () -> {
			int x = 2;
			int y = 3;
			return x + y;
		};
		
		return operacion.calcularPromedio();
	}

	public static void main(String[] args) {
		Sintaxis sintaxis = new Sintaxis();
		System.out.println(sintaxis.probarSintaxis0());
		System.out.println(sintaxis.probarSintaxis());
		System.out.println(sintaxis.probarSintaxis2());
		System.out.println(sintaxis.probarSintaxis3());
	}
}
