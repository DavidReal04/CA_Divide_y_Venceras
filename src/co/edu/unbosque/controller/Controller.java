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
			int opcion = vista.leerDatoInt("Ejercicios Divide y Vencerás"
					+ "\n Digite el número del algoritmo que desea utilizar:"
					+ "\n  1. Multiplicación de enteros largos"
					+ "\n  2. Multiplicación de Matrices (Divide y Vencerás)"
					+ "\n  3. Multiplicación de Matrices (Sin usar Divide y Vencerás)");
			switch (opcion) {
			case 1: {
				BigInteger num1 = new BigInteger(vista.leerDato("Ingrese el primer número"));
				BigInteger num2 = new BigInteger(vista.leerDato("Ingrese el segundo número"));
				vista.mostrarInformacion("El resultado de la multiplicación de "+num1+" y "+num2+" es: "+mBigInt.mult(num1, num2));
				break;
			}
			case 2: {
				vista.mostrarInformacion("Ingrese tamaño de la primera matriz n x m");
				int fila1 = vista.leerDatoInt("Ingrese filas");
				int col1 = vista.leerDatoInt("Ingrese columnas");
				if(col1>0 && fila1>0) {
					vista.mostrarInformacion("Ingrese tamaño de la segunda matriz n x m");
					int fila2 = vista.leerDatoInt("Ingrese filas");
					int col2 = vista.leerDatoInt("Ingrese columas");
					if(col2>0 && fila2>0) {
						mArrays.setMatrizA(new int[fila1][col1]);
						mArrays.setMatrizB(new int[fila2][col2]);
						vista.mostrarInformacion("Ingreso de datos primera matriz");
						if(ingresarMatriz(mArrays.getMatrizA(),col1,fila1).equals("error")) {
							throw new NumberFormatException("array");
						}else{
							vista.mostrarInformacion("Primera Matriz\n"+matriz_String(mArrays.getMatrizA()));
							vista.mostrarInformacion("Ingreso de datos segunda matriz");
							if(ingresarMatriz(mArrays.getMatrizB(),col2,fila2).equals("error")) {
								throw new NumberFormatException("array");
							}else {
								vista.mostrarInformacion("Segunda Matriz\n"+matriz_String(mArrays.getMatrizB()));
								vista.mostrarInformacion("Ingreso exitoso");
								if(fila1!=fila2 || col1!=col2 || (fila1==col1 && mArrays.potencia2(fila1)==false) || (fila2==col2 && mArrays.potencia2(fila2)==false)) {
									int maxFila = mArrays.getMax(fila1, fila2);
									int maxCol = mArrays.getMax(col1, col2);
									int tamMax = mArrays.getMax(maxFila, maxCol);
									mArrays.setMatrizA(mArrays.completarMatriz(mArrays.getMatrizA(), tamMax));
									mArrays.setMatrizB(mArrays.completarMatriz(mArrays.getMatrizB(), tamMax));
								}
								int [][] resul = mArrays.multiplicarDivyVenc(mArrays.getMatrizA(),mArrays.getMatrizB());
								
								vista.mostrarInformacion("Matriz resultante\n"+matriz_String(resul));
							}
						}
					}else {
						vista.mostrarInformacion("Ingrese números enteros mayores a 0");
					}
				}else {
					vista.mostrarInformacion("Ingrese números enteros mayores a 0");
				}
				break;
			}
			case 3: {
				vista.mostrarInformacion("Ingrese tamaño de la primera matriz n x m");
				int fila1 = vista.leerDatoInt("Ingrese filas");
				int col1 = vista.leerDatoInt("Ingrese columnas");
				if(col1>0 && fila1>0) {
					vista.mostrarInformacion("Ingrese tamaño de la segunda matriz n x m");
					int fila2 = vista.leerDatoInt("Ingrese filas");
					int col2 = vista.leerDatoInt("Ingrese columas");
					if(col2>0 && fila2>0) {
						if(col1==fila2) {
							mArrays.setMatrizA(new int[fila1][col1]);
							mArrays.setMatrizB(new int[fila2][col2]);
							vista.mostrarInformacion("Ingreso de datos primera matriz");
							if(ingresarMatriz(mArrays.getMatrizA(),col1,fila1).equals("error")) {
								throw new NumberFormatException("array");
							}else{
								vista.mostrarInformacion("Primera Matriz\n"+matriz_String(mArrays.getMatrizA()));
								vista.mostrarInformacion("Ingreso de datos segunda matriz");
								if(ingresarMatriz(mArrays.getMatrizB(),col2,fila2).equals("error")) {
									throw new NumberFormatException("array");
								}else {
									vista.mostrarInformacion("Segunda Matriz\n"+matriz_String(mArrays.getMatrizB()));
									vista.mostrarInformacion("Ingreso exitoso");									
									mArrays.multiplicarNormal();
									vista.mostrarInformacion("Matriz resultante\n"+matriz_String(mArrays.getResulNormal()));
								}	
							}
						}else {
							vista.mostrarInformacion("Matrices incompatibles para multiplicar"
									+ "\nEl número de columnas de la primera debe ser igual al número de filas de la segunda");
						}
					}else {
						vista.mostrarInformacion("Ingrese números enteros mayores a 0");
					}
				}else {
					vista.mostrarInformacion("Ingrese números enteros mayores a 0");
				}		
				break;
			}

			default:
				vista.mostrarInformacion("Ingrese una opción contemplada");
			}
		}catch(NumberFormatException e) {
			if(e.getMessage().equals("array")) {
				vista.mostrarInformacion("Ingrese una fila válida");
			}else {
				vista.mostrarInformacion("Ingrese un numero entero");
			}
		}
		
	}
	
	public String ingresarMatriz(int[][] matriz,int col, int fila) {
		try {
			for (int i = 0; i < fila; i++) {
				String[] elementos = vista.leerDato("Ingrese los numeros la fila "+(i+1)+" separados por un espacio\n Ej: 1 2 3 4 5").split(" ");
				if(elementos.length==col) {
					String resul = mArrays.agregarFila(matriz, i, elementos, col);
					if(resul.equals("error")) {
						return "error";
					}
				}else {
					return "error";
				}
			}
		}catch(NullPointerException e) {return "error";}
		return "ok";
	}
	
	public String matriz_String(int[][] matriz) {
		String resul="[";
		for (int[] x : matriz) {
			String aux="(";
			for (int i : x) {
				aux+=" "+i;
			}
			resul+=aux+" ), ";
		}
		return resul = resul.substring(0,resul.length()-2)+"]";
	}
	
}
