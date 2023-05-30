package com.edgeverve.utils.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.edgeverve.utils.MathsUtils;

class MathsUtilsFactorialTests {

	@Test
	void shouldGetFactorialProperly() {
		int input = 5;
		long expected= 120;
		long actual = MathsUtils.factorial(input);
		
		Assertions.assertEquals(expected, actual);
	}
}
