package com.revature.tier1;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		String stringNumber = String.valueOf(num);
		int length = stringNumber.length();
		char[] digits = stringNumber.toCharArray();
		int sumOfPower = 0;
		for(int i = 0; i<digits.length; i++) {
			int intDigit = Character.getNumericValue(digits[i]);
			sumOfPower += Math.pow(intDigit, length);
		}
		if(sumOfPower==num) {
			return true;
		}
		return false;
	}
}
