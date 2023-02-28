
import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

public class Test {
	
		public static void main(String[] args) throws IOException {

			// Path to file

			File file = new File("D:\\Documents\\AdvJavaSpring2023\\Puzzle Reader\\src\\palindromes.txt");

			// read the file

			FileReader fr = new FileReader(file);

			// create a character input stream

			BufferedReader br = new BufferedReader(fr);

			// construct a string buffer

			StringBuffer sb = new StringBuffer();

			String line;

			// create counters

			int palindrome = 0;

			int strictPalindrome = 0;

			int notPalindrome = 0;

			// loop until last line in file

			while ((line = br.readLine()) != null) {

			// check if string is strict palindrome

			if (isStrictPalindrome(line))

			// if yes, increment counter

			strictPalindrome++;

			// check if string is palindrome but not strict

			else if (isPalindrome(line))

			// if yes, increment counter

			palindrome++;

			else

			// otherwise increase counter for not palindrome

			notPalindrome++;

			}

			fr.close(); // closes the stream and release the resources

			System.out.println(palindrome + " strings are palindrome but not strict.");

			System.out.println(strictPalindrome + " strings are strict palindrome.");

			System.out.println(notPalindrome + " strings are not palindrome.");

			}

			private static boolean isStrictPalindrome(String line) {

			// return if reverse of string

			// and original string matches with same cases

			return line.equals(reverse(line));

			}

			private static boolean isPalindrome(String line) {

			// return if reverse of string

			// and original string matches ignoring same cases

			return line.equalsIgnoreCase(reverse(line));

			}

			// this method will reverse a string

			public static String reverse(final String line) {

			final StringBuilder builder = new StringBuilder(line);

			for (int i = 0; i < builder.length() / 2; i++) {

			final char tmp = builder.charAt(i);

			final int otherEnd = builder.length() - i - 1;

			builder.setCharAt(i, builder.charAt(otherEnd));

			builder.setCharAt(otherEnd, tmp);

			}

			// return reversed string

			return builder.toString();

			}

}
