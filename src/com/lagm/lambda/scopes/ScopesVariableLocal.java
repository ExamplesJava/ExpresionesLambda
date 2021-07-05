package com.lagm.lambda.scopes;

// Las variables locales solo serán de lectura dentro de las expresiones lambda (también dentro de las clases anónimas)
public class ScopesVariableLocal {
	public double probarLocalVariable() {
		final double n3 = 3; // Es opcional asignar "final"
		Operacion operacion = new Operacion() { // Clase anónima
			
			@Override
			public double calcular(double n1, double n2) {
				// Una variable local n3 Puede usarse dentro de una clase anónima pero solo en modo lectura
				return n1 + n2 + n3; 
			}
		};
		
		return operacion.calcular(1, 1);
	}
	
	public double probarLocalVariable2() {
		double n3 = 3; // Variable local debe ser final para usarse dentro de una expresión lambda. Es opcional asignar "final"
		Operacion operacion = (x, y) -> {
			// Una variable local n3 Puede usarse dentro de una expresión Lambda
			return x + y + n3;
		};
		
		return operacion.calcular(1, 1);
	}
	
	public static void main(String[] args) {
		ScopesVariableLocal app = new ScopesVariableLocal();
		System.out.println(app.probarLocalVariable());
		System.out.println(app.probarLocalVariable2());
	}
}
