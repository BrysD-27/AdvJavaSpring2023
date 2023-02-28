/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	02/09/23
 * File:	Sieve Of Eratosthenes
 * Description:	Sieve of Eratosthenes
 */

import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void sieveOfEratosthenesAlgo(boolean[] primes, int startVal, int stopVal) {
		for (int x = 0; x <= stopVal; x++) {
				primes[x] = true;
		}

		for (int i = 2; i * i <= stopVal; i++) {
			if (primes[i] == true) {
				for(int n = i * i; n <= stopVal; n += i) {
					primes[n] = false;
				}
			}
		}
		
		int primeCount = 0;
		for(int z = startVal; z <= stopVal; z++) {
			if(primes[z] == true) {
				System.out.println(z + " ");
				primeCount++;
			}
		}
		System.out.println("Total Number of Primes between " + startVal +" and " + stopVal +" is " + primeCount);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int startVal;
		int stopVal;
		
		System.out.println("Welcome to The Sieve of Eratosthenes!");
		
		if(args.length == 1) {
			startVal = Integer.parseInt(args[0]);
			stopVal = Integer.parseInt(args[1]);
		} else {
			System.out.println("Enter the start value > 1: ");
			startVal = input.nextInt();
			System.out.println("Enter the stop value: ");
			stopVal = input.nextInt();
		}
		
		boolean[] primes = new boolean[stopVal + 1];
		sieveOfEratosthenesAlgo(primes, startVal, stopVal);
		}

}
