package com.lagm.lambda.scopes;

// Se puede alterar el valor de un atributo, ya sea estático o de instancias
public class ScopesAtributoDeClase {

	private static double atributo1;
	private double atributo2;

	public double probarAtributosStaticVariables() {
		Operacion operacion1 = new Operacion() {

			@Override
			public double calcular(double n1, double n2) {
				atributo1 = n1 + n2;
				atributo2 = atributo1;
				return atributo1;
			}
		};

		return operacion1.calcular(3, 2);

	}

	public double probarAtributosStaticVariables2() {
		Operacion operacion2 = (x, y) -> {
			atributo1 = x + y;
			atributo2 = atributo1;
			return atributo1;
		};

		return operacion2.calcular(3, 2);
	}

	public static void main(String[] args) {
		ScopesAtributoDeClase app = new ScopesAtributoDeClase();
		System.out.println(app.probarAtributosStaticVariables());
		System.out.println(app.probarAtributosStaticVariables2());
	}
}
