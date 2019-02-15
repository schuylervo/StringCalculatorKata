package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
	
	public static String add(String number) {
		number = "0," + number; 
		
		if (number.contains("\n")) {
			number = number.replace("\n",",");
		}
		
		if (number.contains(",,")) { //used to generate "Number expected but '\n' found at position 6" when input = "175.2,\n35"
			for (int i = number.length()-1; i>=1; i--) {
				if (number.charAt(i) ==(',')) {
					System.out.println("Number expected but '\n' found at position" + i);
					break;
				}
			}
			return "";
		}
		
		String []numberSplit = number.split("\\s*,\\s*");   // Split the input string.
		
		
		
		if(number.contains(".")) { 	// check to see if the string is a double, and if so, do this
			double sum = 0.0;
			for (String input : numberSplit) {  // loop through all the number in the string array
				Double n = Double.parseDouble(input.trim());  // parse each number string into a double value
				sum += n;     // sum the numbers
			}
			return Double.toString(sum); //return the summed double value as a string
		}
		
		else {   // else, use code for if string is an int
		
			int sum = 0;
			for (String input : numberSplit) {  // loop through all the number in the string array
					Integer n = Integer.parseInt(input.trim());  // parse each number string into an integer value
					sum += n;     // sum the numbers
					
			}
			return Integer.toString(sum); // return the summed integer value as a string
		}
			
		
	}
	
	
}
