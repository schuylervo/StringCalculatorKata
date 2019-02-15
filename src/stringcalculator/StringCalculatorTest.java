package stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	void test1() {
		String actual= StringCalculator.add(""); //original code did not return "0".  Fixed by concatenating all strings to include "0," 
		assertEquals("0", actual); // which caused "0" to be added if no string input is received without impacting other cases.
	}
	
	@Test
	void test2() {
		String actual= StringCalculator.add("7"); //testing small positive integers. Need to convert int value (7) to string value ("7") before returning by using Integer.toString() method.
		assertEquals("7", actual);
	}
	
	@Test
	void test3() {
		String actual= StringCalculator.add("100"); //testing larger positive integers
		assertEquals("100", actual);
	}
	
	@Test
	void test4() {
		String actual= StringCalculator.add("2,3"); // requires implementing parseInt method and generating a sum of the ints before returning.
		assertEquals("5", actual);
	}
	
	@Test
	void test5() {
		String actual= StringCalculator.add("1,100");
		assertEquals("101", actual);
	}
	
	@Test
	void test6() {
		String actual= StringCalculator.add("1, 100"); // test extra white spaces in the middle of the string -- fixed by changing split.(",") to split.("\\s*,\\s*")
		assertEquals("101", actual);
	}
	
	@Test
	void test7() {
		String actual= StringCalculator.add("  1, 100   "); // test extra white spaces at the beginning or end of the string -- fixed by adding .trim() method
		assertEquals("101", actual);
	}
	
	@Test
	void test8() {
		String actual= StringCalculator.add("7.5, 8.1"); // test for double values - fixed by adding if-else statement and running parseDouble instead of parseInt if a double is detected
		assertEquals("15.6", actual);
	}
	
	@Test
	void test9() {
		String actual= StringCalculator.add("7.5, 8"); // test for cases where one double and one int are used.
		assertEquals("15.5", actual);
	}
	
	@Test
	void test10() {
		String actual= StringCalculator.add("875,00"); //testing cases with double zero entered
		assertEquals("875", actual);
	}
	
	@Test
	void test11() {
		String actual= StringCalculator.add("089,23"); //testing cases with leading zero entered.
		assertEquals("112", actual);
	}
	
	@Test
	void test12() {
		String actual= StringCalculator.add("500 ,089"); //testing cases with leading zero entered and space.
		assertEquals("589", actual);
	}

	@Test
	void test13() {
		String actual= StringCalculator.add("1\n2, 3"); //newline separator
		assertEquals("6", actual);
	}
/*	@Test               //tried to run this test but need to generate "Number expected but '\n' found at position 6" rather than assert equality
	void test13() {
		String actual= StringCalculator.add("175.2,\n35"); 
		assertFalse();
	} */
	
	
}
