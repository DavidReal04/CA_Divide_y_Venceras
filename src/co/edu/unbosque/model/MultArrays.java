package co.edu.unbosque.model;

public class MultArrays {
	
	private int[][] matrizA;
	private int[][] matrizB;
	private int[][] resulNormal;
	private int[][] resulDivyVen;
	
	public MultArrays() {	
		
	}
	
	public int[][] multiplicarDivyVenc() {
		resulDivyVen = new int[matrizA.length][matrizB[0].length];
		
		return resulDivyVen;
	}
	
	public int[][] multiplicarNormal(){
		resulNormal = new int [matrizA.length][matrizB[0].length];
		if (matrizA.length == matrizB[0].length){
			for (int i = 0; i < matrizA.length;i++) {
				for(int j = 0; i < matrizB[0].length;j++) {
					for(int k = 0; k <matrizA[0].length;k++) {
						resulNormal[i][j] = resulNormal[i][j]+(matrizA[i][k]*matrizB[k][j]) ;
					}
				}
			}
		}
		return resulNormal;
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

	public int[][] getResulNormal() {
		return resulNormal;
	}

	public void setResulNormal(int[][] resulNormal) {
		this.resulNormal = resulNormal;
	}

	public int[][] getResulDivyVen() {
		return resulDivyVen;
	}

	public void setResulDivyVen(int[][] resulDivyVen) {
		this.resulDivyVen = resulDivyVen;
	}

}
