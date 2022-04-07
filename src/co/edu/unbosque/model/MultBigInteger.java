package co.edu.unbosque.model;

import java.math.BigInteger;

public class MultBigInteger {
	
	public MultBigInteger() {}	
	
	public BigInteger mult(BigInteger u, BigInteger v) {	
		int n = getMax(String.valueOf(u).length(),String.valueOf(v).length());
		if(n < String.valueOf(Long.MAX_VALUE).length()) {
			return u.multiply(v);
		}else {
			int s = n/2;
			BigInteger w = u.divide(new BigInteger("10").pow(s));
			BigInteger x = u.mod(new BigInteger("10").pow(s));
			BigInteger y = v.divide(new BigInteger("10").pow(s));
			BigInteger z = v.mod(new BigInteger("10").pow(s));
			BigInteger r = mult(w.add(x),y.add(z));
			BigInteger p = mult(w, y);
			BigInteger q = mult(x, z);
			return p.multiply(BigInteger.valueOf(10).pow(2*s)).add((r.subtract(p).subtract(q).multiply(BigInteger.valueOf(10).pow(s)))).add(q);
		}
		
	}
	
	public int getMax(int num1, int num2) {
		if(num1>num2) {
			return num1;
		}
		return num2;
	}
}
