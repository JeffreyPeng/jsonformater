package peng;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

public class Try1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object  o = new BigDecimal("234324");
		int i = 2;
		BigInteger bi = new BigInteger(100, new Random(new Date().getTime()));
		System.out.format("that is '%s'", bi);
		BigInteger bi2 = BigInteger.probablePrime(100, new Random(new Date().getTime()));
		System.out.println();
		System.out.printf("that is '%s'", bi2);
	}

}
