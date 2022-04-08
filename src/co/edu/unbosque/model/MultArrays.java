package co.edu.unbosque.model;

public class MultArrays {
	
	private int[][] matrizA;
	private int[][] matrizB;
	
	public MultArrays() {	
		
	}
	
	public int[][] multiplicarNormal(int[][] matriz1, int[][] matriz2){
		int [][] matrizsol = new int [matriz1.length][matriz2[0].length];
		if (matriz1.length == matriz2[0].length){
			for (int i = 0; i < matriz1.length;i++) {
				for(int j = 0; i < matriz2[0].length;j++) {
					for(int k = 0; k <matriz1[0].length;k++) {
						matrizsol[i][j] = matrizsol[i][j]+(matriz1[i][k]*matriz2[k][j]) ;
					}
				}
			}
		}
		return matrizsol;
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
