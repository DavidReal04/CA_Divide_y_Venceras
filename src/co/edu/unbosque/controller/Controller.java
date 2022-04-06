package co.edu.unbosque.controller;

import java.math.BigInteger;

import co.edu.unbosque.model.MultBigInteger;
import co.edu.unbosque.view.ViewVentana;

public class Controller {
	
	private ViewVentana vista;
	private MultBigInteger mBigInt;
	
	public Controller() {
		vista = new ViewVentana();
		mBigInt = new MultBigInteger();
		ejecutar();
	}
	
	public void ejecutar() {
		try {
			int opcion = vista.leerDatoInt("Ejercicios Divide y Vencer�s"
					+ "\n Digite el n�mero del algoritmo que desea utilizar:"
					+ "\n  1. Multiplicaci�n de enteros largos"
					+ "\n  2. Multiplicaci�n de Matrices (Divide y Vencer�s)"
					+ "\n  3. Multiplicaci�n de Matrices (Sin usar Divide y Vencer�s)");
			switch (opcion) {
			case 1: {
				BigInteger num1 = BigInteger.valueOf(vista.leerDatoLong("Ingrese el primer n�mero"));
				BigInteger num2 = BigInteger.valueOf(vista.leerDatoLong("Ingrese el segundo n�mero"));
				vista.mostrarInformacion("El resultado de la multiplicaci�n de "+num1+" y "+num2+" es: "+mBigInt.mult(num1, num2));
				break;
			}
			case 2: {
				
				break;
			}
			case 3: {
				
				break;
			}

			default:
				vista.mostrarInformacion("Ingrese una opci�n contemplada");
			}
		}catch(NumberFormatException e) {
			vista.mostrarInformacion("Ingrese un numero entero");
		}
		
	}
	

}
