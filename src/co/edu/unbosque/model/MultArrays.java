package co.edu.unbosque.model;

public class MultArrays {
	
	private int[][] matrizA;
	private int[][] matrizB;
	
	public MultArrays() {	
		
	}
	
	public String agregarFila(int[][] matriz, int numFila, String[] elementos, int tamX) {
		try{
			for (int i=0;i<tamX;i++) {
				matriz[i][numFila] = Integer.parseInt(elementos[i]);
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
