package co.edu.unbosque.controller;

import java.math.BigInteger;

import co.edu.unbosque.model.MultArrays;
import co.edu.unbosque.model.MultBigInteger;
import co.edu.unbosque.view.ViewVentana;

public class Controller {
	
	private ViewVentana vista;
	private MultBigInteger mBigInt;
	private MultArrays mArrays;
	
	public Controller() {
		vista = new ViewVentana();
		mBigInt = new MultBigInteger();
		mArrays = new MultArrays(); 
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
				BigInteger num1 = new BigInteger(vista.leerDato("Ingrese el primer n�mero"));
				BigInteger num2 = new BigInteger(vista.leerDato("Ingrese el segundo n�mero"));
				vista.mostrarInformacion("El resultado de la multiplicaci�n de "+num1+" y "+num2+" es: "+mBigInt.mult(num1, num2));
				break;
			}
			case 2: {
				
				
				break;
			}
			case 3: {
				vista.mostrarInformacion("Ingrese tama�o de la primera matriz n x m");
				int tamX1 = vista.leerDatoInt("Ingrese n");
				int tamY1 = vista.leerDatoInt("Ingrese m");
				if(tamX1>0 && tamY1>0) {
					vista.mostrarInformacion("Ingrese tama�o de la segunda matriz n x m");
					int tamX2 = vista.leerDatoInt("Ingrese n");
					int tamY2 = vista.leerDatoInt("Ingrese m");
					if(tamX2>0 && tamY2>0) {
						if(tamX1==tamY2) {
							mArrays.setMatrizA(new int[tamX1][tamY1]);
							mArrays.setMatrizB(new int[tamX2][tamY2]);
							vista.mostrarInformacion("Ingreso de datos primera matriz");
							if(ingresarMatriz(mArrays.getMatrizA(),tamX1,tamY1).equals("error")) {
								throw new NumberFormatException("array");
							}else{
								vista.mostrarInformacion("Ingreso de datos segunda matriz");
								if(ingresarMatriz(mArrays.getMatrizB(),tamX2,tamY2).equals("error")) {
									throw new NumberFormatException("array");
								}else {
									vista.mostrarInformacion("Ingreso exitoso");
								}	
							}
						}else {
							vista.mostrarInformacion("Matrices incompatibles para multiplicar"
									+ "\nEl n�mero de columnas de la primera debe ser igual al n�mero de filas de la segunda");
						}
					}else {
						vista.mostrarInformacion("Ingrese n�meros enteros mayores a 0");
					}
				}else {
					vista.mostrarInformacion("Ingrese n�meros enteros mayores a 0");
				}		
				break;
			}

			default:
				vista.mostrarInformacion("Ingrese una opci�n contemplada");
			}
		}catch(NumberFormatException e) {
			if(e.getMessage().equals("array")) {
				vista.mostrarInformacion("Ingrese una fila v�lida");
			}else {
				vista.mostrarInformacion("Ingrese un numero entero");
			}
		}
		
	}
	
	public String ingresarMatriz(int[][] matriz,int x, int y) {
		for (int i = 0; i < y; i++) {
			String[] elementos = vista.leerDato("Ingrese los numeros la fila "+(i+1)+" separados por un espacio\n Ej: 1 2 3 4 5").split(" ");
			if(elementos.length==x) {
				String resul = mArrays.agregarFila(matriz, i, elementos, x);
				if(resul.equals("error")) {
					return "error";
				}
			}else {
				return "error";
			}
		}
		return "ok";
	}
	
}
