package co.edu.unbosque.model;

public class MultArrays {
	
	private int[][] matrizA;
	private int[][] matrizB;
	private int[][] resul;
	
	public MultArrays() {	
		
	}
	
	public int[][] mult(int col1, int fila1, int col2, int fila2) {
		resul = new int[fila1][col2];
		
		return resul;
	}
	
	public String agregarFila(int[][] matriz, int numFila, String[] elementos, int col) {
		try{
			for (int i=0;i<col;i++) {
				matriz[numFila][i] = Integer.parseInt(elementos[i]);
			}
		}catch(NumberFormatException e) {
			return "error";
		}
		return "ok";
	}

	public int[][] getMatrizA() {
		return matrizA;
	}

	public void setMatrizA(int[][] matrizA) {
		this.matrizA = matrizA;
	}

	public int[][] getMatrizB() {
		return matrizB;
	}

	public void setMatrizB(int[][] matrizB) {
		this.matrizB = matrizB;
	}

}
