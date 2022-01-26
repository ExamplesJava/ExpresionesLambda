package com.lagm.lambda2;

public class LambdaApp {

	public void calcular() {
		Operacion operacion = new Operacion() {
			@Override
			public double calcularPromedio(double a, double b) {
				return (a + b) / 2;
			}
		};
		
		double calculo = operacion.calcularPromedio(2, 3);
		System.out.println(calculo);
	}
	
	public void calcular2() {
		Operacion operacion = (double x, double y) -> (x + y) / 2;
		System.out.println(operacion.calcularPromedio(2, 3));
	}
	
	

	public static void main(String[] args) {
		LambdaApp lambda = new LambdaApp();
		lambda.calcular();
		lambda.calcular2();
	}

}
