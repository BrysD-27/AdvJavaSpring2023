/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	02/21/23
 * File:	Factorial
 * Description:	Factorial
 */

import java.math.BigInteger;

public class Factorial {

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        BigInteger n = new BigInteger("13262");
        BigInteger result = factorial(n);
        System.out.println(n + "! = " + result);
    }
}
