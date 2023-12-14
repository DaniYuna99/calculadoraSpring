package com.jacaranda.calculadora.model;

import java.util.Objects;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Calculadora {

	@NotNull(message="El primer numero no debe de estar vacio")
	@Min(value=0, message="El primer numero debe ser mayor que cero")
	private double num1;
	
	private int operador;
	
	@NotNull(message="El segundo numero no debe de estar vacio")
	@Min(value=0, message="El segundo numero debe ser mayor que cero")
	private double num2;
	
	
	public Calculadora () {}
	
	
	public Calculadora(double num1, int operador, double num2) {
		super();
		this.num1 = num1;
		this.operador = operador;
		this.num2 = num2;
	}


	public double operar () {
		
		double result = 0;
		
		
		if (this.operador == 1) {
			result = this.num1 + this.num2;
			
		}else if (this.operador == 2) {
			result = this.num1 - this.num2;
		}
		
		
		return (result);
	}
	
	
	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public int getOperador() {
		return operador;
	}

	public void setOperador(int operador) {
		this.operador = operador;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}


	
	@Override
	public int hashCode() {
		return Objects.hash(num1, num2, operador);
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculadora other = (Calculadora) obj;
		return Double.doubleToLongBits(num1) == Double.doubleToLongBits(other.num1)
				&& Double.doubleToLongBits(num2) == Double.doubleToLongBits(other.num2) && operador == other.operador;
	}


	@Override
	public String toString() {
		return "Calculadora [num1=" + num1 + ", operador=" + operador + ", num2=" + num2 + "]";
	}
	
	
	
	
	
	
	
	
}
