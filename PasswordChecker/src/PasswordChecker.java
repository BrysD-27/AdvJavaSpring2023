import java.io.File;

import java.math.BigInteger;

import java.util.Scanner;

public class PasswordChecker {

public static void main(String[] args) throws Exception{

Scanner sc = new Scanner(new File("D:\\Documents\\AdvJavaSpring2023\\PasswordChecker\\src\\BigIntPrimes.txt"));

int count=0;

while(sc.hasNextLine()) {

BigInteger bi= new BigInteger(sc.nextLine().trim());

if(isPrime(bi)) {

System.out.println(bi.toString());

count++;

}

}

System.out.print("Total number of Primes "+count);
	System.exit(1);
}

private static boolean isPrime(BigInteger number) {
	   //check via BigInteger.isProbablePrime(certainty)
    if (!number.isProbablePrime(5))
        return false;

    //check if even
    BigInteger two = new BigInteger("2");
    if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
        return false;

    //find divisor if any from 3 to 'number'
    for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //start from 3, 5, etc. the odd number, and look for a divisor if any
        if (BigInteger.ZERO.equals(number.mod(i))) //check if 'i' is divisor of 'number'
            return false;
    }
    return true;
}
}