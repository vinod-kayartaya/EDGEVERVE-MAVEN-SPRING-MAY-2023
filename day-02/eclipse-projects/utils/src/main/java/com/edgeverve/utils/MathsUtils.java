package com.edgeverve.utils;

public final class MathsUtils {

	private MathsUtils() {
	}

	public static long factorial(int number) {
		
		long f = 1;
		while (number > 1) {
			f *= number--;
		}
		
		return f;
	}
}
