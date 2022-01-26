package com.lagm.interfaz;

// Una interfaz funcional es aquella que define una única operación (un solo método)
@FunctionalInterface // Anotación java 8 para definir interfaces funcionales
public interface Operacion {
	double calcular(double n1, double n2);
}
