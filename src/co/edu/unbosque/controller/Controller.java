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
			int opcion = vista.leerDatoInt("Ejercicios Divide y Vencerás"
					+ "\n Digite el número del algoritmo que desea utilizar:"
					+ "\n  1. Multiplicación de enteros largos"
					+ "\n  2. Multiplicación de Matrices (Divide y Vencerás)"
					+ "\n  3. Multiplicación de Matrices (Sin usar Divide y Vencerás)");
			switch (opcion) {
			case 1: {
				BigInteger num1 = BigInteger.valueOf(vista.leerDatoLong("Ingrese el primer número"));
				BigInteger num2 = BigInteger.valueOf(vista.leerDatoLong("Ingrese el segundo número"));
				vista.mostrarInformacion("El resultado de la multiplicación de "+num1+" y "+num2+" es: "+mBigInt.mult(num1, num2));
				break;
			}
			case 2: {
				
				break;
			}
			case 3: {
				
				break;
			}

			default:
				vista.mostrarInformacion("Ingrese una opción contemplada");
			}
		}catch(NumberFormatException e) {
			vista.mostrarInformacion("Ingrese un numero entero");
		}
		
	}
	

}
