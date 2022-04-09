package co.edu.unbosque.model;

import java.util.Arrays;

public class MultArrays {
	
	private int[][] matrizA;
	private int[][] matrizB;
	private int[][] resulNormal;
	private int[][] resulDivyVen;
	
	public MultArrays() {	
		
	}
	
	public int[][] multiplicarNormal(){
		resulNormal = new int [matrizA.length][matrizB[0].length];
		for (int i = 0; i < matrizA.length;i++) {
			for(int j = 0; j < matrizB[0].length;j++) {
				for(int k = 0; k < matrizA[0].length;k++) {
					resulNormal[i][j] = resulNormal[i][j]+(matrizA[i][k]*matrizB[k][j]);
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
	
	public int[][] multiplicarDivyVenc(int[][] matrizA, int[][] matrizB){
        int n = matrizA.length;
 
        int[][] resulDivyVen = new int[n][n];
 
        if (n == 1) {
 
        	resulDivyVen[0][0] = matrizA[0][0] * matrizB[0][0];
        }
        
        else {
        	
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            div(matrizA, A11, 0, 0);
            div(matrizA, A12, 0, n / 2);
            div(matrizA, A21, n / 2, 0);
            div(matrizA, A22, n / 2, n / 2);

            div(matrizB, B11, 0, 0);
            div(matrizB, B12, 0, n / 2);
            div(matrizB, B21, n / 2, 0);
            div(matrizB, B22, n / 2, n / 2);

            int[][] M1 = multiplicarDivyVenc(sumaMatrices(A11, A22), sumaMatrices(B11, B22));
            int[][] M2 = multiplicarDivyVenc(sumaMatrices(A21, A22), B11);
            int[][] M3 = multiplicarDivyVenc(A11, restaMatrices(B12, B22));
            int[][] M4 = multiplicarDivyVenc(A22, restaMatrices(B21, B11));
            int[][] M5 = multiplicarDivyVenc(sumaMatrices(A11, A12), B22);
            int[][] M6 = multiplicarDivyVenc(restaMatrices(A21, A11), sumaMatrices(B11, B12));
            int[][] M7 = multiplicarDivyVenc(restaMatrices(A12, A22), sumaMatrices(B21, B22));
            int[][] C11 = sumaMatrices(restaMatrices(sumaMatrices(M1, M4), M5), M7);
            int[][] C12 = sumaMatrices(M3, M5);
            int[][] C21 = sumaMatrices(M2, M4);
            int[][] C22 = sumaMatrices(restaMatrices(sumaMatrices(M1, M3), M2), M6);
            
            sumaTotal(C11, resulDivyVen, 0, 0);
            sumaTotal(C12, resulDivyVen, 0, n / 2);
            sumaTotal(C21, resulDivyVen, n / 2, 0);
            sumaTotal(C22, resulDivyVen, n / 2, n / 2);
        }
        return resulDivyVen;
    }

    public int[][] restaMatrices(int[][] m1, int[][] m2){
        int n = m1.length;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return m;
    }

    public int[][] sumaMatrices(int[][] m1, int[][] m2){
        int n = m1.length;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = m1[i][j] + m2[i][j];
    		}
    	}
        return m;
    }
    
    public void div(int[][] sub1, int[][] sub2, int iB, int jB){
        for (int i1 = 0, i2 = iB; i1 < sub2.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < sub2.length;j1++, j2++) {
                sub2[i1][j1] = sub1[i2][j2];
            }
        }
    }

    public void sumaTotal(int[][] sub1, int[][] sub2, int iB, int jB){
        for (int i1 = 0, i2 = iB; i1 < sub1.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < sub1.length;j1++, j2++) {
                sub2[i2][j2] = sub1[i1][j1];
            }
        }
    }
    
    public int[][] completarMatriz(int[][] matriz, int num) {    	
    	while(potencia2(num)==false) {
    		num++;
    	}
    	int[][] matrizCuadrada=new int[num][num];
    	for(int[] fila: matrizCuadrada) {
    		Arrays.fill(fila, 0);
    	}    	
    	for(int i=0; i<matriz.length ; i++){
    		for (int j = 0; j < matriz[0].length; j++) {
				matrizCuadrada[i][j] = matriz[i][j];
			}
    	}    	
    	return matrizCuadrada;
    }
    
    public boolean potencia2(int num) {
    	while(num!=1) {
    		if(num%2 !=0) {
    			return false;
    		}
    		num = num/2;
    	}
    	return true;
    }
    
    public int getMax(int num1, int num2) {
		if(num1>num2) {
			return num1;
		}
		return num2;
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
