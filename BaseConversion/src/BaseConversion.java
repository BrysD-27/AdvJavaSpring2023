/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	01/21/23
 * File:	Magic 8 Ball
 * Description:	Magic 8 Ball
 */

import java.math.BigInteger;
import java.util.Scanner;

public class BaseConversion {
	static Scanner input = new Scanner(System.in);
	static String number;
	static int intBase;
	static int desBase;
	
	public static boolean isValidInteger(String value, int base) {
		char chDig;
		
		for(int i = 0; i < value.length(); i ++) {
			chDig = value.toUpperCase().charAt(i);
			if(Character.isDigit(chDig) && (chDig - '0') >= base) {
				System.out.println("Can't have digit " + chDig + " in base " + base);
				return false;
			} else if(Character.isLetter(chDig) && (chDig - 'A') + 10 >= base) {
				System.out.println("Can't have digit " + chDig + " in base " + base);
				return false;
			} else if(!Character.isDigit(chDig) && !Character.isLetter(chDig)) {
				System.out.println("Invalid digit character " + chDig);
				return false;
			}
		}
		return true;
	}
	
	public static String convertInteger(String value, int intBase, int finalBase) {
		if(isValidInteger(value, intBase)) {
			if(intBase < 2 || intBase > 36) {
				System.out.println("Invalid initial Base!!");
				System.exit(1);
			} else if(finalBase < 2 || finalBase > 36) {
				System.out.println("Invalid final Base!!");
				System.exit(1);
			}
		} else {
			System.exit(1);
		}
		
		// Not quite able to figure this part out by converting the value from the intBase into a BigInteger
		// Then converting that BigInteger into a string of the value in the finalBase
		
		return "Nothing at the moment";
	}
	
	public static void main(String[] args) {
		String[] parameters = new String[3];
		
		System.out.println("Welcome to the Base Conversion Program!");
		System.out.println("Enter the number, initial base and desired base: ");
		String lines = input.nextLine();
		
		while(lines.isEmpty()) {
			System.out.println("No parameters entered, please try again: ");
			lines = input.nextLine();
		}
		
		parameters = lines.trim().split(" ");
		if(parameters.length > 3)
			System.out.println("Extra parameters ignored...");
		
		number = parameters[0];
		
		if(parameters.length >= 2) {
			intBase = Integer.parseInt(parameters[1]);
		}
		else {
			System.out.println("Please enter in the initial base: ");
			intBase = input.nextInt();
		}
		if(parameters.length == 3) {
			desBase = Integer.parseInt(parameters[2]);
		}
		else {
			System.out.println("Please enter in the desired base: ");
			desBase = input.nextInt();
		}		
				
		System.out.println(convertInteger(number, intBase, desBase));
	}
}
