package co.edu.unbosque.model;

import java.math.BigInteger;

public class MultBigInteger {
	
	public MultBigInteger() {
		
	}

	public BigInteger mult(BigInteger u, BigInteger v) {
		
		int n = getMax(u.bitLength(),v.bitLength() );
		if(n<Integer.MAX_VALUE) {
			return u.multiply(v);
		}else {
			int s = n/2;
			BigInteger w = u.divide(BigInteger.valueOf(10).pow(s));
			BigInteger x = u.mod(BigInteger.valueOf(10).pow(s));
			BigInteger y = v.divide(BigInteger.valueOf(10).pow(s));
			BigInteger z = v.mod(BigInteger.valueOf(10).pow(s));
			return mult(w,y).multiply(BigInteger.valueOf(10^(2*s))).add((mult(w,z)).add(mult(x,y)).multiply(BigInteger.valueOf(10^s))).add(mult(x,z));
		}
		
	}
	
	public int getMax(int num1, int num2) {
		if(num1>num2) {
			return num1;
		}
		return num2;
	}
}
