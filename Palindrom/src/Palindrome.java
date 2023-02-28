import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	02/25/23
 * File:	Palindrome
 * Description:	Palindrome
 */

public class Palindrome {

	public static boolean isPalindrome(String str) {
	    str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
	
	    int left = 0, right = str.length() - 1;
	    while (left < right) {
	        if (str.charAt(left++) != str.charAt(right--)) {
	            return false;
	        }
	    }
	    return true;
	}

    
	public static boolean isStrictPalindrome(String str) {
		str = str.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
	    int left = 0, right = str.length() - 1;
	    while (left < right) {
	        if (str.charAt(left++) != str.charAt(right--)) {
	            return false;
	        }
	    }
	    return true;
	}

    
//    public static String[] readLinesFromFile(String filePath) throws IOException {
//        ArrayList<String> lines = new ArrayList<String>();
//        BufferedReader reader = new BufferedReader(new FileReader(filePath));
//        String line = reader.readLine();
//        while (line != null) {
//            lines.add(line.trim());
//            line = reader.readLine();
//        }
//        reader.close();
//        return lines.toArray(new String[0]);
//    }


    public static void main(String[] args) {
    	System.out.println("Welcome to Palindrome!" + "\n");
    	Scanner input = new Scanner(System.in);
    	
    	while(true) {
        	System.out.println("Enter input to see if it's a palindrome or 0 to exit: ");
        	String palindrome = input.nextLine();
        	if(palindrome.equals("0")) {
        		System.exit(0);
        	}
            if(palindrome.contains(" ")) {
            	if(isStrictPalindrome(palindrome))
            		System.out.println("\n" + "\"" + palindrome + "\" is a strict palindrome." + "\n");
            	else if (isPalindrome(palindrome))
                	System.out.println("\n" + "\"" + palindrome + "\" is a palindrome." + "\n");
            } 
            else if(isPalindrome(palindrome)) {
            	System.out.println("\n" + "\"" + palindrome + "\" is a palindrome." + "\n");
            }
            else {
            	System.out.println("\n" + "\"" + palindrome + "\" is not a palindrome." + "\n");
            }
    	}
    }
}
